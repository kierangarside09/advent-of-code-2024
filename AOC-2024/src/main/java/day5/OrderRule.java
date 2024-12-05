package day5;

import java.util.ArrayList;

public class OrderRule {
    
    private final Integer first;
    private final Integer second;

    public OrderRule(String inputLine) {
        String[] numbers = inputLine.split("\\|");
        this.first = Integer.parseInt(numbers[0]);
        this.second = Integer.parseInt(numbers[1]);
    }

    public Integer getFirst() {
        return first;
    }

    public Integer getSecond() {
        return second;
    }

    public boolean valid(Update update) {
        ArrayList<Integer> pageNumbers = update.getPageNumbers();
        if(pageNumbers.contains(this.first) && pageNumbers.contains(this.second))
        {    
            return pageNumbers.indexOf(this.first) < pageNumbers.indexOf(this.second);
        }
        else
        {
            return true;
        }
    }
}
