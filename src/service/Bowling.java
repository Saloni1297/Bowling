package service;

import model.Game;
import model.Lane;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class Bowling{
    private List<Lane> lanes;

    public Bowling(int numberOfLanes) {
        lanes = new ArrayList<>();
        for (int i = 0; i < numberOfLanes; i++) {
            lanes.add(new Lane(null));
        }
    }

    public Lane findAvailableLane() {
        return lanes.stream().filter(Lane::isAvailable).findFirst().orElse(null);
    }

    public void startGame(List<Player> players) {
        Lane lane = findAvailableLane();
        if (lane != null) {
            Game game = new Game(players);
            lane.assignGame(game);
            System.out.println("Game started on lane: " + lanes.indexOf(lane));
        } else {
            System.out.println("No available lanes.");
        }
    }

    public void checkForWinners() {
        for (Lane lane : lanes) {
            Game game = lane.getGame();
            if (game != null && game.isGameOver()) {
                Player winner = game.getWinner();
                System.out.println("Winner: " + winner.getName());
                lane.releaseLane();
            }
        }
    }
}
