package day2;

import utilities.HintInput;

public class Day2 {

    private HintInput input = new HintInput("../day2/day2input.txt");

    public static void main(String[] args) {
        Day2 instance = new Day2();

        PartOne partOne = new PartOne(instance.input);

        System.out.println("partOne: " + partOne.getSafeReportsCount());

    }
    
}
