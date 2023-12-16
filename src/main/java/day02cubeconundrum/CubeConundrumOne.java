package main.java.day02cubeconundrum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Integer.parseInt;
import static main.java.utils.UtilAOC.readFileLineToCubeGameArray;
import static main.java.utils.UtilAOC.transformStringToList;

public class CubeConundrumOne {
    // scan each line and transform to array of CubeGame objects
    // CubeGame [{game: 1, results: [[2 blue, 4 green, 7 blue, 1 red, 14 green, 5 blue, 13 green, 1 red, 1 red, 7 blue, 11 green]]}, ]
    // transform each results into grouped arrays [2 blue, 4 green][7 blue, 1 red, 14 green][5 blue,  13 green,  1 red][1 red,  7 blue,  11 green]
    // transform each results further into new object Combination
    // Combination {red: 0, green: 4, blue: 7}
    // determine if a combination is allowed by comparing colour values
    // if allowed, mark 1; otherwise, 0
    // flatten all combinations for each CubeGame. if flattened combination does not include 0, add to gameSum array
    // reduce gameSum array to total

    public Integer checkPossibleGames(Integer redCount, Integer greenCount, Integer blueCount) throws IOException {
        List<CubeGame> inputList = readFileLineToCubeGameArray("red-green-blue-game.txt");
        List<CubeGame> transformedGame = transformCubeGameResults(inputList);
        List<Integer> gameSum = new ArrayList<>();

        transformedGame.forEach(cubeGame -> {
            List<String> combinations = cubeGame.results();
            List<List<Integer>> allowedGames = new ArrayList<>();
            List<Integer> flattenedAllowedGames = new ArrayList<>();

            combinations.forEach(result -> {
                AtomicReference<String> redValue = new AtomicReference<String>("0");
                AtomicReference<String> greenValue = new AtomicReference<String>("0");
                AtomicReference<String> blueValue = new AtomicReference<String>("0");

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

//                Combination finalCombination = new Combination(redValue.toString(), greenValue.toString(), blueValue.toString());
//                List<Combination> rgb = new ArrayList<>(Collections.singleton(finalCombination));
//                out.print("rgb: ");
//                out.println(rgb);

                List<Integer> allowedCombi = new ArrayList<>(List.of());
                if (redCount >= (parseInt(redValue.toString()))) {
                    allowedCombi.add(1);
                } else {
                    allowedCombi.add(0);
                }

                if (greenCount >= (parseInt(greenValue.toString()))) {
                    allowedCombi.add(1);
                } else {
                    allowedCombi.add(0);
                }

                if (blueCount >= (parseInt(blueValue.toString()))) {
                    allowedCombi.add(1);
                } else {
                    allowedCombi.add(0);
                }

                allowedGames.add(allowedCombi);

            });

            allowedGames.forEach(flattenedAllowedGames::addAll);
            if (!flattenedAllowedGames.contains(0)) {
                gameSum.add(parseInt(cubeGame.game()));
            }
        });

        return gameSum.stream().reduce(0, Integer::sum);
    }

    private List<CubeGame> transformCubeGameResults(List<CubeGame> initialInput) {
        List<CubeGame> newInputList = new ArrayList<>();

        initialInput.forEach(cubeGame -> {
            String results = cubeGame.results().toString();
            List<String> cubeGameResults = transformStringToList(results, "; ");
            CubeGame newCubeGame = new CubeGame(cubeGame.game(), cubeGameResults);
            newInputList.add(newCubeGame);
        });

        return newInputList;
    }
}
