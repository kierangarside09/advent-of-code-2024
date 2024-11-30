package day2test;

public class Set {

    private Integer redCount = 0;
    private Integer blueCount = 0;
    private Integer greenCount = 0;

    private final Integer redMax = 12;
    private final Integer blueMax = 14;
    private final Integer greenMax = 13;

    public Set(String setString) {
        String[] colourCounts = setString.split(",");

        for(String colourCount : colourCounts)
        {
            if(colourCount.contains("red"))
                redCount += Integer.parseInt(colourCount.replaceAll("[^0-9]+", ""));
            else if(colourCount.contains("blue"))
                blueCount += Integer.parseInt(colourCount.replaceAll("[^0-9]+", ""));
            else if(colourCount.contains("green"))
                greenCount += Integer.parseInt(colourCount.replaceAll("[^0-9]+", ""));
        }
    }

    public boolean isPossible() {
        return redCount <= redMax && blueCount <= blueMax && greenCount <= greenMax;
    }

    public Integer getRedCount() {
        return redCount;
    }

    public Integer getBlueCount() { 
        return blueCount;
    }

    public Integer getGreenCount() {
        return greenCount;
    }
}
