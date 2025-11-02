package model;

public class PairPosition {
    private int start;
    private int end;

    public PairPosition(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }
}
