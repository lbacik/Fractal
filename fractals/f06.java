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

import java.awt.image.BufferedImage;
import sh.luka.fractal.*;
import sh.luka.gui.BufferedImageSerializable;

public class f06 extends FractalIFS {

    public f06() {
        createCanvas(2500, 5000);
        Iteration_minor = 100000;
    }

    protected Transformation getTransformation() {

        int MIP = 4;
        double[] AA = {0, 0.85, 0.2, -0.15};
        double[] AB = {0, 0.04, -0.26, 0.28};
        double[] AC = {0, -0.04, 0.23, 0.26};
        double[] AD = {0.16, 0.85, 0.22, 0.24};
        double[] AE = {0, 0, 0, 0};
        double[] AF = {0, 1.6, 1.6, 0.44};

        Transformation t = new Transformation(MIP, AA, AB, AC, AD, AE, AF);

        return t;
    }

    public double[] defaultScale() {

        // scale for isf
        double[] scale = new double[4];
        // 0 & 1 - it is left-bottom corner
        // 2 & 3 - it is right-top corner
        scale[0] = -3;
        scale[1] = 0;
        scale[2] = 3;
        scale[3] = 10;

        setScale(scale);

        return scale;
    }
}
