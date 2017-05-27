package game.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Headswitcher on 2017. 05. 27..
 */
public class Board {


    private int rowSize = 5;
    private int columnSize = 4;

    List<List<Field>> actualBoard;

    public Board() {
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

        List<List<Field>> initializedBoard = new ArrayList<List<Field>>();
        initializedBoard.add(firstRow);
        initializedBoard.add(secondRow);
        initializedBoard.add(thirdRow);
        initializedBoard.add(forthRow);
        initializedBoard.add(fifthRow);
        this.actualBoard = initializedBoard;
    }

    public List<List<Field>> getActualBoard() {
        return actualBoard;
    }

    public void setActualBoard(List<List<Field>> actualBoard) {
        this.actualBoard = actualBoard;
    }

    public void printActualBoard() {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                Field actualField = actualBoard.get(i).get(j);
                if (!actualField.isEmpty()) {
                    System.out.print(actualField.getStone().getOwnerColor().name() + "(" + i + "," + j + ")" + " ");
                } else {
                    System.out.print("ÜRES" + "(" + i + "," + j + ")" + " ");
                }
            }
            System.out.println();
        }

    }

    //TODO
    public boolean isGameOver() {
        boolean isGameOver = false;
        for (int i = 1; i < rowSize - 1 && !isGameOver; i++) {
            for (int j = 0; j < columnSize && !isGameOver; j++) {
                Field actualField = actualBoard.get(i).get(j);
                if (!actualField.isEmpty()) {
                    Stone.Color actualFieldOwnerColor = actualField.getStone().getOwnerColor();
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
                    Stone.Color actualFieldOwnerColor = actualField.getStone().getOwnerColor();
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
                    Stone.Color actualFieldOwnerColor = actualField.getStone().getOwnerColor();
                    if (!actualBoard.get(i - 1).get(j - 1).isEmpty() && !actualBoard.get(i - 1).get(j - 1).isEmpty()) {
                        if (actualBoard.get(i - 1).get(j - 1).getStone().getOwnerColor().equals(actualFieldOwnerColor) && actualBoard.get(i - 1).get(j - 1).getStone().getOwnerColor().equals(actualFieldOwnerColor)) {
                            isGameOver = true;
                            break;
                        }
                    }
                    if (!actualBoard.get(i + 1).get(j + 1).isEmpty() && !actualBoard.get(i + 1).get(j + 1).isEmpty()) {
                        if (actualBoard.get(i + 1).get(j + 1).getStone().getOwnerColor().equals(actualFieldOwnerColor) && actualBoard.get(i + 1).get(j + 1).getStone().getOwnerColor().equals(actualFieldOwnerColor)) {
                            isGameOver = true;
                        }
                    }
                }
            }
        }

        return isGameOver;
    }


}
