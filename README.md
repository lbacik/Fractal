Fractal
=======

The program "drawing" fractals (and not only), with cli and gui interfaces.


**TODO:** add more information here!


* Homepage (currently only in polish) http://luka.sh/projekty/fraktale

* Previous repository, with version 0.1: http://www.javaforge.com/project/6214

NOTICE: Version 0.1 is not a part of this repo, it is available only on javaforge.com 

Installation / Compiling 
------------------------

First of all you have do download the Fractal program code - plese use git or just download the zip archive, I assume that you downloaded the code to the "Fractal" directory at your hard drive..

Before compiling the program, we need two libraries (*.jar files).

1. commons-cli-1.2.jar
2. jimageviewer.jar

Where it can be found:

* commons-cli-1.2.jar it is external library, its homepage is at: 
    https://commons.apache.org/proper/commons-cli - currently tested and
    used with Fractal program is version commons-cli-1.2, you can download
    it from [here](http://archive.apache.org/dist/commons/cli/binaries/commons-cli-1.2-bin.tar.gz) - please extract the archive and copy the *.jar
    file to Fractal directory.

* jimageviewer it is a my library that can be found here: https://github.com/lbacik/JImageViewer - please download it, execute "make.sh" to compile it and thus obtained file jimageviewer.jar copy to Fractal directory.

When we already have those two *.jar files (mentioned above) in Fractal directory, we can compile the Fractal program itself - please run the "make.sh" file and after sucessful compilation, the fractal.jar file should appear :)

Now we can use:

    ./fractal.sh -h
    
to check if everything is ok.

You can start the GUI using:

    ./fractal-gui.sh
    

