package game.pojo;

/**
 * A játékosokat reprezentáló osztály. A játékos rendelkezik egy <code>name</code>-el
 * ami a játékos nevét adja meg, illetve egy <code>playerColor</code> ami a játékos általál birtokolt színt adja vissza.
 * <p>Lásd {@link Color} </p>
 */
public class Player {

    String name;
    Color playerColor;

    /**
     * Egyszerű konstruktor ami beállítja a <code>name</code>, <code>playerColor</code>-t.
     *
     * @param name        Név
     * @param playerColor Szín
     */
    public Player(String name, Color playerColor) {
        this.name = name;
        this.playerColor = playerColor;
    }

    /**
     * @return Egy olyan <code>Player</code> osztályt ami neve  <code>Első játékos</code> , és színe <code>{@link Color}.PIROS</code>
     */
    public static Player getRedPlayer() {
        return new Player("Első Játékos", Color.PIROS);
    }

    /**
     * @return Egy olyan <code>Player</code> osztályt ami neve <code>Második Játékos</code> , és színe <code>{@link Color}.KÉK</code>
     */
    public static Player getBluePlayer() {
        return new Player("Második Játékos", Color.KÉK);
    }

    /**
     * Visszaadja a játkos nevét
     *
     * @return A játékos nevét
     */
    public String getName() {
        return name;
    }

    /**
     * Beállítja a játékos nevét
     *
     * @param name , a játkos neve
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Visszaadja a játkos színét
     *
     * @return a játékos színét
     */
    public Color getPlayerColor() {
        return playerColor;
    }
}
