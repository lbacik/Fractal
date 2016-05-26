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
 *
 * @author Lukasz Bacik <mail@luka.sh>
 */
package sh.luka.fractal;

import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

/**
 * @todo add more detailed descriptions
 *
 * @author Lukasz Bacik <mail@luka.sh>
 */
public class CliParams extends Options {

    @SuppressWarnings("static-access")
    public void init() {

        addOption("h", "help", false, "help - this screen");

        addOption(OptionBuilder.withArgName("FILE")
                .withLongOpt("drawing-class")
                .hasArg()
                .withDescription("source file (with .java ext.)/ drawing class file *REQUIRED*")
                // .isRequired()
                .create("d"));

        addOption(OptionBuilder.withArgName("FILE")
                .withLongOpt("out")
                .hasArg()
                .withDescription("png output file (optional, if it is not given the filename the name of the drawing class will be used) ")
                .create("o"));

        addOption(OptionBuilder.withLongOpt("show-registry")
                .withDescription("shows configuration registry")
                .create());

        addOption(OptionBuilder.withArgName("'x1;y1;x2;y2'")
                .withLongOpt("scale")
                .hasArg()
                .withDescription("use given scale")
                .create("s"));

        addOption(OptionBuilder.withArgName("FILE")
                .withLongOpt("series")
                .hasArg()
                .withDescription("...")
                .create("e"));

        addOption(OptionBuilder.withArgName("INT")
                .withLongOpt("series-number-width")
                .hasArg()
                .withDescription("...")
                .create("w"));

        addOption(OptionBuilder.withArgName("INT")
                .hasArg()
                .withDescription("start iteration number (use with series)")
                .create("i"));

        addOption(OptionBuilder.withArgName("URI")
                .withLongOpt("client")
                .hasArg()
                .withDescription("WSDL URL")
                .create("c"));

        addOption(OptionBuilder.withArgName("DIR")
                .withLongOpt("temporary-dir")
                .hasArg()
                .withDescription("")
                .create("t"));

        addOption(OptionBuilder.withLongOpt("skip-images")
                .withDescription("")
                .create());

        addOption(OptionBuilder.withArgName("token")
                .withLongOpt("token")
                .hasArg()
                .withDescription("")
                .create());

        addOption(OptionBuilder.withArgName("FILE")
                .withLongOpt("save-partial")
                .hasArg()
                .withDescription("")
                .create());

        addOption(OptionBuilder.withArgName("FILE")
                .withLongOpt("continue")
                .hasArg()
                .withDescription("")
                .create());

        addOption(OptionBuilder.withArgName("INT")
                .withLongOpt("save-partial-interval")
                .hasArg()
                .withDescription("")
                .create());

    }

}
