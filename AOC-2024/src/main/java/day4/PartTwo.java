package day4;

import utilities.HintInput;

public class PartTwo {
    private final Wordsearch wordsearch;

    private final String hiddenWord = "XMAS";
    private final String hiddenWordBackwards = "SAMX";

    private final Integer total;

    public PartTwo(HintInput input) {
        this.wordsearch = new Wordsearch(input.getHintLines());

        total = findXMasCount();

        System.out.println("Total: " + total + "\n");

    }

    public Integer findXMasCount() {
        Integer total = 0;
        for(Location location : wordsearch.getLocations())
        {
            if(location.getLetter() == 'A')
            {
                if(wordsearch.checkleftToRightDiagonal(location) && wordsearch.checkRightToLeftDiagonal(location))
                {
                    System.out.println((location.getX()) + ", " + (location.getY()));
                    total++;
                }
            }
        }

        return total;
    }
}
