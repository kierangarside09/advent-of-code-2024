package day4;

import utilities.HintInput;

public class Day4 {

    private HintInput input = new HintInput("../day4/day4input.txt");

    public static void main(String[] args) {
        Day4 instance = new Day4();

        // PartOne partOne = new PartOne(instance.input);
        PartTwo partTwo = new PartTwo(instance.input);
    }
    
}
