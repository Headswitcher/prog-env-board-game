package game.pojo;

/**
 * Created by Headswitcher on 2017. 05. 27..
 */

public class Stone {

    public enum Color {
        RED, BLUE
    }

    public Stone(Color ownerColor) {
        this.ownerColor = ownerColor;
    }

    private Color ownerColor;

    public Color getOwnerColor() {
        return ownerColor;
    }

    public void setOwnerColor(Color ownerColor) {
        this.ownerColor = ownerColor;
    }
}
