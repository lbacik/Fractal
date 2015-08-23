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

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @todo documentation!
 *
 *
 * @author Lukasz Bacik <mail@luka.sh>
 */
public class Series {

    public ArrayList<double[]> steps;
    protected SeriesParser parser;

    public Series(String fileName) {

        steps = new ArrayList<double[]>();
        parser = new SeriesParserTxt();
        steps = parser.parse(fileName);
    }

    protected double[] get_current_element(int i) {
        double[] result = null;
        int sum_s = 0;
        for (int j = 0; j < steps.size(); j++) {
            double[] p = steps.get(j);
            if (i <= sum_s + p[4]) {

                result = p;
                break;

            } else {

                sum_s = sum_s + (int) p[4];
            }
        }
        return result;
    }

    protected int get_sum_steps(int i) {
        int result = 0;
        for (int j = 0; j < i; j++) {
            double[] p = steps.get(j);
            result = result + (int) p[4];
        }
        return result;
    }

    public double[] get_scale(int i) {
        double[] result = null;
        double[] current = get_current_element(i);
        if (current != null) {
            int curr_index = steps.indexOf(current);
            if (curr_index == 0) {

                result = Arrays.copyOfRange(current, 0, 4);

            } else {
                double[] previous = steps.get(curr_index - 1);
                int sum_s = get_sum_steps(curr_index);
                result = new double[4];
                for (int j = 0; j <= 3; j++) {
                    result[j] = previous[j] + (((current[j] - previous[j]) / current[4]) * (i - sum_s));
                }
            }
        }

        return result;
    }

    public int[] get_iteration_values(int i) {
        // minor, major
        int[] result = {1, 1};

        double[] current = get_current_element(i);
        // current[5] = major
        // current[6] = minor

        if (current != null) {
            int curr_index = steps.indexOf(current);
            if (curr_index == 0) {
                double[] tmp = Arrays.copyOfRange(current, 5, 7);
                result[0] = (int)tmp[0];
                result[1] = (int)tmp[1];
            } else {
                // double[] previous = steps.get(curr_index - 1);
                int sum_s = get_sum_steps(curr_index);
                //result[0] = (int)Math.round(current[5]/current[4]) * (i - sum_s);
                result[0] = (int)current[5];
                result[1] = (int)Math.round(current[6]/current[4]) * (i - sum_s);
            }
        }

        return result;
    }
}
