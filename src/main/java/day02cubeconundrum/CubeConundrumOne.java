package main.java.day02cubeconundrum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

//        String combination = transformedGame.get(0).results().get(0).combination();
//        out.println(combination);


        transformedGame.forEach(cubeGame -> {
            out.println(cubeGame.game());
            List<CubeGameResult> combinations = cubeGame.results();

            combinations.forEach(result -> {
            String combination = result.combination();
            // find red, green, blue
            out.println(combination);

            });
        });

        return gameSum;
    }

    private List<CubeGame> transformCubeGameResults(List<CubeGame> initialInput) {
        List<CubeGame> newInputList = new ArrayList<>();

        initialInput.forEach(cubeGame -> {
            List<CubeGameResult> cubeGameResults = new ArrayList<>();

            String delimiter = "; ";
            String results = cubeGame.results().toString();

            Scanner scanner = new Scanner(results);
            scanner.useDelimiter(delimiter);
            scanner.forEachRemaining(res -> {
                CubeGameResult combination = new CubeGameResult(res);
                cubeGameResults.add(combination);
            });

            CubeGame newCubeGame = new CubeGame(cubeGame.game(), cubeGameResults);
            newInputList.add(newCubeGame);
        });

        return newInputList;
    }
}
