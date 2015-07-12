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

import javax.tools.*;
import java.awt.image.BufferedImage;

/**
 *
 *
 * @author Lukasz Bacik <mail@luka.sh>
 */
public class DynaLink {

    public double[] defaultScale = new double[4];
    protected Fractal instance;

    public boolean compileIt(String fileName) {
        boolean res = false;

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(System.in, System.out, System.err, fileName);

        if (result == 0) {
            res = true;
        }

        return res;
    }

    public void instantiateIt(String className) {

        try{
            Class<?> thisClass = Class.forName(className);
            Object iClass = thisClass.newInstance();

            instance = ((Fractal) iClass);
            defaultScale = ((Fractal) iClass).defaultScale();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public BufferedImage runIt(String className, double[] scale) {

        BufferedImage image = null;

        try {

            if(instance == null)
                instantiateIt(className);

            if (scale == null) {
                image = instance.draw(defaultScale);
            } else {
                image = instance.draw(scale);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }

    public BufferedImage runIt(String className) {
        return runIt(className, null);
    }

    public Fractal getInstance() {
        return instance;
    }
}
