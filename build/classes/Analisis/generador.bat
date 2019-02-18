SET JFLEX_HOME= C:\libs\jflex-1.7.0\lib
cd C:\Users\erick\Documents\NetBeansProjects\HT1\src\Analisis\
java -jar %JFLEX_HOME%\jflex-full-1.7.0.jar scanner.flex
pause

SET JFLEX_HOME= C:\libs\java-cup-11b
cd C:\Users\erick\Documents\NetBeansProjects\HT1\src\Analisis\
java -jar %JFLEX_HOME%\java-cup-11b.jar -parser parser parser.cup
pause