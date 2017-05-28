package game.pojo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Headswitcher on 2017. 05. 27..
 */
public class GamePlayUtil {

    public static void processChoice(Board actualBoard, Player actualPlayer) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String playerChoice = reader.readLine();

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

        if (!fromField.isEmpty() && fromField.getStone().getOwnerColor().equals(actualPlayer.getPlayerColor()) && toField.isEmpty() &&
                (((fromRow + 1 == toRow || fromRow - 1 == toRow) && fromColumn.intValue() == toColumn.intValue())
                        || ((fromColumn + 1 == toColumn || fromColumn - 1 == toColumn) && toRow.intValue() == fromRow.intValue()))) {

            toField.setEmpty(false);
            toField.setStone(fromField.getStone());

            fromField.setEmpty(true);
            fromField.setStone(null);
        } else {
            System.out.println("Ezt nem lépheted meg,kérlek válassz egy másik helyes lépést.");
            processChoice(actualBoard, actualPlayer);
        }
    }
}
