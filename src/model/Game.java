package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private List<Frame> frames;
    private int currentFrame;
    private static final int MAX_FRAMES = 10;

    public Game(List<Player> players) {
        this.players = players;
        this.frames = new ArrayList<>();
        for (int i = 0; i < MAX_FRAMES; i++) {
            frames.add(new Frame());
        }
        this.currentFrame = 0;
    }

    public void roll(Player player, int pins) {
        Frame frame = frames.get(currentFrame);
        frame.roll(pins);

        if (frame.isStrike()) {
            player.updateScore(10);
            // Bonus logic for strike
            currentFrame++;
        } else if (frame.isSpare()) {
            player.updateScore(5);
            // Bonus logic for spare
        }

        if (frameCompleted(frame)) {
            currentFrame++;
        }
    }

    public boolean frameCompleted(Frame frame) {
        return frame.isStrike() || frame.getScore() >= 10;
    }

    public Player getWinner() {
        return players.stream().max((p1, p2) -> p1.getScore() - p2.getScore()).orElse(null);
    }

    public boolean isGameOver() {
        return currentFrame >= MAX_FRAMES;
    }
}
