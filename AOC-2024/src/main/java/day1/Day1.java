package day1;

import utilities.HintInput;

public class Day1 {

    private HintInput input = new HintInput("../day1/day1input.txt");

    public static void main(String[] args) {
        Day1 instance = new Day1();


        PartOne partOne = new PartOne(instance.input);
        PartTwo partTwo = new PartTwo(instance.input);
    }
}
