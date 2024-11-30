package day1test;

import java.util.Map;

public class Line {

    private String line;

    private String firstNumber;
    private String secondNumber;

    private final Map<String, Integer> numberMap = Map.of(
        "one", 1,
        "two", 2,
        "three", 3,
        "four", 4,
        "five", 5,
        "six", 6,
        "seven", 7,
        "eight", 8,
        "nine", 9,
        "zero", 0
    );

    String[] numberStrings = {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};   
    

    private Integer value;
    
    public Line( String Line ) {
        this.line = Line;

        getFirstNumber();
        getSecondNumber();

        this.value = Integer.parseInt(firstNumber + secondNumber);

        System.out.println(value);
    }

    public void convertLineNumberStringsToNumbers() {

    }

    public void getFirstNumber() {
        for(int i = 0; i < line.length(); i++)
        {
            String substring = line.substring(0, i);

            Integer numberStringLocation = 0;
            Integer numberStringLength = 0;
            String foundNumberString = "";

            for(String s : numberStrings) {
                if(substring.contains(s)) {
                    foundNumberString = s;
                    break;
                }
            }


            if(foundNumberString != "") {
                Integer number = numberMap.get(foundNumberString);
                this.firstNumber = number.toString();
                break;
            }
            else if(Character.isDigit(line.charAt(i))) {
                this.firstNumber = String.valueOf(line.charAt(i));
                break;
            }
        }
    }

    public void getSecondNumber() {
        for(int i = line.length() - 1; i >= 0; i--)
        {
            String substring = line.substring(i+1, line.length());

            String foundNumberString = "";

            for(String s : numberStrings) {
                if(substring.contains(s)) {
                    foundNumberString = s;
                    break;
                }
            }

            if(foundNumberString != "") {
                Integer number = numberMap.get(foundNumberString);
                this.secondNumber = number.toString();
                break;
            }
            else if(Character.isDigit(line.charAt(i))) {
                this.secondNumber = String.valueOf(line.charAt(i));
                break;
            }
        }
    }

    public Integer getValue() {
        return value;
    }

}

