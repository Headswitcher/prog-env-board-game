package game.pojo;

import org.pmw.tinylog.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Ez az osztály reprezentálja a játébkeli táblát. A játékbeli obijektumokat fogja össze
 * <br> Lásd {@link Field}, {@link Stone}
 */
public class Board {

    /**
     * Ezek a Fieldek a tábla méretekért adják meg.
     */


    /**
     * Sor méretéért felelős mező.
     */
    private int rowSize = 5;
    /**
     * Oszlop méretéért felelős mező.
     */
    private int columnSize = 4;

    /**
     * Az aktuális tábla egy ilyen Lista a Listában struktúrával jön létre.
     * <p>
     * Lásd {@link List}
     */
    List<List<Field>> actualBoard;

    /**
     * A konstruktor initalizálja a feladatban foglalt kezdőtáblát ami a következő féle képenne néz ki.
     * A konstruktor útán a tábla a következő féle képpen néz ki:
     * <p>
     * <pre>
     * KÉK(0,0) PIROS(0,1) KÉK(0,2) PIROS(0,3)
     * ÜRES(1,0) ÜRES(1,1) ÜRES(1,2) ÜRES(1,3)
     * ÜRES(2,0) ÜRES(2,1) ÜRES(2,2) ÜRES(2,3)
     * ÜRES(3,0) ÜRES(3,1) ÜRES(3,2) ÜRES(3,3)
     * PIROS(4,0) KÉK(4,1) PIROS(4,2) KÉK(4,3)
     * </pre>
     */
    public Board() {
        List<Field> firstRow = new ArrayList<>();
        firstRow.add(Field.getFieldWithBlueStone());
        firstRow.add(Field.getFieldWithRedStone());
        firstRow.add(Field.getFieldWithBlueStone());
        firstRow.add(Field.getFieldWithRedStone());

        List<Field> secondRow = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            secondRow.add(Field.getEmptyField());
        }

