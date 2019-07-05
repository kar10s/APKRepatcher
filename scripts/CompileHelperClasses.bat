@echo off
echo %cd%
set sourcesPath=APKRepatcher_lib
set helperPath=APKRepatcher_lib\helper\jadx
echo Creating helper classes...
javac -cp %sourcesPath%\jadx\* %helperPath%\RunProgramJad.java
javac -cp %sourcesPath%\jadx\*;%sourcesPath%\dex\* %helperPath%\RunProgramDex.java
echo Done.
pause