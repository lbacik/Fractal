/*
 * Copyright (C) 2015 Lukasz Bacik <mail@luka.sh>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
/**
 *
 * !!! This code is still under heavy development
 * !!! (however, as usually - all comments are welcome :))
 *
 * @version 0.2 ALFA (prototype)
 *
 * @author Lukasz Bacik <mail@luka.sh>
 */
package sh.luka.fractal;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.List;
import javax.imageio.ImageIO;
import javax.xml.ws.BindingProvider;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import sh.luka.fractal.wsclient.FractalWSImplService;
import sh.luka.fractal.wsclient.FractalWSImpl;

/**
 * Class to handle the cli interface
 *
 *
 * @author Lukasz Bacik <mail@luka.sh>
 */
public class cli {

    protected static Registry reg = null;
    protected static CliParams options;
    protected static CommandLine cmd;

    /**
     * Main class is the project heart.
     */
    protected static Main main;

    /**
     * @param args
     */
    public static void main(String[] args) {

        reg = Registry.create();
        options = new CliParams();
        options.init();

        CommandLineParser parser = new PosixParser();

        try {

            cmd = parser.parse(options, args);
            if (cmd.hasOption("h")) {
                help();
                System.exit(0);
            }

            if (validateInputArgs() == false) {
                throw new Exception("validate error");
            }

            if (cmd.hasOption("show-registry")) {
                reg.show();
            }

            run();

        } catch (ParseException exp) {

            System.out.println("Unexpected parser exception: " + exp.getMessage());

        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.toString() + ", " + e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * Read input args.
     *
     * @return
     * @throws Exception
     */
    protected static boolean validateInputArgs() throws Exception {

        boolean result = false;
        File f;

        try {

            if (cmd.hasOption("d")) {

                reg.inFile = cmd.getOptionValue("d");
                reg.setDrawingClassName();

            } // else throw parametr required

            if (cmd.hasOption("o")) {
                reg.outFile = cmd.getOptionValue("o");
            } else if (reg.drawingClassName != null) {
                reg.outFile = reg.drawingClassName;
            }

            if (reg.outFile != null) {
                f = new File(reg.outFile);
                if (f.exists()) {
                    throw new Exception("Output file: " + reg.outFile + " already exists!");
                }
            }

            if (cmd.hasOption("s")) {

                int i = 0;

                for (String val : cmd.getOptionValue("s").split(";")) {
                    reg.scale[i++] = Double.parseDouble(val);
                }

                if (reg.scale.length != 4) {
                    throw new Exception("validate scale error");
                }

                reg.useDefaulScale = false;
            }

            if (cmd.hasOption("e")) {

                reg.seriesFile = cmd.getOptionValue("e");
                f = new File(reg.seriesFile);
                if (f.exists() && !f.isDirectory()) {

                    reg.processSeries = true;

                } else {
                    throw new Exception("File " + reg.seriesFile + " do not exists!");
                }

            }

            if (cmd.hasOption("w")) {

                reg.seriesNumberWidth = Integer.parseInt(cmd.getOptionValue("w"));
                if (reg.seriesNumberWidth < 1 || reg.seriesNumberWidth > 4) {
                    throw new Exception("validate series number width out of bound");
                }
            }

            if (cmd.hasOption("i")) {
                reg.startIteration = Integer.parseInt(cmd.getOptionValue("i"));
            }

            if (cmd.hasOption("c")) {
                reg.mode = 1;
                reg.wsurl = cmd.getOptionValue("c");
            }

            if (cmd.hasOption("t")) {
                reg.temporary = cmd.getOptionValue("t");
            }

            if (cmd.hasOption("skip-images")) {
                reg.skipImages = true;
            }

            if (cmd.hasOption("token")) {
                reg.token = cmd.getOptionValue("token");
            }

            if (cmd.hasOption("save-partial")) {
                reg.savePartialFile = cmd.getOptionValue("save-partial");
            }

            if (cmd.hasOption("save-partial-interval")) {
                reg.savePartialInterval = Integer.parseInt(cmd.getOptionValue("save-partial-interval"));
            }

            if (cmd.hasOption("continue")) {
                
                String continueFromFile = cmd.getOptionValue("continue");

                f = new File(continueFromFile);
                if (f.exists() && !f.isDirectory()) {

                    reg.continueFromFile = cmd.getOptionValue("continue");

                }
            }

            result = true;

        } catch (NumberFormatException e) {

            System.out.println("Number format exception: " + e.toString() + ", " + e.getMessage());

        }

        return result;
    }

    /**
     * Print help
     *
     */
    protected static void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("fractal", options);
    }

    /**
     * All, what the cli does...
     *
     * @throws Exception
     */
    protected static void run() throws Exception {

        main = new Main(reg);

        if (reg.mode == 1) {

            WSClient(main);

        } else if (reg.processSeries == false) {

            BufferedImage image = main.run(true);
            if (image != null) {
                main.save(image);
            } else {
                throw new Exception("image is null...");
            }

        } else {

            // series of pictures
            reg.series = new Series(reg.seriesFile);
            if (reg.series.steps.size() == 0) {
                throw new Exception("series size is 0...");
            }

            // compile the fractal
            main.fractal = main.compile();
            main.fractal.instantiateIt(reg.drawingClassName);

            reg.useDefaulScale = false;
            int i = reg.startIteration;
            int major = 0, minor = 0;
            while (main.set_scale(i)) {

                int[] iter = main.get_iteration_values(i);
                major = iter[0];
                minor = iter[1];

                // set iter (major, minor)
                ((FractalIFS) main.fractal.getInstance()).setIteration(minor, major);

                // print some temp diagnostic information
                // i, scale, iteration (major, minor)
                System.out.println("image: " + i);

                System.out.print("scale: ");
                for (int x = 0; x < reg.scale.length; x++) {
                    System.out.print(reg.scale[x] + " ");
                }
                System.out.println();

                System.out.println("loop values (major, minor):" + major + ", " + minor);

                BufferedImage image = main.run(false);
                String fileName = String.format(reg.outFile + "-" + "%0" + reg.seriesNumberWidth + "d", i);
                if (image != null) {
                    main.save(image, fileName);
                } else {
                    throw new Exception("image is null...");
                }
                i++;
            }
        }

    }

    // how to generate the service class:
    // http://www.codejava.net/java-ee/web-services/java-web-services-binary-data-transfer-example-base64-encoding
    protected static void WSClient(Main main) throws Exception {

        FractalWSImplService client = new FractalWSImplService(new URL(reg.wsurl));
        FractalWSImpl service = client.getFractalWSImplPort();

        while (service.getSessionID(reg.token) > 0) {

            // download fractal file
            String fractalCode = service.getFractal(reg.token);
            String fractalFileName = service.getFractalFileName(reg.token);

            String tempFile = reg.temporary != null
                    ? reg.temporary + "/" + fractalFileName
                    : fractalFileName;

            Writer out = new BufferedWriter(
                            new OutputStreamWriter(
                                new FileOutputStream(tempFile, false),
                                "UTF-8"
                                )
                            );
            try {
                out.write(fractalCode);
            } finally {
                out.close();
            }

            reg.inFile = tempFile;
            reg.setDrawingClassName();

            if (reg.outFile == null) {
                reg.outFile = reg.drawingClassName;
            }

            main.fractal = main.compile();
            main.fractal.instantiateIt(reg.drawingClassName);

            reg.useDefaulScale = false;

            int i;
            while((i = service.getCurrentIteration(reg.token)) >= 0) {

                List<Integer> fractalIterList = service.getIterationNumbers(reg.token);

                int major = fractalIterList.get(0).intValue();
                int minor = fractalIterList.get(1).intValue();

                ((FractalIFS) main.fractal.getInstance()).setIteration(minor, major);

                List<Double> scaleList = service.getScale(reg.token);

		for (int j = 0; j < scaleList.size(); j++) {
                    reg.scale[j] = scaleList.get(j);
		}

                BufferedImage image = main.run(false);

                if( reg.skipImages == false ) {
                    String fileName = String.format(reg.outFile + "-" + "%0" + reg.seriesNumberWidth + "d", i);
                    if (image != null) {
                        main.save(image, fileName);
                    } else {
                        throw new Exception("image is null...");
                    }
                }

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, "png", baos);
                byte[] imageBytes = baos.toByteArray();

                while (service.uploadImage(reg.token, imageBytes) == false) {
                    System.out.println ("Failed to send image's file...");
                }

                service.finishSuccessIteration(reg.token);

           }
        }
    }
}
