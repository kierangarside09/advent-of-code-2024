package day5;

import java.util.ArrayList;

public class Update {
    
    ArrayList<Integer> pageNumbers = new ArrayList<>();

    public Update(String input) {
        String[] pageStrings = input.split(",");
        for (String pageString : pageStrings) {
            pageNumbers.add(Integer.parseInt(pageString));
        }
    }

    public ArrayList<Integer> getPageNumbers() {
        return pageNumbers;
    }

    public boolean isValid(ArrayList<OrderRule> orderRules) {
        boolean valid = true;
        for (OrderRule orderRule : orderRules) {
            if (!orderRule.valid(this)) {
                valid = false;
                break;
            }
        }
        return valid;
    }

    public Integer getMiddlePageNumber() {
        return pageNumbers.get(pageNumbers.size() / 2);
    }

    public ArrayList<OrderRule> getReleventOrderRules(ArrayList<OrderRule> orderRules) {
        ArrayList<OrderRule> releventOrderRules = new ArrayList<>();
        for (OrderRule orderRule : orderRules) {
            if(this.getPageNumbers().contains(orderRule.getFirst()) && this.getPageNumbers().contains(orderRule.getSecond())) {
                releventOrderRules.add(orderRule);
            }
        }
        return releventOrderRules;
    }

    public void sortUpdate(ArrayList<OrderRule> orderRules) {
        ArrayList<OrderRule> releventOrderRules = this.getReleventOrderRules(orderRules);
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < pageNumbers.size() - 1; i++) {
                for (OrderRule orderRule : releventOrderRules) {
                    if (pageNumbers.get(i) == orderRule.getSecond() && pageNumbers.get(i + 1) == orderRule.getFirst()) {
                        // Swap page numbers
                        int temp = pageNumbers.get(i);
                        pageNumbers.set(i, pageNumbers.get(i + 1));
                        pageNumbers.set(i + 1, temp);
                        changed = true;
                    }
                }
            }
        }
    }

    public void print() {
        for (Integer pageNumber : pageNumbers) {
            System.out.print(pageNumber + ", ");
            
        }
        System.out.println();
    }
}
