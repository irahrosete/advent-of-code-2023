package main.java;

import main.java.day01trebuchet.TrebuchetOne;
import main.java.day01trebuchet.TrebuchetTwo;
import main.java.day02cubeconundrum.CubeConundrumOne;
import main.java.day02cubeconundrum.CubeConundrumTwo;
import main.java.day02cubeconundrum.CubeGame;

import java.io.IOException;
import java.util.List;

import static java.lang.System.out;
import static main.java.utils.UtilAOC.readFileLineToCubeGameArray;

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

        out.println("\n--- Day 02 ---");

        CubeConundrumOne cubeConundrumOne = new CubeConundrumOne();
        Integer possibleGamesValue = cubeConundrumOne.checkPossibleGames(12, 13, 14);
        out.println(possibleGamesValue);

        CubeConundrumTwo cubeConundrumTwo = new CubeConundrumTwo();
        Integer sumPowerOfGames = cubeConundrumTwo.addGamesPower();
        out.println(sumPowerOfGames);
    }
}