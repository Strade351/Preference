/**
 * Created by Anatoliy on 10.03.2018.
 */
public class Card {
    String name;
    Suit suit;
    int id;

    Card(int id, Suit suit) {
        this.id = id;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return name;
    }
}
