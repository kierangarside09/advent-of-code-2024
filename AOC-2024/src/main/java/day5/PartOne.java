package day5;

import java.util.ArrayList;

import utilities.HintInput;

public class PartOne {

    ArrayList<OrderRule> orderRules = new ArrayList<>();
    ArrayList<Update> updates = new ArrayList<>();


    Integer total = 0;
    
    public PartOne(HintInput orderRulesInput, HintInput updatesInput) {
        setOrderRules(orderRulesInput);
        setUpdates(updatesInput);

        for(Update update : updates) {
            if(update.isValid(orderRules)) {
                total += update.getMiddlePageNumber();
            }
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
