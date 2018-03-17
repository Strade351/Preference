/**
 * Created by Anatoliy on 15.03.2018.
 */
public class Step {
    private Player player;
    private Answer answer;

    public Step(Player player, String playtype) {
        this.player = player;
        if (playtype == "trade") {
            player.calcTrade();

        }
        answer = new Pass();
    }

    @Override
    public String toString() {
        return new String(player.name + " " + answer);
    }
}
