import java.util.ArrayList;

/**
 * Created by Anatoliy on 10.03.2018.
 */
public class Player {
    String name;
    int points;
    int bullet;
    int mountain;
    int whist;

    Order order;

    Hand hand = new Hand();
    boolean isfirst;

    Player (String name) {
        this.name = name;
    }

    void calcTrade() {
        hand.calcOrders();
    }



    void printCards() {
        System.out.println(hand.toString());
    }
}
