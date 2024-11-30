package day1test;

import java.util.ArrayList;

import utilities.HintInput;

public class main {

    private static HintInput input = new HintInput("input.txt");

    public static void main(String[] args) {
        input = new HintInput("input.txt");



        System.out.println("partOne : " + partOne());
        System.out.println("partTwo : " + partTwo());
        
    }

    public static Integer partOne() {
        ArrayList<ArrayList<String>> numberStrings = new ArrayList<>();
        ArrayList<String> lineNumberStrings = new ArrayList<>();

        for (String line : input.getHintLines()) {
            lineNumberStrings = new ArrayList<>();
            
            for (int i = 0; i < line.length(); i++) {
                if(Character.isDigit(line.charAt(i))) {
                    lineNumberStrings.add(String.valueOf(line.charAt(i)));
                    break;
                }
            }

            for(int i = line.length() - 1; i >= 0; i--) {
                if(Character.isDigit(line.charAt(i))) {
                    lineNumberStrings.add(String.valueOf(line.charAt(i)));
                    break;
                }
            }
            if(lineNumberStrings.size() != 0) {
                numberStrings.add(lineNumberStrings);
            }
        }

        Integer sum = 0;

        for(ArrayList<String> number : numberStrings ) {
            sum += Integer.parseInt(String.join("", number));
        }

        return sum;
    }

    public static Integer partTwo() {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<String> lineNumberStrings = new ArrayList<>();
        Integer sum = 0;

        for (String line : input.getHintLines()) {//Line
            lineNumberStrings = new ArrayList<>();
            
            sum += new Line(line).getValue();
        }

        return sum; 
    }
}