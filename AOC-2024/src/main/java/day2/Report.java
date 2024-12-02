package day2;

import java.util.ArrayList;

public class Report {
    ArrayList<Level> levels = new ArrayList<>();

    Boolean isIncreasing;

    public Report(String input) {
        String[] levelStrings = input.split(" ");
        for (String levelString : levelStrings) {
            levels.add(new Level(levelString));
        }

        Integer increasingNum = 0;
        Integer decreasingNum = 0;

        Integer currentLevel;
        Integer nextLevel;
        for(int i = 0; i < levels.size() - 1; i++)
        {
            currentLevel = levels.get(i).getLevelNum();
            nextLevel = levels.get(i + 1).getLevelNum();

            if(currentLevel < nextLevel)
            {
                increasingNum++;   
            }
            else if(currentLevel > nextLevel)
            {
                decreasingNum++;   
            }
        }


        if(increasingNum > decreasingNum)
        {
            System.out.println("increasing");
            isIncreasing = true;
        }
        else
        {
            System.out.println("decreasing");
            isIncreasing = false;
        }
    }


    public boolean isSafe()
    {
        Integer currentLevel;
        Integer nextLevel;
        Integer dampener = 0;
        for(int i = 0; i < levels.size() - 1; i++)
        {
            currentLevel = levels.get(i).getLevelNum();
            nextLevel = levels.get(i + 1).getLevelNum();

            if(currentLevel.equals(nextLevel))
            {
                if(dampener < 1)
                {
                    levels.remove(i+1);
                    i = i - 1;
                    dampener++;
                    continue;
                }
                else
                {
                    return false;
                }
            }

            if(Math.abs(currentLevel - nextLevel) >= 4)//handled increase/decrease by more than 4
            {
                if(i == 0)
                {
                    if(Math.abs(levels.get(1).getLevelNum() - levels.get(2).getLevelNum()) >= 4)
                    {
                        levels.remove(1);
                        i = i - 1;
                        dampener++;
                        continue;
                    }
                    else
                    {
                        levels.remove(0);
                        i = i - 1;
                        dampener++;
                        continue;
                    }
                }
                if(dampener < 1)
                {
                    levels.remove(i+1);
                    i = i - 1;
                    dampener++;
                    continue;
                }
                else
                {
                    return false;
                }
            }

            if(isIncreasing)
            {
                if(currentLevel > nextLevel)
                {
                    if(i == 0)
                    {
                        levels.remove(i);
                        i = i - 1;
                        dampener++;
                        continue;
                    }
                    if(dampener < 1)
                    {
                        levels.remove(i+1);
                        i = i - 1;
                        dampener++;
                        continue;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
            else
            {
                if(currentLevel < nextLevel)
                {
                    if(i == 0)
                    {
                        levels.remove(i);
                        i = i - 1;
                        dampener++;
                        continue;
                    }
                    if(dampener < 1)
                    {
                        levels.remove(i+1);
                        i = i - 1;
                        dampener++;
                        break;
                    }
                    else
                    {
                        return false;
                    }
                }
            }


        }

        for(int i = 0; i < levels.size() - 1; i++)
        {
            currentLevel = levels.get(i).getLevelNum();
            nextLevel = levels.get(i + 1).getLevelNum();

            if(currentLevel.equals(nextLevel) && dampener > 0)
            {
                return false;
            }
        }

        return true;
    }

    public void printLevels() {
        for(Level level : levels)
        {
            System.out.print(level.getLevelNum() + " ");
        }
        System.out.println();
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }
}
