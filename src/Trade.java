import java.util.ArrayList;

/**
 * Created by Anatoliy on 18.03.2018.
 */
public class Trade implements Play {
    String playtype = "trade";
    ArrayList<Player> players;
    ArrayList<Step> steps;
    Answer[] answers = new Answer[3];

    Trade(ArrayList<Player> players) {
        this.players = players;
        while (checkFinal() == false) {
            steps.add(new Step(players.get(0), playtype));
            //НАПИСАТЬ ЛОГИКУ ХОДОВ
        }
    }

    boolean checkFinal() //проверяем пришли ли все к согласию
    {
        int pass = 0;
        int orders = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].name == "pass") {
                pass++;
            }
            if (answers[i].name == "order") {
                orders++;
            }
        }
        if (pass == 3 || (pass == 2 && orders == 1)) {
            return true;
        } else return false;
    }

    @Override
    public void printResult() {

    }
}
