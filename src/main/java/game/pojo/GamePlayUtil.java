package game.pojo;

import java.io.IOException;

/**
 * Created by Headswitcher on 2017. 05. 27..
 */
public class GamePlayUtil {

    public static void processChoice(String playerChoice, Board actualBoard, Player actualPlayer) throws IOException {
        //(0,0)-(1,0) example

        String[] twoFieldCoordinate = playerChoice.split("-");
        String fromCoordinates = twoFieldCoordinate[0];
        String[] splitedFromCoordinate = fromCoordinates.split(",");
        Integer fromRow = new Integer(splitedFromCoordinate[0]);
        Integer fromColumn = new Integer(splitedFromCoordinate[1]);

        String toCoordinates = twoFieldCoordinate[1];
        String[] splitedToCoordinate = toCoordinates.split(",");
        Integer toRow = new Integer(splitedToCoordinate[0]);
        Integer toColumn = new Integer(splitedToCoordinate[1]);

        Field fromField = actualBoard.actualBoard.get(fromRow).get(fromColumn);
        Field toField = actualBoard.actualBoard.get(toRow).get(toColumn);
        if (!fromField.isEmpty() && fromField.getStone().getOwnerColor().equals(actualPlayer.playerColor)
                && toField.isEmpty()) {

            toField.setEmpty(false);
            toField.setStone(fromField.getStone());

            fromField.setEmpty(true);
            fromField.setStone(null);
        }
    }
}
