package model;

public class Lane {
    private Game game;
    private boolean isAvailable;

    public Lane(Game game) {
        this.game = game;
        this.isAvailable = true;
    }

    public void assignGame(Game game) {
        this.game = game;
        this.isAvailable = false;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Game getGame() {
        return game;
    }

    public void releaseLane() {
        this.isAvailable = true;
    }
}
