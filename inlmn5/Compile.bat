@ECHO OFF
echo - - - - - - - - - - - - - - - - - - -
echo COMPILING HELPER CLASSES
echo - - - - - - - - - - - - - - - - - - -
javac -cp $CLASSPATH:./classes/ -d "classes" src/se/markusmaga/lth/pt/helper/*.java
echo - - - - - - - - - - - - - - - - - - -
echo COMPILING HELPER.menu CLASSES 
echo - - - - - - - - - - - - - - - - - - -
javac -cp $CLASSPATH:./classes/ -d "classes" src/se/markusmaga/lth/pt/helper/menu/*.java
echo - - - - - - - - - - - - - - - - - - -
echo COMPILING HELPER.options CLASSES 
echo - - - - - - - - - - - - - - - - - - -
javac -cp $CLASSPATH:./classes/ -Xlint:unchecked -d "classes" src/se/markusmaga/lth/pt/helper/options/*.java
echo - - - - - - - - - - - - - - - - - - -
echo COMPILING crystal CLASSES 
echo - - - - - - - - - - - - - - - - - - -
javac -cp $CLASSPATH:./classes/ -d "classes" src/se/markusmaga/lth/pt/mandelbrot/*.java
echo - - - - - - - - - - - - - - - - - - -
pause
