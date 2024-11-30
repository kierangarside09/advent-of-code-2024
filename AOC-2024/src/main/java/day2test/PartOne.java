package day2test;

import java.util.ArrayList;

import utilities.HintInput;

public class PartOne {
    
    private HintInput input;
    private ArrayList<Game> games = new ArrayList<>();

    private Integer total = 0;



    public PartOne(HintInput input) {
        // constructor implementation
        this.input = input;
        setGames();

        checkPossibleGames();
    }

    public void checkPossibleGames() {
        for(Game game : games)
        {
            if(game.isPossible())
            {
                total += game.getGameId();
            }
        }
    }

    public void setGames()
    {
        for(String line : input.getHintLines())
        {
            games.add(new Game(line));
        }
    }

    public Integer getTotal() {
        return total;
    }
}
