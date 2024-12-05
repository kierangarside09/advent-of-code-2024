package day5;

import java.util.ArrayList;

import utilities.HintInput;

public class PartTwo {

    ArrayList<OrderRule> orderRules = new ArrayList<>();
    ArrayList<Update> updates = new ArrayList<>();


    ArrayList<Update> invalidUpdates = new ArrayList<>();

    Integer total = 0;
    
    public PartTwo(HintInput orderRulesInput, HintInput updatesInput) {
        setOrderRules(orderRulesInput);
        setUpdates(updatesInput);

        for(Update update : updates) {
            if(!update.isValid(orderRules)) {
                invalidUpdates.add(update);
            }
        }

        System.out.println("total invalid updates: " + invalidUpdates.size());

        for(Update update : invalidUpdates) {
            update.sortUpdate(orderRules);
            total += update.getMiddlePageNumber();
        }

        System.out.println("total: " + total);
    }

    private void setOrderRules(HintInput orderRulesInput) {
        for(String inputLine : orderRulesInput.getHintLines()) {
            orderRules.add(new OrderRule(inputLine));
        }
    }

    private void setUpdates(HintInput updatesInput) {
        for(String inputLine : updatesInput.getHintLines()) {
            updates.add(new Update(inputLine));
        }
    }
}
