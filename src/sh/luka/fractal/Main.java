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
 * !!! This code is still under heavy development !!!
 * (however, as usually - all comments are welcome :))
 *
 * @version 0.1 ALFA (prototype)
 *
 * @author Lukasz Bacik <mail@luka.sh>
 */
package sh.luka.fractal;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import sh.luka.gui.*;

/**
 * This class contain the main logic of the project.
 *
 * @todo add check if we are using sdk
 *
 * @author Lukasz Bacik <mail@luka.sh>
 */
public class Main implements Runnable, Serializable  {

    protected Registry reg;
    public DynaLink fractal = null;
    public BufferedImageSerializable image;
    private Thread savePartialThread = null;

    class SavePartialThread implements Runnable {

        @Override
        public void run() {

            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Thread.sleep(1000 * 60 * reg.savePartialInterval);
                    savePartial();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(SavePartialThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Main(Registry registry) {

        // reg = Registry.create();
        reg = registry;
        image = new BufferedImageSerializable();

    }

    protected DynaLink compile() throws Exception {

        DynaLink dynaLink = new DynaLink();

        if ((dynaLink.compileIt(reg.inFile)) == false) {
            throw new Exception("compilation failed");
        }

        return dynaLink;
    }

    protected void savePartial() {

        ObjectOutputStream out = null;
        FractalIFS fractalObj = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(reg.savePartialFile));
            fractalObj = (FractalIFS)fractal.getInstance();
            out.writeObject(fractalObj);
            // out.writeObject(reg);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        java.util.Date date = new java.util.Date();
        System.out.println(date.toString()
                + " partial save: saved! J: "
                + fractalObj.global_J + ", I: "
                + fractalObj.global_I
        );
    }

    protected boolean restorePartial() {

        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(reg.continueFromFile));

            Fractal fractalObj = (Fractal)in.readObject();
            fractal.setInstance(fractalObj);
            // reg = (Registry)in.readObject();

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return true;
    }

    public BufferedImage run(boolean alwaysCompile) throws Exception {

        BufferedImage image = null;

        if (reg.continueFromFile != null) {
            restorePartial();
        }

        if (reg.savePartialFile != null && reg.savePartialInterval > 0) {
            runSavePartialThread();
        }

        try {

            if (fractal == null /*|| alwaysCompile == true*/) {
                // if(fractal != null) dispose fractal; /* ??? */
                fractal = compile();
                if (reg.useDefaulScale == true) {
                    image = fractal.runIt(reg.drawingClassName);
                } else {
                    image = fractal.runIt(reg.drawingClassName, reg.scale);
                }

            } else {

                if (reg.useDefaulScale == false) {
                    image = fractal.getInstance().draw(reg.scale);
                }

            }

        } finally {

            // finish the save partial thread
            if (savePartialThread != null) {
                savePartialThread.interrupt();
            }
            // delete save partial file
        }

        return image;
    }

    /*
     public BufferedImage run() throws Exception {
     return run(true);
     }
     */
    public void run() {
        try {
            image.image = run(true);
        } catch (Exception e) {
            System.out.println("Main.run() exception: " + e.getMessage());
        }
    }

	// this check will be done in Registry class
    // protected boolean load();
    protected void save(BufferedImage image) throws IOException {
        ImageIO.write(image, "png", new File(reg.outFile + ".png"));
    }

    protected void save(BufferedImage image, String fileName) throws IOException {
        String org = reg.outFile;
        reg.outFile = fileName;
        save(image);
        reg.outFile = org;
    }

    public boolean set_scale(int i) {
        boolean result = false;
        reg.scale = reg.series.get_scale(i);
        if (reg.scale != null) {
            result = true;
        }
        return result;
    }

    public int[] get_iteration_values(int i) {
        int[] result;
        result = reg.series.get_iteration_values(i);
        return result;
    }

    private void runSavePartialThread() {

        Runnable r = new SavePartialThread();
        savePartialThread = new Thread(r);
        savePartialThread.start();
    }
}
