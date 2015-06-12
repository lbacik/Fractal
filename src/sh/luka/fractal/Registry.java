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

import java.io.File;

/**
 * Singleton design pattern - use "create" method to get instance of this class.
 *
 * @author Lukasz Bacik <mail@luka.sh>
 */
public class Registry {

    private static Registry reg = null;

    /**
     *
     * @return
     */
    public static Registry create() {

        if (reg == null) {
            reg = new Registry();
        }

        return reg;
    }

    // filename without .java extension
    public String inFile;
    public String outFile;
    public double[] scale = new double[4];
    public boolean useDefaulScale = true;
    public boolean processSeries = false;
    public String drawingClassName;
    public Series series;
    public String seriesFile;
    public int seriesNumberWidth = 1;

    public Registry() {
    }

    public void show() {

        System.out.println("drawingClassName: " + drawingClassName);

        System.out.println("inFile: " + inFile);
        System.out.println("outFile: " + outFile);

        System.out.println("Series File: " + seriesFile);

        System.out.println("Process series: " + (processSeries ? "true" : "false"));
        System.out.println("Use default scale: " + (useDefaulScale ? "true" : "false"));

        System.out.print("scale: ");
        for (int i = 0; i < reg.scale.length; i++) {
            System.out.print(reg.scale[i] + " ");
        }
        System.out.println();

    }

    public void setDrawingClassName() throws Exception {

        File f = new File(inFile);
        if (f.exists() && !f.isDirectory()) {

            String tmp = f.getName();
            reg.drawingClassName = tmp.substring(0, tmp.lastIndexOf("."));

        } else {
            throw new Exception("File " + reg.inFile + " do not exists!");
        }

    }
}
