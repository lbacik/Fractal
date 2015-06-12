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

/**
 * The base class for all drawing objects (fractals and... others :))
 *
 * This class is used by DynaLink class to instantiating a fractal object.
 *
 * @author Lukasz Bacik <mail@luka.sh>
 */
public abstract class Fractal implements FractalProgressMonitor {

    /**
     * The width of the resulting graphic in pixels.
     */
    protected int WIDTH;

    /**
     * The height of the resulting graphics in pixels.
     */
    protected int HEIGHT;

    /**
     * The type of the resulting graphics.
     */
    protected int IMG_TYPE;

    /**
     * The value used by ProgressMonitor class as maximum.
     */
    protected int Target_value = 1000;

    /**
     * Scale - defined as an array of four points:
     *
     * 0 & 1 (x1, y1) - left-bottom corner
     * 2 & 3 (x2, y2) - rigth-top corner
     *
     */
    private double[] scale = new double[4];

    /**
     * This method should define default scale of the image/fractal
     *
     * @return
     */
    public abstract double[] defaultScale();

    /**
     * @todo description
     *
     * @return
     */
    protected abstract BufferedImage draw();

    public BufferedImage draw(double[] newScale) {

        setScale(newScale);
        return draw();
    }

    /**
     *  Accessors
     */

    public double[] getScale() {
        return scale;
    }

    public void setScale(double[] newScale) {
        scale = newScale;
    }

    public int getWidth() {
        return WIDTH;
    }

    public void setWidth(int w) {
        WIDTH = w;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public void setHeight(int h) {
        HEIGHT = h;
    }

    public int getTarget() {
        return Target_value;
    }

    /**
     * @todo description
     *
     * @return
     */
    public abstract int getCurrent();
}
