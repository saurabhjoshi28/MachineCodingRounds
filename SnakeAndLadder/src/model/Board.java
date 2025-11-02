package model;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private int size;

    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;

    public Board(int size) {
        this.size = size;
        snakes = new HashMap<>();
        ladders = new HashMap<>();
    }

    public void setSnake(int head, int tail) {
        snakes.put(head, tail);
    }

    public void setLadder(int start, int end) {
        ladders.put(start, end);
    }

    public int getSize() {
        return size;
    }

    public int getNewPosition(int currentPosition, int diceValue) {
        int newPosition = currentPosition + diceValue;

        if (newPosition > 100) {
            return currentPosition;
        }

        while (snakes.containsKey(newPosition) || ladders.containsKey(newPosition)) {
            if (snakes.containsKey(newPosition)) {
                newPosition = snakes.get(newPosition);
            } else if (ladders.containsKey(newPosition)) {
                newPosition = ladders.get(newPosition);
            }
        }

        return newPosition;
    }
}
