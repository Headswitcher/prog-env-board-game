import game.pojo.Board;
import game.pojo.GamePlayUtil;
import game.pojo.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Headswitcher on 2017. 05. 26..
 */
public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Board board = new Board();
        Player player1 = Player.getBluePlayer();
        Player player2 = Player.getRedPlayer();

        Player actualPlayer = player1;
        System.out.println("Játék kezdete: " +
                "Az első játékos birtokolja a kék korongokat, " +
                "a második játékos pedig a pirosakat!");
        board.printActualBoard();
        System.out.println("Válasz egy korongot , majd hogy melyik pozítcióra lépnél vele!");
        System.out.println("Az alábbi formában: (SOR,OSZLOP)-(SOR,OSZLOP)");
        System.out.println("Az első két pos írja le hogy honnan a második hogy hova");
        System.out.println("Például: 0,0-1,0");
        System.out.println("Fel,le,jobbra,illetve balra léphetsz a saját korongoddal egy nemüres pozítcióra");
        while (!board.isGameOver()) {
            String playerChoice = null;
            try {
                playerChoice = reader.readLine();
                GamePlayUtil.processChoice(playerChoice, board, actualPlayer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            board.printActualBoard();
        }


    }

}
