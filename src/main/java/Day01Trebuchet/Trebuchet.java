package main.java.Day01Trebuchet;

import java.io.IOException;
import java.util.List;

import static main.java.utils.FileAOC.readToArray;

public class Trebuchet {
    // read each line of the file
    // find first num
    // find last num
    // add all the numbers

    public List<String> printInput() throws IOException {
        return readToArray("calibration-doc.txt");
    }
}
