package day4;

import java.util.ArrayList;
import java.util.Arrays;

public class Wordsearch {

    private final ArrayList<Location> locations = new ArrayList<>();

    private final Integer width;
    private final Integer height;

    public Wordsearch(String[] input) {
        ArrayList<String> lines = new ArrayList<>(Arrays.asList(input));

        width = lines.get(0).length();
        height = lines.size();

        for(Integer y = 0; y < height; y++)
        {
            for(Integer x = 0; x < width; x++)
            {
                locations.add(new Location(x, y, lines.get(y).charAt(x)));
            }
        }
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public Location getLocation(Integer x, Integer y) {
        for(Location location : locations)
        {
            if(location.equals(x, y))
            {
                return location;
            }
        }
        return null;
    }

    public String getHorizontalString(){
        String word = "";
        
        for(Integer y = 0; y < width; y++)
        {
            for(Integer x = 0; x < height; x++)
            {
                Location location = getLocation(x, y);
                word += location.getLetter();
            }
            word += " ";
        }

        return word;
    }

    public String getVerticalString(){
        String word = "";

        for(Integer x = 0; x < width; x++)
        {
            for(Integer y = 0; y < height; y++)
            {
                Location location = getLocation(x, y);
                word += location.getLetter();
            }
            word += " ";
        }

        return word;
    }

    public String getLeftToRightDiagonalString(){
        String word = "";
        Location diagonalStart = getLocation(width - 1, 0);
        Location currentLocation = diagonalStart;
        boolean keepGoing = true;

        System.out.println("next diagonal start : " + (diagonalStart.getX() - 1) + " " + 0);

        while(keepGoing)
        {
            word += currentLocation.getLetter();
            
            if(validLocation(currentLocation.getX() + 1, currentLocation.getY() + 1)) //check next diagonal
            {
                currentLocation = getLocation(currentLocation.getX() + 1, currentLocation.getY() + 1);
            }
            else if(validLocation(diagonalStart.getX() - 1, 0))//check next x row
            {
                diagonalStart = getLocation(diagonalStart.getX() - 1, 0);
                currentLocation = diagonalStart;
                word += " ";
            }
            else if(validLocation(0, diagonalStart.getY() + 1))//end of x rows check y rows
            {
                diagonalStart = getLocation(0, diagonalStart.getY() + 1);
                currentLocation = diagonalStart;
                word += " ";
            }
            else
            {
                keepGoing = false;
            }
        }

        return word;
    }

    public String getRightToLeftDiagonalString(){
        String word = "";
        Location diagonalStart = getLocation(0, 0);
        Location currentLocation = diagonalStart;
        boolean keepGoing = true;

        while(keepGoing)
        {
            word += currentLocation.getLetter();
            
            if(validLocation(currentLocation.getX() - 1, currentLocation.getY() + 1)) //check next diagonal
            {
                currentLocation = getLocation(currentLocation.getX() - 1, currentLocation.getY() + 1);
            }
            else if(validLocation(diagonalStart.getX() + 1, 0))//check next x row
            {
                diagonalStart = getLocation(diagonalStart.getX() + 1, 0);
                currentLocation = diagonalStart;
                word += " ";
            }
            else if(validLocation(width - 1, diagonalStart.getY() + 1))//end of x rows check y rows
            {
                diagonalStart = getLocation(width - 1, diagonalStart.getY() + 1);
                currentLocation = diagonalStart;
                word += " ";
            }
            else
            {
                keepGoing = false;
            }
        }

        return word;

    }



    public boolean checkWord(String word) {
        return word.equals(getHorizontalString()) || word.equals(getVerticalString()) || word.equals(getLeftToRightDiagonalString()) || word.equals(getRightToLeftDiagonalString());
    }

    public boolean checkleftToRightDiagonal(Location startLocation) {
        Location topLeft;
        Location middle = startLocation;
        Location bottomRight;
        String word;

        if(validLocation(startLocation.getX() - 1, startLocation.getY() - 1) && validLocation(startLocation.getX() + 1, startLocation.getY() + 1))
        {
            topLeft = getLocation(startLocation.getX() - 1, startLocation.getY() - 1);
            bottomRight = getLocation(startLocation.getX() + 1, startLocation.getY() + 1);

            word = String.valueOf(topLeft.getLetter()) + String.valueOf(middle.getLetter()) + String.valueOf(bottomRight.getLetter());
            
            return word.equals("MAS") || word.equals("SAM");
        }
        else
        {
            return false;
        }
    }

    public boolean checkRightToLeftDiagonal(Location startLocation) {
        Location topRight;
        Location middle = startLocation;
        Location bottomLeft;
        String word;

        if(validLocation(startLocation.getX() + 1, startLocation.getY() - 1) && validLocation(startLocation.getX() - 1, startLocation.getY() + 1))
        {
            topRight = getLocation(startLocation.getX() + 1, startLocation.getY() - 1);
            bottomLeft = getLocation(startLocation.getX() - 1, startLocation.getY() + 1);

            word = String.valueOf(topRight.getLetter()) + String.valueOf(middle.getLetter()) + String.valueOf(bottomLeft.getLetter());
            
            return word.equals("MAS") || word.equals("SAM");
        }
        else
        {
            return false;
        }

    }

    public boolean validLocation(Integer x, Integer y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    
}
