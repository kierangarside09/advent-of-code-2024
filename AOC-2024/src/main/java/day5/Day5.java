package day5;

import utilities.HintInput;

public class Day5 {
        private HintInput inputPageRules = new HintInput("../day5/day5input1.txt");
        private HintInput inputUpdates = new HintInput("../day5/day5input2.txt");

    public static void main(String[] args) {
        Day5 instance = new Day5();

        // PartOne partOne = new PartOne(instance.inputPageRules, instance.inputUpdates);
        PartTwo partTwo = new PartTwo(instance.inputPageRules, instance.inputUpdates);
    }
}
