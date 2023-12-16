package main.java.day02cubeconundrum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Integer.parseInt;
import static main.java.day02cubeconundrum.CubeUtil.arrangeCubeColours;
import static main.java.day02cubeconundrum.CubeUtil.transformCubeGameResults;
import static main.java.utils.UtilAOC.readFileLineToCubeGameArray;
import static main.java.utils.UtilAOC.transformStringToList;

public class CubeConundrumTwo {
    public Integer addGamesPower() throws IOException {
        List<CubeGame> inputList = readFileLineToCubeGameArray("red-green-blue-game.txt");
        List<CubeGame> transformedGame = transformCubeGameResults(inputList);
        List<Integer> gameSum = new ArrayList<>();

        int redCount = 0;
        int greenCount = 0;
        int blueCount = 0;

        transformedGame.forEach(cubeGame -> {
            List<String> combinations = cubeGame.results();
            List<Integer> maxReds = new ArrayList<>();
            List<Integer> maxGreens = new ArrayList<>();
            List<Integer> maxBlues = new ArrayList<>();

            combinations.forEach(result -> {
                AtomicReference<String> redValue = new AtomicReference<String>("0");
                AtomicReference<String> greenValue = new AtomicReference<String>("0");
                AtomicReference<String> blueValue = new AtomicReference<String>("0");

                String line = result.replace("[", "");
                line = line.replace("]", "");

                List<String> newCombination = transformStringToList(line, ",");
                arrangeCubeColours(newCombination, redValue, greenValue, blueValue);

                Integer maxRed = Math.max(redCount, (parseInt(redValue.toString())));
                maxReds.add(maxRed);
                Integer maxGreen = Math.max(greenCount, (parseInt(greenValue.toString())));
                maxGreens.add(maxGreen);
                Integer maxBlue = Math.max(blueCount, (parseInt(blueValue.toString())));
                maxBlues.add(maxBlue);
            });

            Integer finalMaxRed = Collections.max(maxReds);
            Integer finalMaxGreen = Collections.max(maxGreens);
            Integer finalMaxBlue = Collections.max(maxBlues);
            Integer gamePower = finalMaxRed * finalMaxGreen * finalMaxBlue;
            gameSum.add(gamePower);
        });

        return gameSum.stream().reduce(0, Integer::sum);
    }
}
