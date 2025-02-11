@echo off
javac -d out src\**\*.java
java -cp out main.Main
pause
