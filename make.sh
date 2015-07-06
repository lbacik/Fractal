#!/bin/sh
#
#	 make-jar-file

# LIB directory should contain required libraries:
# - commons-cli-1.2.jar
# - jimageviewer.jar

LIB='.'

if [ ! -d tmp ]; then 
	mkdir tmp
else 
#	shouldn't we ask if we can do that? 
	rm -drf tmp/*
fi

javac -d tmp -sourcepath src \
	-cp $LIB/commons-cli-1.2.jar:$LIB/jimageviewer.jar \
	src/sh/luka/fractal/*.java

jar cvfm fractal.jar MANIFEST-ADD.MF -C tmp .

# To run the program, if the required LIBs and fractal.jar are in the same directory, type:
# GUI: java -jar fractal.jar
# CLI: java -cp fractal.jar sh.luka.fractal.cli 
