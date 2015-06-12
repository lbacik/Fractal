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

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 *
 * @author Lukasz Bacik <mail@luka.sh>
 */
interface SeriesParserInterface {

    public ArrayList<double[]> parse(String fileName);
}

/**
 *
 *
 * @author Lukasz Bacik <mail@luka.sh>
 */
public abstract class SeriesParser implements SeriesParserInterface {

    public abstract ArrayList<double[]> parse(String fileName);
}
