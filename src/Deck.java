import java.util.ArrayList;

/**
 * Created by Anatoliy on 10.03.2018.
 */
public class Deck {
    Suit diamonds = new Suit("diamonds", 2);
    Suit hearts = new Suit("hearts", 3);
    Suit spades = new Suit("spades", 0);
    Suit clubs = new Suit("clubs", 1);

    ArrayList<Card> cards = new ArrayList<>();

    Deck() {
        createCards();
        setNames();
    }

    private void createCards() {
        for (int i = 0; i < 8; i++) {
            cards.add(new Card(i, diamonds));
            cards.add(new Card(i, hearts));
            cards.add(new Card(i, spades));
            cards.add(new Card(i, clubs));
        }
    }

    private void setNames() {
        for (int i = 0; i < 32; i++) {
            switch (cards.get(i).id) {
                case 0: cards.get(i).name = "seven" + " " + cards.get(i).suit.name; break;
                case 1: cards.get(i).name = "eight" + " " + cards.get(i).suit.name; break;
                case 2: cards.get(i).name = "nine" + " " + cards.get(i).suit.name; break;
                case 3: cards.get(i).name = "ten" + " " + cards.get(i).suit.name; break;
                case 4: cards.get(i).name = "jack" + " " + cards.get(i).suit.name; break;
                case 5: cards.get(i).name = "queen" + " " + cards.get(i).suit.name; break;
                case 6: cards.get(i).name = "king" + " " + cards.get(i).suit.name; break;
                case 7: cards.get(i).name = "ace" + " " + cards.get(i).suit.name; break;
            }
        }
    }
}
