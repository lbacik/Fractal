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
 * @version 0.1 ALFA (prototype)
 *
 * @author Lukasz Bacik <mail@luka.sh>
 */
package sh.luka.fractal;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.Random;

/**
 * Iterated Function System implementation.
 * http://en.wikipedia.org/wiki/Iterated_function_system
 *
 *
 * @author Lukasz Bacik <mail@luka.sh>
 */
public abstract class FractalIFS extends Fractal {

    protected int Iteration_minor = 0;
    protected int Iteration_major = 0;
    protected volatile int Iteration_minor_current;
    protected volatile int Iteration_major_current;

    /**
     * This method define the IFS ratio (AA .. AF) (see inner class
     * Transformation definition)
     *
     * @return
     */
    protected abstract Transformation getTransformation();

    /**
     * @todo color
     *
     * @return
     */
    protected BufferedImage draw() {

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, IMG_TYPE);
        ColorModel model = image.getColorModel();
        WritableRaster raster = image.getRaster();

        Color fcolor;

        double x1, x = 0;
        double y = 0;

        int[] AZ = {0x0, 0xffffff};
        fcolor = new Color(AZ[1]);

        Transformation t = getTransformation();

        // Scaling
        double[] scale = getScale();
        double xl = scale[0];
        double yl = scale[1];
        double xr = scale[2];
        double yr = scale[3];

        double A = WIDTH / (xr - xl);
        double B = -A * xl;
        double C = HEIGHT / (yl - yr);
        double D = -C * yr;

        Random random = new Random();
        int RAND = 0;

        for (int j = 0; j <= Iteration_major; j++) {
            for (int i = 0; i <= Iteration_minor; i++) {

                Iteration_major_current = j;
                Iteration_minor_current = i;

                RAND = random.nextInt(t.MIP);

                x1 = t.AA[RAND] * x + t.AB[RAND] * y + t.AE[RAND];
                y = t.AC[RAND] * x + t.AD[RAND] * y + t.AF[RAND];
                x = x1;

                // a point on canvas
                int x2 = (int) (A * x + B);
                int y2 = (int) (C * y + D);

                if (x2 < WIDTH && y2 < HEIGHT && x2 >= 0 && y2 >= 0) {
                    raster.setDataElements(x2, y2,
                            model.getDataElements(fcolor.getRGB(), null));
                }

            }
        }

        return image;
    }

    public int[] getIteration() {
        int[] result = {Iteration_minor, Iteration_major};
        return result;
    }

    public void setIteration(int minor, int major) {
        Iteration_minor = minor;
        Iteration_major = major;
    }

    public int getCurrent() {

        double unit = ((Iteration_major + 1) * (Iteration_minor + 1)) / Target_value;
        double current = ((Iteration_major_current + 1) * (Iteration_minor_current + 1)) / unit;

        return (int) current;
    }

    protected class Transformation {

        public Transformation(int nMIP,
                double[] nAA, double[] nAB, double[] nAC,
                double[] nAD, double[] nAE, double[] nAF) {

            MIP = nMIP;
            AA = nAA;
            AB = nAB;
            AC = nAC;
            AD = nAD;
            AE = nAE;
            AF = nAF;
        }

        public int MIP;
        public double[] AA;
        public double[] AB;
        public double[] AC;
        public double[] AD;
        public double[] AE;
        public double[] AF;
    }
}
