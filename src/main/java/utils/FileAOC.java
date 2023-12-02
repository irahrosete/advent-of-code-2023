package main.java.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAOC {
    public static List<String> readToArray(String filename) throws IOException {
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
}
