package main.java.day01trebuchet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static main.java.utils.UtilAOC.*;

public class TrebuchetTwo {
    public Integer printCalibrationValue() throws IOException {

        List<String> inputList = readFileLineToStringArray("calibration-doc.txt");

        List<Integer> intList = new ArrayList<>();

        List<String> newInputList = new ArrayList<>();
        inputList.forEach(line -> {
            newInputList.add(insertDigitIntoNumWord(line));
        });

        newInputList.forEach(string -> {
            List<Character> characterList = convertStringToCharArray(string);
            List<Integer> numList = findIntFromCharArray(characterList);

            // put first and last digit together
            Integer firstNum = numList.get(0);
            Integer lastNum = numList.get(numList.size() - 1);
            String s = firstNum + String.valueOf(lastNum);
            intList.add(parseInt(s));
        });

        return intList.stream().reduce(0, Integer::sum);
    }

    private String insertDigitIntoNumWord(String string) {
        String s;

        s = string.replace("one", "on1e");
        s = s.replace("two", "tw2o");
        s = s.replace("three", "th3ree");
        s = s.replace("four", "fo4ur");
        s = s.replace("five", "fi5ve");
        s = s.replace("six", "si6x");
        s = s.replace("seven", "se7ven");
        s = s.replace("eight", "ei8ght");
        s = s.replace("nine", "ni9ne");
        return s;
    }
}
