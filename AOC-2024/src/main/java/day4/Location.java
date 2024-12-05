package day4;

public class Location {
    private final Integer x;
    private final Integer y;
    private final char letter;

    public Location(Integer x, Integer y, char letter) {
        this.x = x;
        this.y = y;
        this.letter = letter;
    }

    public boolean equals(Integer x, Integer y) {
        return this.x.equals(x) && this.y.equals(y);
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public char getLetter() {
        return letter;
    }

    public void print() {
        System.out.println("x: " + x + " y: " + y + " letter: " + letter);
    }
    
}
