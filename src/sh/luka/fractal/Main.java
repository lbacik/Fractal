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
import java.io.IOException;
import java.io.Serializable;

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

    public BufferedImage run(boolean alwaysCompile) throws Exception {

        BufferedImage image = null;
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
}
