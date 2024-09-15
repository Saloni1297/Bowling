package model;

public class Frame {
    private int[] rolls;
    private int currentRoll;

    public Frame() {
        rolls = new int[2];
        currentRoll = 0;
    }

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int getScore() {
        return rolls[0] + rolls[1];
    }

    public boolean isStrike() {
        return rolls[0] == 10;
    }

    public boolean isSpare() {
        return rolls[0] + rolls[1] == 10;
    }
}
