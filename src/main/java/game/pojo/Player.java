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
        return new Player("Első Játékos", Color.PIROS);
    }

    public static Player getBluePlayer() {
        return new Player("Második Játékos", Color.KÉK);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayerColor(Color playerColor) {
        this.playerColor = playerColor;
    }

    public Color getPlayerColor() {
        return playerColor;
    }
}
