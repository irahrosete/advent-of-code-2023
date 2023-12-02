package main.java.Day01Trebuchet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static main.java.utils.UtilAOC.*;

public class TrebuchetOne {
    public Integer printCalibrationValue() throws IOException {

        List<String> inputList = readFileToStringArray("calibration-doc.txt");

        List<Integer> intList = new ArrayList<>();

        inputList.forEach(string -> {
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
}
