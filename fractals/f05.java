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

import sh.luka.fractal.FractalIFS;

// Trójkąt Sierpińskiego
public class f05 extends FractalIFS {

    public f05() {
        WIDTH = 10000;
        HEIGHT = 10000;
        IMG_TYPE = java.awt.image.BufferedImage.TYPE_INT_RGB;
        Iteration_minor = 100000000;
    }

    @Override
    protected Transformation getTransformation() {

        int MIP = 3;

        double[] AA = {0.5, 0.5, 0.5};
        double[] AB = {0, 0, 0};
        double[] AC = {0, 0, 0};
        double[] AD = {0.5, 0.5, 0.5};
        double[] AE = {0, 0, 0.5};
        double[] AF = {0, 1, 0.5};

        Transformation t = new Transformation(MIP, AA, AB, AC, AD, AE, AF);

        return t;
    }

    @Override
    public double[] defaultScale() {

        // scale for isf
        double[] scale = new double[4];
        // 0 & 1 - it is left-bottom corner
        // 2 & 3 - it is right-top corner
        scale[0] = -0.1;
        scale[1] = -0.1;
        scale[2] = 2.1;
        scale[3] = 1.1;

        setScale(scale);

        return scale;
    }
}
