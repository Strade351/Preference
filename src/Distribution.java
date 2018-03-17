import java.util.ArrayList;
import java.util.Random;

public class Distribution {
    int number;
    Deck deck = new Deck();
    ArrayList<Player> players;
    ArrayList<Card> freecards;     //прикуп
    Play trade;   //торговля
    Play play;

    Random r;
    int currentplayer = 0;                                                      //текущий игрок

    Distribution(int number, ArrayList<Player> players) {
        this.number = number;
        this.players = players;
        cardsinhands();    //раздача карт всем игрокам
        trade = new Trade(players);          //торг
                    //игра
    }

    private void cardsinhands() {
        freecards = deck.cards;
        r = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                int n = r.nextInt(freecards.size());
                players.get(i).hand.cards.add(freecards.get(n));
                freecards.remove(n);
            }
            players.get(i).printCards();
        }
    }

    /*

    private void trade() {
        for (int i = 0; i < players.size(); i++) {
            Player currentplayer = players.get(i);
        }
    }

    private void nextplayer() {
        if (currentplayer == 2) currentplayer = 0;
        else currentplayer++;
    } */
}

