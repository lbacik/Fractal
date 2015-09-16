#!/bin/sh

#
# Unfortunately it looks like we can't execute just jar file because we have to setup the class path to
# made it works correctly...
# 
#java -jar fractal.jar

java -cp 'fractal.jar:fractals:.' sh.luka.fractal.gui 
