package main.java.day02cubeconundrum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.System.out;
import static main.java.utils.UtilAOC.readFileLineToCubeGameArray;

public class CubeConundrumOne {
    // scan each line and transform to array of objects
    // Game 1: [{red: 0, green: 0, blue: 0}, {red: 1, green: 1, blue: 1}], Game 2: []
    // loop through each game to find the game #
        // loop through each array to find possible games
            // loop through each object to compare red, green, blue with configuration
    // sum up game #

    // checkPossibleGames(red, green, blue)
    public Integer checkPossibleGames(Integer redCount, Integer greenCount, Integer blueCount) throws IOException {
        List<CubeGame> inputList = readFileLineToCubeGameArray("red-green-blue-game.txt");
        List<CubeGame> transformedGame = transformCubeGameResults(inputList);
        Integer gameSum = 0;

        out.println(transformedGame);
//        String combination = transformedGame.get(0).results().get(3);
//        out.println(combination);


        transformedGame.forEach(cubeGame -> {

            out.println(cubeGame.game());

            List<String> combinations = cubeGame.results();
            AtomicReference<String> redValue = new AtomicReference<String>("0");
            AtomicReference<String> greenValue = new AtomicReference<String>("0");
            AtomicReference<String> blueValue = new AtomicReference<String>("0");

            combinations.forEach(result -> {
                String line = result.replace("[", "");
                line = line.replace("]", "");

                List<String> newCombination = transformStringToList(line, ",");

                newCombination.forEach(item -> {
                    if (item.contains("red")) {
                        int redIndex = item.indexOf("red");
                        redValue.set(item.substring(0, redIndex).trim());
                    }

                    if (item.contains("green")) {
                        int greenIndex = item.indexOf("green");
                        greenValue.set(item.substring(0, greenIndex).trim());
                    }

                    if (item.contains("blue")) {
                        int blueIndex = item.indexOf("blue");
                        blueValue.set(item.substring(0, blueIndex).trim());
                    }
                });

            // compare each colour and return boolean if within
            out.print("redValue: ");
            out.println(redValue);
            out.print("greenValue: ");
            out.println(greenValue);
            out.print("blueValue: ");
            out.println(blueValue);
            });
        });

        return gameSum;
    }

    private List<CubeGame> transformCubeGameResults(List<CubeGame> initialInput) {
        List<CubeGame> newInputList = new ArrayList<>();

        initialInput.forEach(cubeGame -> {
            List<String> cubeGameResults = new ArrayList<>();

            String delimiter = "; ";
            String results = cubeGame.results().toString();

            Scanner scanner = new Scanner(results);
            scanner.useDelimiter(delimiter);
            scanner.forEachRemaining(cubeGameResults::add);

            CubeGame newCubeGame = new CubeGame(cubeGame.game(), cubeGameResults);
            newInputList.add(newCubeGame);
        });

        return newInputList;
    }

     private List<String> transformStringToList(String string, String delimiter) {
         List<String> newObjectList = new ArrayList<>();

         Scanner scanner = new Scanner(string);
         scanner.useDelimiter(delimiter);
         scanner.forEachRemaining(newObjectList::add
         );
         return newObjectList;
     }
}
