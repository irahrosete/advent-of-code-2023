package main.java.utils;

import main.java.day02cubeconundrum.CubeGame;
import main.java.day02cubeconundrum.CubeGameResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.getNumericValue;

public class UtilAOC {
    public static List<String> readFileLineToStringArray(String filename) throws IOException {
        File file = new File("src/main/resources/" + filename);
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> input = new ArrayList<>();

        String line;
        while((line = br.readLine()) != null) {
            input.add(line);
        }

        br.close();
        return input;
    }

    public static List<CubeGame> readFileLineToCubeGameArray(String filename) throws IOException {
        File file = new File("src/main/resources/" + filename);
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<CubeGame> input = new ArrayList<>();

        String line;
        while((line = br.readLine()) != null) {
            // make line into CubeGame object
            int colonIndex = line.indexOf(":");
            String game = line.substring(5, colonIndex);
            List<CubeGameResult> results = List.of(new CubeGameResult(line.substring(colonIndex + 2)));
            CubeGame cubeGame = new CubeGame(game, results);
            input.add(cubeGame);
        }

        br.close();
        return input;
    }

    public static List<Character> convertStringToCharArray(String string) {
            List<Character> charList = new ArrayList<>();
            char[] ch = string.toCharArray();

            for (char c: ch) {
                charList.add(c);
            }
            return charList;
    }

    public static List<Integer> findIntFromCharArray(List<Character> charArray) {
        List<Integer> numArray = new ArrayList<>();
        charArray.forEach(x -> {
            if (Character.isDigit(x)) {
                numArray.add(getNumericValue(x));
            }
        });
        return numArray;
    }
}
