import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Anatoliy on 15.03.2018.
 */
public class Hand {
    Answer answer;

    Suit diamonds = new Suit("diamonds", 2);            //масти, ДУБЛИРУЮЩИЙСЯ КОД, ДЛЯ МАСТЕЙ НУЖЕН ОТДЕЛЬНЫЙ ENUM (?)
    Suit hearts = new Suit("hearts", 3);
    Suit spades = new Suit("spades", 0);
    Suit clubs = new Suit("clubs", 1);

    ArrayList<Card> cards = new ArrayList<>();

    Hand() {

    }

    /*
    считаем количество конкретной масти в руке
     */
    private int calcSuit(Suit suit) {
        int count = 0;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).suit.id == suit.id) {
                count++;
            }
        }
        return count;
    }

    /*
    считаем взятки
     */
    Order calcOrders() {
        int count = 0;
        Suit trump = compareSuitsPrior(compareSuitsPrior(diamonds, hearts), compareSuitsPrior(spades, clubs));  //выявляем наиболее выгодную козырную масть
        count += calcSuitTrumpOrderCount(trump);

        return new Order(trump, count);
    }

    /*
    считаем количество возможных взяток для масти
    в случае если она козырная
     */
    private int calcSuitTrumpOrderCount(Suit suit) {
        ArrayList<Integer> targetcards = getSuiteCards(suit.id);
        int suitcount = 0;
        switch (calcSuit(suit)) {
            case 8 : suitcount = 8; break;
            case 7 : if (targetcards.contains(7)) {suitcount = 7;}
                        else {suitcount = 6;}; break;
            case 6 : if (targetcards.contains(7) & targetcards.contains(6)) {suitcount = 6;}
                        else if ((targetcards.contains(7)) || (targetcards.contains(6) & targetcards.contains(5)))
                        {suitcount = 5;}
                        else suitcount = 4; break;
            case 5 : if ((targetcards.contains(7) & targetcards.contains(6) || (targetcards.contains(7) &
                    targetcards.contains(5) & targetcards.contains(4)))) {suitcount = 5;}
                    else if (targetcards.contains(6) & targetcards.contains(5) & targetcards.contains(4)) {suitcount = 4;}
                    else if (targetcards.contains(7) || ((targetcards.contains(6) & targetcards.contains(5)))) {suitcount = 3;}
                    else if ((targetcards.contains(6) & targetcards.contains(4) & targetcards.contains(3)) ||
                    (targetcards.contains(5) & targetcards.contains(4) & targetcards.contains(3))) {suitcount = 2;} break;
            case 4 : if (targetcards.contains(7) & targetcards.contains(6) & targetcards.contains(5) & targetcards.contains(4)) {
                suitcount = 4;
            } else suitcount = 2;
            }
            return suitcount;
    }

    /*
    Считаем количество возможных взяток для обычной масти
     */
    private void calcSuitOrderCount(Suit suit) {
        ArrayList<Integer> targetcards = getSuiteCards(suit.id);
        int suitcount = 0;
        switch (calcSuit(suit)) {
            case 1: suitcount++; //ДОПИСАТЬ МЕТОД!!!
        }
    }

    /*
    Сравниваем, какая из двух мастей выгоднее
     */
    private Suit compareSuitsPrior(Suit suit1, Suit suit2) {
        if (calcSuitTrumpOrderCount(suit1) > calcSuitTrumpOrderCount(suit2))
            return suit1;
        if (calcSuitTrumpOrderCount(suit1) < calcSuitTrumpOrderCount(suit2)) {
            return suit2;
        }
        if (calcSuitTrumpOrderCount(suit1) == calcSuitTrumpOrderCount(suit2)) {
            if (suit1.id > suit2.id)
                return suit1;
            else
                return suit2;
        }
        else return null;
    }


    /*
    возвращает список айдишников карт определённой масти
     */
    private ArrayList<Integer> getSuiteCards(int id) {
        ArrayList<Integer> targetcards = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).suit.id == id) {
                targetcards.add(cards.get(i).id);
            }
        }
        return targetcards;
    }
}
