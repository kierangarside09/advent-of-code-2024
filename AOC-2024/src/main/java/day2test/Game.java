package day2test;

import java.util.ArrayList;

public class Game {

    private Integer gameId;
    private ArrayList<Set> sets = new ArrayList<>();

    private Integer redMax = 12;
    private Integer blueMax = 14;
    private Integer greenMax = 13;

    private Integer highestRed = 0;
    private Integer highestBlue = 0;
    private Integer highestGreen = 0;

    public Game(String gameLine) {
        String gameString = gameLine.split(":")[0];
        gameString = gameString.replaceAll("[^0-9]+", "");
        gameId = Integer.parseInt(gameString);

        gameLine = gameLine.replaceFirst("Game " + gameId + ":", "");

        String[] gameSetStrings = gameLine.split(";");

        for(String setString : gameSetStrings)
        {
            addSet(setString);
        }

    }

    public boolean isPossible() {
        boolean possible = true;
        for(Set set : sets)
        {
            if(!set.isPossible())
            {
                possible = false;
            }
        }   
        return possible; 
    }

    public Integer getPower() {
        setHighestRed();
        setHighestBlue();
        setHighestGreen();
        return highestRed * highestBlue * highestGreen;
    }

    public void setHighestRed() {
        Integer HighestRed = 0;
        for(Set set : sets)
        {
            if(set.getRedCount() > HighestRed)
            {
                HighestRed = set.getRedCount();
            }
        }
        this.highestRed = HighestRed;
    }

    public void setHighestBlue() {
        Integer HighestBlue = 0;

        int test = 0;

        if(gameId == 4)
        {
            System.out.println("sets : " + sets.size());
        }
        for(Set set : sets)
        {
            if(gameId == 4)
            {
                test++;
                System.out.println("blue "+ test +" : " + set.getBlueCount());
            }
            if(set.getBlueCount() > HighestBlue)
            {
                HighestBlue = set.getBlueCount();
            }
        }
        this.highestBlue = HighestBlue;
    }

    public void setHighestGreen() {
        Integer HighestGreen = 0;
        for(Set set : sets)
        {
            if(set.getGreenCount() > HighestGreen)
            {
                HighestGreen = set.getGreenCount();
            }
        }
        this.highestGreen = HighestGreen;
    }

    public void addSet(String setString) {
        Set set = new Set(setString);
        sets.add(set);
    }

    public Integer getGameId() {
        return gameId;
    }
}
