package day2test;

import utilities.HintInput;

public class main {

    private HintInput input = new HintInput("../day2test/day2Input.txt");

    public static void main(String[] args) {
        
        main instance = new main();
        PartOne partOne = new PartOne(instance.input);
        System.out.println("partOne : " + partOne.getTotal());

        PartTwo partTwo = new PartTwo(instance.input);
        System.out.println("partTwo : " + partTwo.getTotal());
    }
    
}
