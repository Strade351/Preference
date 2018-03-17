public class Order extends Answer {
    String name = "order";
    int number;
    Suit suit;

    Order (Suit suit, int number) {
        this.suit = suit;
        this.number = number;
    }
}