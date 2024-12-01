package day1;

import java.util.ArrayList;

import utilities.HintInput;

public class PartOne {
    
    private ArrayList<Integer> listOne = new ArrayList<>();
    private ArrayList<Integer> listTwo = new ArrayList<>();

    private ArrayList<Integer> listDifferences = new ArrayList<>();

    private Integer total = 0;

    public PartOne(HintInput input) {
        setListsFromInput(input);

        System.out.println("Part one:");

        listOne.sort(null);
        listTwo.sort(null);

        getDifferenceBetweenLists();

        System.out.println("Total: " + total);
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

    public void getDifferenceBetweenLists(){
        Integer difference = 0;
        for(int i = 0; i < listOne.size(); i++){
            if(listOne.get(i) > listTwo.get(i)){
                difference = listOne.get(i) - listTwo.get(i);
            }
            else if(listOne.get(i) <= listTwo.get(i)){
                difference = listTwo.get(i) - listOne.get(i);
            }   
            listDifferences.add(difference);
            total += difference;
        }
    }
}
