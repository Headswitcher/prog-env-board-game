package game;

/**
 * Created by Headswitcher on 2017. 05. 27..
 */

public class Stone {
    private enum Color {
        RED, BLUE
    }

    Color ownerColor;

    public Color getOwnerColor() {
        return ownerColor;
    }

    public void setOwnerColor(Color ownerColor) {
        this.ownerColor = ownerColor;
    }
}
