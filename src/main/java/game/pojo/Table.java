package game.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Headswitcher on 2017. 05. 27..
 */
public class Table {

    List<List<Field>> actualTable;

    public Table() {
        List<Field> firstRow = new ArrayList<Field>();
        firstRow.add(Field.getFieldWithBlueStone());
        firstRow.add(Field.getFieldWithRedStone());
        firstRow.add(Field.getFieldWithBlueStone());
        firstRow.add(Field.getFieldWithRedStone());

        List<Field> secondRow = new ArrayList<Field>();
        for (int i = 0; i < 4; i++) {
            secondRow.add(Field.getEmptyField());
        }

        List<Field> thirdRow = new ArrayList<Field>();
        for (int i = 0; i < 4; i++) {
            thirdRow.add(Field.getEmptyField());
        }

        List<Field> forthRow = new ArrayList<Field>();
        for (int i = 0; i < 4; i++) {
            forthRow.add(Field.getEmptyField());
        }
        List<Field> fifthRow = new ArrayList<Field>();
        fifthRow.add(Field.getFieldWithRedStone());
        fifthRow.add(Field.getFieldWithBlueStone());
        fifthRow.add(Field.getFieldWithRedStone());
        fifthRow.add(Field.getFieldWithBlueStone());
        List<List<Field>> initializedTable = new ArrayList<List<Field>>();
        initializedTable.add(firstRow);
        initializedTable.add(secondRow);
        initializedTable.add(thirdRow);
        initializedTable.add(forthRow);
        initializedTable.add(fifthRow);
        this.actualTable = initializedTable;
    }

    public List<List<Field>> getActualTable() {
        return actualTable;
    }

    public void setActualTable(List<List<Field>> actualTable) {
        this.actualTable = actualTable;
    }

    public void printActualTable() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                Field actualField = actualTable.get(i).get(j);
                if (!actualField.isEmpty()) {
                    System.out.print(actualField.getStone().getOwnerColor().name()+ "(" + i + "," +j + ")" + " ");
                } else {
                    System.out.print("ÜRES" + "(" + i + "," +j + ")" + " ");
                }
            }
            System.out.println();
        }

    }


}
