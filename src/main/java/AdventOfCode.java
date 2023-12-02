package main.java;

import main.java.Day01Trebuchet.Trebuchet;

import java.io.IOException;

import static java.lang.System.out;

public class AdventOfCode {
    public static void main(String[] args) throws IOException {
        out.println("Advent Of Code 2023");

        out.println("\n--- Day 01 ---");
        Trebuchet trebuchet = new Trebuchet();
        Integer calibrationValue = trebuchet.printCalibrationValue();
        out.println(calibrationValue);
    }
}