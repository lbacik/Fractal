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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/**
 *
 * @todo documentation!
 *
 * @author Lukasz Bacik <mail@luka.sh>
 */
public class SeriesParserTxt extends SeriesParser {

    protected int linelength = 6;

    public ArrayList<double[]> parse(String fileName) {

        ArrayList<double[]> result = new ArrayList<double[]>();
        String s;
        InputStream input = null; // raw byte-stream
        Reader r = null; // cooked reader
        BufferedReader br = null; // buffered for readLine()
        try {
            input = new FileInputStream(fileName);
            r = new InputStreamReader(input, "UTF-8"); // leave charset out for default
            br = new BufferedReader(r);
            ArrayList<double[]> tmp = new ArrayList<double[]>();
            int line = 1;
            while ((s = br.readLine()) != null) {
                // parse double into double[] from s
                String[] t = s.split("\\s+");
                if (t.length > 0 && !t[0].equals("") && !t[0].equals("#")) {
                    if (t.length < linelength) {
                        throw new Exception("line " + line + " too short!");
                    }

                    double[] d = new double[linelength + 1];
                    for (int i = 0; i <= linelength; i++) {
                        d[i] = Double.parseDouble(t[i]);
                    }
                    tmp.add(d);
                }
                line++;
            }
            result = tmp;
        } catch (Exception e) {
            System.err.println(e.getMessage()); // handle exception
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Throwable t) { /* ensure close happens */ }
            }
            if (r != null) {
                try {
                    r.close();
                } catch (Throwable t) { /* ensure close happens */ }
            }
            if (input != null) {
                try {
                    input.close();
                } catch (Throwable t) { /* ensure close happens */ }
            }
        }
        return result;
    }
}
