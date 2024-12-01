package day1;

import java.util.ArrayList;
import java.util.Collections;

import utilities.HintInput;

public class PartTwo {
    private ArrayList<Integer> listOne = new ArrayList<>();
    private ArrayList<Integer> listTwo = new ArrayList<>();

    private Integer similarityTotal = 0;

    public PartTwo(HintInput input) {
        setListsFromInput(input);

        System.out.println("PartTwo:");
        setSimilarityTotal();
        System.out.println("Total: " + similarityTotal);
        System.out.println();
    }

    public void setListsFromInput(HintInput input){
        String[] lines = input.getHintLines();
        String[] lineHalves;

        for (String line : lines) {
            lineHalves = line.split("   ");
            listOne.add(Integer.parseInt(lineHalves[0]));
            listTwo.add(Integer.parseInt(lineHalves[1]));
        }
    }

    public void setSimilarityTotal(){
        Integer number;
        Integer occurences;
        for(int i = 0; i < listOne.size(); i++){
            number = listOne.get(i);
            occurences = Collections.frequency(listTwo, number);

            similarityTotal += number * occurences;
        }

    }
}
