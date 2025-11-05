package model;

public class Player {
    private String name;
    private  char symbol;

    public Player(char symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}
