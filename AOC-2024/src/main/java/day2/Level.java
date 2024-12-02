package day2;

public class Level {
    private Integer levelNum;

    public Level(String levelString) {
        this.levelNum = Integer.parseInt(levelString);
    }

    public Integer getLevelNum()
    {
        return this.levelNum;
    }
}
