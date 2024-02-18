#!/bin/bash

javac -d bin --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls ./src/*.java
java --class-path bin --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls ./src/Executable.java