package day4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilities.HintInput;

public class PartOne {

    private final Wordsearch wordsearch;

    private final String hiddenWord = "XMAS";
    private final String hiddenWordBackwards = "SAMX";

    private final String horizontalString;
    private final Integer horizontalFoundWords;
    private final String verticalString;
    private final Integer verticalFoundWords;
    private final String leftToRightHorizontalString;
    private final Integer leftToRightHorizontalFoundWords;
    private final String rightToLeftHorizontalString;
    private final Integer rightToLeftHorizontalFoundWords;

    private final Integer total;

    public PartOne(HintInput input) {
        this.wordsearch = new Wordsearch(input.getHintLines());

        this.horizontalString = wordsearch.getHorizontalString();
        this.verticalString = wordsearch.getVerticalString();
        this.leftToRightHorizontalString = wordsearch.getLeftToRightDiagonalString();
        this.rightToLeftHorizontalString = wordsearch.getRightToLeftDiagonalString();

        this.horizontalFoundWords = findHiddenWord(horizontalString);
        this.verticalFoundWords = findHiddenWord(verticalString);
        this.leftToRightHorizontalFoundWords = findHiddenWord(leftToRightHorizontalString);
        this.rightToLeftHorizontalFoundWords = findHiddenWord(rightToLeftHorizontalString);

        System.out.println("Horizontal Found Words: " + horizontalFoundWords + "\n");
        System.out.println("Vertical Found Words: " + verticalFoundWords + "\n");
        System.out.println("Left to Right Diagonal Found Words: " + leftToRightHorizontalFoundWords + "\n");
        System.out.println("Right to Left Diagonal Found Words: " + rightToLeftHorizontalFoundWords + "\n");

        this.total = horizontalFoundWords + verticalFoundWords + leftToRightHorizontalFoundWords + rightToLeftHorizontalFoundWords;

        System.out.println("Total: " + total + "\n");

    }

    private Integer findHiddenWord(String string) {
        Integer count = 0;

        Pattern pattern = Pattern.compile("(" + hiddenWord + ")");
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            count++;
        }

        Pattern patternBackwards = Pattern.compile("(" + hiddenWordBackwards + ")");
        Matcher matcherBackwards = patternBackwards.matcher(string);

        while (matcherBackwards.find()) {
            count++;
        }

        return count;
    }

}
