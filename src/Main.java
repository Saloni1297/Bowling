import model.Player;
import service.Bowling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Bowling bowling = new Bowling(5);
        Player p1 = new Player("Thor");
        Player p2 = new Player("Loki");
        Player p3 = new Player("Hela");
        Player p4 = new Player("Odin");

        List<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        bowling.startGame(players);
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {  // 10 frames
            for (Player player : players) {
                System.out.println(player.getName() + "'s turn. Enter pins knocked down:");
                int pins = scanner.nextInt();
                bowling.findAvailableLane().getGame().roll(player, pins);
            }
        }

        // Check and declare winners after the game is over
        bowling.checkForWinners();
        }
}