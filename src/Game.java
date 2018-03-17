import java.util.ArrayList;

/**
 * Created by Anatoliy on 10.03.2018.
 */
public class Game {
    int distcount;

    ArrayList<Player> players = new ArrayList<>();
    private Player player1;
    private Player player2;
    private Player player3;

    Deck deck = new Deck();

    String result;

    Game(int distcount) {
        setPlayers();
        this.distcount = distcount;
        Distribution currentdist;

        for (int i = 0; i < distcount; i++) {
            currentdist = new Distribution(i, players);
        }
    }

    private void setPlayers() {
        player1 = new Player("Anatoliy");
        player2 = new Player("Maxim");
        player3 = new Player("Ruslan");
        players.add(player1);
        players.add(player2);
        players.add(player3);
    }

    private void printResult() {
        System.out.println(result);
    }
}

