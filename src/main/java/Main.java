import game.pojo.Board;
import game.pojo.GamePlayUtil;
import game.pojo.Player;

import java.io.IOException;

/**
 * Created by Headswitcher on 2017. 05. 26..
 */
public class Main {

    public static void main(String[] args) {

        Board board = new Board();
        Player player1 = Player.getBluePlayer();
        Player player2 = Player.getRedPlayer();

        Player actualPlayer = player2;
        System.out.println("Játék kezdete: " +
                "Az első játékos birtokolja a kék korongokat, " +
                "a második játékos pedig a pirosakat!");
        board.printActualBoard();

        player1.setName("Első játékos");
        player2.setName("Második Játékos");

        System.out.println("Válasz egy korongot , majd hogy melyik pozítcióra lépnél vele!");
        System.out.println("Az alábbi formában: (SOR,OSZLOP)-(SOR,OSZLOP)");
        System.out.println("Az első két pos írja le hogy honnan a második hogy hova");
        System.out.println("Például: 0,0-1,0");
        System.out.println("Fel,le,jobbra,illetve balra léphetsz a saját korongoddal egy nemüres pozítcióra");
        while (!board.isGameOver()) {

            if (actualPlayer.getName().equals(player1.getName()) && player1.getPlayerColor().equals(actualPlayer.getPlayerColor())) {
                actualPlayer = player2;
            } else {
                actualPlayer = player1;
            }
            System.out.println(actualPlayer.getName() + " következik, a színed:" + actualPlayer.getPlayerColor());
            try {
                GamePlayUtil.processChoice(board, actualPlayer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            board.printActualBoard();
        }

        System.out.println("A győztes " + actualPlayer.getName() + "(" + actualPlayer.getPlayerColor().name() + ")");

    }

}
