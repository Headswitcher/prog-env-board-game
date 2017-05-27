package game.pojo;

/**
 * Created by Headswitcher on 2017. 05. 27..
 */
public class Player {

    String name;
    Color playerColor;

    public Player(String name, Color playerColor) {
        this.name = name;
        this.playerColor = playerColor;
    }

    public static Player getRedPlayer() {
        return new Player("RED", Color.RED);
    }

    public static Player getBluePlayer() {
        return new Player("BLUE", Color.BLUE);
    }
}
