ECHO OFF Date
set datetime=%date%_%time%
set datetime=%datetime: =_%
set datetime=%datetime::=_%
set datetime=%datetime:/=_%
set datetime=%datetime:.=_% 
set datetime=%datetime:,=_% 
set datetime=%datetime: =%

SET "sourceDir=%CD%\test-output\"
SET "sourceFile=emailable-report.html"
SET "finalDir=%CD%\test-output\Execution\"
SET "finalFile=importacionDeProyectos%datetime%.html"

cd resources
CALL getProjects
cd..
CALL executeAnt

copy %sourceDir%%sourceFile% %finalDir%%finalFile%