        List<Field> thirdRow = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            thirdRow.add(Field.getEmptyField());
        }

        List<Field> forthRow = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            forthRow.add(Field.getEmptyField());
        }
        List<Field> fifthRow = new ArrayList<>();
        fifthRow.add(Field.getFieldWithRedStone());
        fifthRow.add(Field.getFieldWithBlueStone());
        fifthRow.add(Field.getFieldWithRedStone());
        fifthRow.add(Field.getFieldWithBlueStone());

        List<List<Field>> initializedBoard = new ArrayList<>();
        initializedBoard.add(firstRow);
        initializedBoard.add(secondRow);
        initializedBoard.add(thirdRow);
        initializedBoard.add(forthRow);
        initializedBoard.add(fifthRow);
        this.actualBoard = initializedBoard;
    }

    /**
     * Kiírajta a <code>actualBoard</code> tartalmát emberi olvasható formában.
     * <br>Példa a kimenetre:
     * <pre>
     *     KÉK(0,0) PIROS(0,1) KÉK(0,2) PIROS(0,3)
     *     ÜRES(1,0) ÜRES(1,1) ÜRES(1,2) ÜRES(1,3)
     *     ÜRES(2,0) ÜRES(2,1) ÜRES(2,2) ÜRES(2,3)
     *     ÜRES(3,0) ÜRES(3,1) ÜRES(3,2) ÜRES(3,3)
     *     PIROS(4,0) KÉK(4,1) PIROS(4,2) KÉK(4,3)
     * </pre>
     */
    public void printActualBoard() {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                Field actualField = actualBoard.get(i).get(j);
                if (j == 0) {
                    System.out.print("| ");
                    if (!actualField.isEmpty()) {
                        if (actualField.getStone().getOwnerColor().equals(Color.KÉK))
                            System.out.print("K |");
                        else {
                            System.out.print("P |");
                        }
                    } else {
                        System.out.print("  |");
                    }

                } else {
                    if (!actualField.isEmpty()) {

                        if (actualField.getStone().getOwnerColor().equals(Color.KÉK))
                            System.out.print(" K |");
                        else {
                            System.out.print(" P |");
                        }

                    } else {
                        System.out.print("   |");
                    }
                }
            }
            System.out.print("\n+---+---+---+---+\n");
        }


    }

    /**
     * A célállapotot ellenőrző metódus.
     * <p>
     * <p>A metódus bejárja háromszor a táblánkat megnézve a célállapotokot amikt a következők:
     * <br>Előszőr ellenőrzi hogy vízszintesen nincs e három megegyező színű azaz:
     * <pre>
     *     KÉK(0,0) ÜRES(0,1) KÉK(0,2) ÜRES(0,3)
     *     ÜRES(1,0) ÜRES(1,1) ÜRES(1,2) ÜRES(1,3)
     *     ÜRES(2,0) ÜRES(2,1) ÜRES(2,2) ÜRES(2,3)
     *     PIROS(3,0) PIROS(3,1) PIROS(3,2) ÜRES(3,3)
     *     ÜRES(4,0) KÉK(4,1) PIROS(4,2) KÉK(4,3)
     * </pre>
     * <p>
     * <p>Következő dupla ciklusban megnézi hogy nincs e függőlegesen három megegyező színű,azaz:</p>
     * <pre>
     *     KÉK(0,0) ÜRES(0,1) KÉK(0,2) ÜRES(0,3)
     *     ÜRES(1,0) PIROS(1,1) ÜRES(1,2) ÜRES(1,3)
     *     ÜRES(2,0) PIROS(2,1) ÜRES(2,2) ÜRES(2,3)
     *     ÜRES(3,0) PIROS(3,1) ÜRES(3,2) ÜRES(3,3)
     *     ÜRES(4,0) KÉK(4,1) PIROS(4,2) KÉK(4,3)
     * </pre>
     * <p>
     * <p> Végül pedig hogy keresztben van-e három megeggyező színű, azaz:</p>
     * <pre>
     *     KÉK(0,0) ÜRES(0,1) KÉK(0,2) ÜRES(0,3)
     *     PIROS(1,0) ÜRES(1,1) ÜRES(1,2) ÜRES(1,3)
     *     ÜRES(2,0) PIROS(2,1) ÜRES(2,2) ÜRES(2,3)
     *     ÜRES(3,0) ÜRES(3,1) PIROS(3,2) ÜRES(3,3)
     *     ÜRES(4,0) KÉK(4,1) PIROS(4,2) KÉK(4,3)
     * </pre>
     *
     * @return Van-e <code>actualBoard</code>-on célállapot.
     */
    public boolean isGameOver() {
        boolean isGameOver = false;
        for (int i = 1; i < rowSize - 1 && !isGameOver; i++) {
            for (int j = 0; j < columnSize && !isGameOver; j++) {
                Field actualField = actualBoard.get(i).get(j);
                if (!actualField.isEmpty()) {
                    Color actualFieldOwnerColor = actualField.getStone().getOwnerColor();
                    if (!actualBoard.get(i - 1).get(j).isEmpty() && !actualBoard.get(i + 1).get(j).isEmpty()) {
                        if (actualBoard.get(i - 1).get(j).getStone().getOwnerColor().equals(actualFieldOwnerColor) && actualBoard.get(i + 1).get(j).getStone().getOwnerColor().equals(actualFieldOwnerColor)) {
                            isGameOver = true;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rowSize && !isGameOver; i++) {
            for (int j = 1; j < columnSize - 1 && !isGameOver; j++) {
                Field actualField = actualBoard.get(i).get(j);
                if (!actualField.isEmpty()) {
                    Color actualFieldOwnerColor = actualField.getStone().getOwnerColor();
                    if (!actualBoard.get(i).get(j - 1).isEmpty() && !actualBoard.get(i).get(j + 1).isEmpty()) {
                        if (actualBoard.get(i).get(j - 1).getStone().getOwnerColor().equals(actualFieldOwnerColor) && actualBoard.get(i).get(j + 1).getStone().getOwnerColor().equals(actualFieldOwnerColor)) {
                            isGameOver = true;
                        }
                    }
                }
            }
        }

        for (int i = 1; i < rowSize - 1; i++) {
            for (int j = 1; j < columnSize - 1; j++) {
                Field actualField = actualBoard.get(i).get(j);
                if (!actualField.isEmpty()) {
                    Color actualFieldOwnerColor = actualField.getStone().getOwnerColor();
                    if (!actualBoard.get(i - 1).get(j - 1).isEmpty() && !actualBoard.get(i + 1).get(j + 1).isEmpty()) {
                        if (actualBoard.get(i - 1).get(j - 1).getStone().getOwnerColor().equals(actualFieldOwnerColor) && actualBoard.get(i + 1).get(j + 1).getStone().getOwnerColor().equals(actualFieldOwnerColor)) {
                            isGameOver = true;
                            break;
                        }
                    }
                    if (!actualBoard.get(i - 1).get(j + 1).isEmpty() && !actualBoard.get(i + 1).get(j - 1).isEmpty()) {
                        if (actualBoard.get(i - 1).get(j + 1).getStone().getOwnerColor().equals(actualFieldOwnerColor) && actualBoard.get(i + 1).get(j - 1).getStone().getOwnerColor().equals(actualFieldOwnerColor)) {
                            isGameOver = true;
                        }
                    }
                }
            }
        }
        Logger.info("isGameOver:" + isGameOver);
        return isGameOver;
    }

    /**
     * Visszadja az aktuális táblát.
     *
     * @return <code>actualBoard</code> aktuális tábla
     */
    public List<List<Field>> getActualBoard() {
        return actualBoard;
    }

    /**
     * Vissza adja az aktuális tábla sor méretét
     *
     * @return <code>actualBoard</code> Sor méretét adja vissza.
     */
    public int getRowSize() {
        return rowSize;
    }

    /**
     * Visszaadja az aktuális tábla oszlop méretét
     *
     * @return <code>actualBoard</code> oszlop méretét adja vissza.
     */
    public int getColumnSize() {
        return columnSize;
    }
}
