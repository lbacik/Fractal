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
import java.io.File;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

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
            } else {
                reg.outFile = reg.drawingClassName;
            }

            f = new File(reg.outFile);
            if (f.exists()) {
                throw new Exception("Output file: " + reg.outFile + " already exists!");
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

        if (reg.processSeries == false) {

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

            reg.useDefaulScale = false;
            int i = 0;
            int major = 0, minor = 0;
            while (main.set_scale(i)) {

                int[] iter = main.get_iteration_values(i);
                minor = iter[0];
                major = iter[1];

                // set iter (major, minor)
                ((FractalIFS) main.fractal.getInstance()).setIteration(minor, major);

                // print some temp diagnostic information
                // i, scale, iteration (major, minor)
                System.out.printf("image: %d", i);
                
                System.out.print("scale: ");
                for (int x = 0; x < reg.scale.length; x++) {
                    System.out.print(reg.scale[x] + " ");
                }
                System.out.println();
                
                System.out.printf("loop values (major, minor): %d, %d", major, minor);
                
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
}
