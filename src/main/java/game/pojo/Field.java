package game.pojo;

/**
 * Egy mezőt reprezentáló osztály . Egy mező abból áll hogy üres-e vagy pedig a rajta lévő korong.
 */
public class Field {
    /**
     * Ez a field mondja meg hogy adott mezőn van-e korong.
     */
    private boolean isEmpty;

    /**
     * Egy korongot tárolunk.
     */
    private Stone stone;

    /**
     * Alap konstruktor egy mező beállítására.
     *
     * @param isEmpty üres-e a mező
     * @param stone   egy <code>Stone</code> tipusú korong
     */
    public Field(boolean isEmpty, Stone stone) {
        this.isEmpty = isEmpty;
        this.stone = stone;
    }

    /**
     * @return Üres e az adott mező.
     */
    public boolean isEmpty() {
        return isEmpty;
    }

    /**
     * Az empty mező beállítására szolgáló metódus.
     *
     * @param empty Üres e az adott mező
     */
    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    /**
     * Visszaadja az osztály <code>Stone</code> mezőjét.
     *
     * @return mező korongja
     */
    public Stone getStone() {
        return stone;
    }

    /**
     * Beállítja a korong <code>Stone</code>-ját.
     *
     * @param stone beállítja a mező korongját
     */
    public void setStone(Stone stone) {
        this.stone = stone;
    }

    /**
     * Visszaad egy Piros színű <code>Stone</code>-nal rendelkező mezőt.
     *
     * @return egy mező aminek van egy piros színű korongja
     */
    public static Field getFieldWithRedStone() {
        Stone redStone = new Stone(Color.PIROS);
        return new Field(false, redStone);
    }

    /**
     * Visszaad egy Piros színű <code>Stone</code>-nal rendelkező mezőt.
     *
     * @return egy mező aminek van egy piros színű korongja
     */
    public static Field getFieldWithBlueStone() {
        Stone blueStone = new Stone(Color.KÉK);
        return new Field(false, blueStone);
    }

    /**
     * Vissza ad egy üres mezőt.
     *
     * @return egy mezőt ami üres
     */
    public static Field getEmptyField() {
        return new Field(true, null);
    }

}
