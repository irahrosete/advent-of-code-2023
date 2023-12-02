package main.java;

import main.java.Day01Trebuchet.TrebuchetOne;
import main.java.Day01Trebuchet.TrebuchetTwo;

import java.io.IOException;

import static java.lang.System.out;

public class AdventOfCode {
    public static void main(String[] args) throws IOException {
        out.println("Advent Of Code 2023");

        out.println("\n--- Day 01 ---");
        TrebuchetOne trebuchet = new TrebuchetOne();
        Integer calibrationValue = trebuchet.printCalibrationValue();
        out.println(calibrationValue);

        TrebuchetTwo trebuchetTwo = new TrebuchetTwo();
        Integer correctCalibrationValue = trebuchetTwo.printCalibrationValue();
        out.println(correctCalibrationValue);
    }
}