package day2test;

import java.util.ArrayList;

import utilities.HintInput;

public class PartTwo {
    private HintInput input;
    private ArrayList<Game> games = new ArrayList<>();

    private Integer total = 0;

    public PartTwo(HintInput input) {
        this.input = input;
        setGames();
        setTotal();
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

    public void setTotal() {
        for(Game game : games)
        {
            System.out.println(game.getPower());
            total += game.getPower();
        }
    }
}
