package com.effecivesoft;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Application {

    public static final String FILE_NAME = "input.txt";
    public static final String CHARSET_NAME = "UTF-8";
    public static final String STRING_PATTERN = "([a-hA-H])([1-8])-([a-hA-H])([1-8])";


    public static void main(String[] args) throws Exception {
        char symbols[] = {'C', 'D'};
        int numbers[] = {7, 5};

        List<String> lines = Files.readAllLines(Paths.get(FILE_NAME), Charset.forName(CHARSET_NAME));
        for(String line : lines) {
            if(line.matches(STRING_PATTERN)) {
                throw new IllegalStateException("Illegal data format: " + line);
            }
            System.out.println(line);
        }
//        System.out.println(InvalidMoveUtil.isInvalidMove(symbols, numbers));

    }

}
