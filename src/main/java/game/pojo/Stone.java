package game.pojo;

/**
 * Egy játékos korogját ábrázoló osztály, amelynek leírja még a szinét is
 * Lásd {@link Color}
 */

public class Stone {

    /**
     * Ez a field adja meg a játékos korogjának színét.
     */
    private Color ownerColor;

    /**
     * Ez a konstuktor létrehoz egy <code>Stone</code>-t amelyhez hozzárendeljük a paraméterben adott <code>ownerColor</code>-t
     *
     * @param ownerColor a korong színe , {@link Color}
     */
    public Stone(Color ownerColor) {
        this.ownerColor = ownerColor;
    }
    /**
     * Visszaadja a <code>Stone</code> színét
     */
    public Color getOwnerColor() {
        return ownerColor;
    }
}
