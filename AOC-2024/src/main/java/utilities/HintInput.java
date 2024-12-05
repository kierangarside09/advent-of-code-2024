package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import day1test.main;

public class HintInput {
    private final String hintInput;

    private final String[] hintLines;

    public HintInput(String inputFile) {
        String input = "";

        try {
            InputStream in = main.class.getResourceAsStream(inputFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = br.readLine()) != null) {
                input += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.hintInput = input;

        this.hintLines = hintInput.split("\n");
        
    }

    public void print() {
        for (String line : hintLines) {
            System.out.println(line);
        }
    }

    public String[] getHintLines() {
        return this.hintLines;
    }

    public String getHintInput() {
        return this.hintInput;
    }

}