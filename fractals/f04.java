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

/* Dragon */
public class f04 extends FractalIFS {

    public f04() {
        createCanvas(10000, 10000);
        Iteration_minor = 100000000;
    }

    @Override
    protected Transformation getTransformation() {

        int MIP = 2;

        double[] AA = {0.824074, 0.088272};
        double[] AB = {0.281482, 0.520988};
        double[] AC = {-0.212346, -0.463889};
        double[] AD = {0.864198, -0.377778};
        double[] AE = {-1.88229, 0.78536};
        double[] AF = {-0.110607, 8.095795};

        Transformation t = new Transformation(MIP, AA, AB, AC, AD, AE, AF);

        return t;
    }

    @Override
    public double[] defaultScale() {

        // scale for isf
        double[] scale = new double[4];
        // 0 & 1 - it is left-bottom corner
        // 2 & 3 - it is right-top corner
        scale[0] = -6.5;
        scale[1] = -1.5;
        scale[2] = 6.5;
        scale[3] = 11.5;

        setScale(scale);

        return scale;
    }
}
