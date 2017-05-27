package game.pojo;

/**
 * Created by Headswitcher on 2017. 05. 27..
 */
public class Field {
    boolean isEmpty;
    Stone stone;

    public Field(boolean isEmpty, Stone stone) {
        this.isEmpty = isEmpty;
        this.stone = stone;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Stone getStone() {
        return stone;
    }

    public void setStone(Stone stone) {
        this.stone = stone;
    }

    public static Field getFieldWithRedStone() {
        Stone redStone = new Stone(Color.RED);
        Field fieldWithRedStone = new Field(false, redStone);
        return fieldWithRedStone;
    }

    public static Field getFieldWithBlueStone() {
        Stone blueStone = new Stone(Color.BLUE);
        Field fieldWithBlueStone = new Field(false, blueStone);
        return fieldWithBlueStone;
    }

    public static Field getEmptyField() {
        return new Field(true, null);
    }

}
