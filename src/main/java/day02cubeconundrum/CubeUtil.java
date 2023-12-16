package main.java.day02cubeconundrum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Integer.parseInt;
import static main.java.utils.UtilAOC.transformStringToList;

public class CubeUtil {
    public static List<CubeGame> transformCubeGameResults(List<CubeGame> initialInput) {
        List<CubeGame> newInputList = new ArrayList<>();

        initialInput.forEach(cubeGame -> {
            String results = cubeGame.results().toString();
            List<String> cubeGameResults = transformStringToList(results, "; ");
            CubeGame newCubeGame = new CubeGame(cubeGame.game(), cubeGameResults);
            newInputList.add(newCubeGame);
        });

        return newInputList;
    }

    public static void checkCombi(List<Integer> combination, Integer redCount, Integer greenCount, Integer blueCount,
                                  AtomicReference<String> red, AtomicReference<String> green, AtomicReference<String> blue) {
        if (redCount >= (parseInt(red.toString()))) {
            combination.add(1);
        } else {
            combination.add(0);
        }

        if (greenCount >= (parseInt(green.toString()))) {
            combination.add(1);
        } else {
            combination.add(0);
        }

        if (blueCount >= (parseInt(blue.toString()))) {
            combination.add(1);
        } else {
            combination.add(0);
        }
    }

    public static void arrangeCubeColours(List<String> combination,
                                    AtomicReference<String> red,
                                    AtomicReference<String> green,
                                    AtomicReference<String> blue) {
        combination.forEach(item -> {
            if (item.contains("red")) {
                int redIndex = item.indexOf("red");
                red.set(item.substring(0, redIndex).trim());
            }

            if (item.contains("green")) {
                int greenIndex = item.indexOf("green");
                green.set(item.substring(0, greenIndex).trim());
            }

            if (item.contains("blue")) {
                int blueIndex = item.indexOf("blue");
                blue.set(item.substring(0, blueIndex).trim());
            }
        });
    }
}
