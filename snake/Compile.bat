@ECHO OFF
echo - - - - - - - - - - - - - - - - - - -
echo COMPILING HELPER CLASSES
echo - - - - - - - - - - - - - - - - - - -
javac -d "classes" src/se/markusmaga/lth/pt/helper/*.java
echo - - - - - - - - - - - - - - - - - - -
echo COMPILING HELPER.menu CLASSES 
echo - - - - - - - - - - - - - - - - - - -
javac -d "classes" src/se/markusmaga/lth/pt/helper/menu/*.java
echo - - - - - - - - - - - - - - - - - - -
echo COMPILING HELPER.options CLASSES 
echo - - - - - - - - - - - - - - - - - - -
javac -Xlint:unchecked -d "classes" src/se/markusmaga/lth/pt/helper/options/*.java
echo - - - - - - - - - - - - - - - - - - -
echo COMPILING snake CLASSES 
echo - - - - - - - - - - - - - - - - - - -
javac -d "classes" src/se/markusmaga/lth/pt/snake/*.java
echo - - - - - - - - - - - - - - - - - - -
pause
