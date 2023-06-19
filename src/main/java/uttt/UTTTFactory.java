package uttt;

import uttt.game.*;
import uttt.game.impl.BoardInterfaceImpl;
import uttt.game.impl.MarkInterfaceImpl;
import uttt.game.impl.PlayerInterfaceImpl;
import uttt.game.impl.SimulatorInterfaceImpl;
import uttt.ui.GUI;
import uttt.utils.Symbol;

public class UTTTFactory {

    /**
     * Create a Ultimate TicTacToe mark on board index j.
     *
     * @param symbol The symbol for the new mark.
     * @param j      The index of the piece in its board.
     * @return A Ultimate TicTacToe mark.
     */
    public static MarkInterface createMark(Symbol symbol, int j) {
        return new MarkInterfaceImpl(symbol, j);
    }

    /**
     * Create a Ultimate TicTacToe board.
     *
     * @return A Ultimate TicTacToe board.
     */
    public static BoardInterface createBoard() {
        MarkInterface[] marks = new MarkInterface[9];
        for (int i = 0; i < 9; i++) {
            marks[i] = createMark(Symbol.EMPTY, i);
        }

        return new BoardInterfaceImpl(marks);
    }

    /**
     * Create a Ultimate TicTacToe simulator.
     *
     * @return A Ultimate TicTacToe simulator.
     */
    public static SimulatorInterface createSimulator() {
        BoardInterface[] boards = new BoardInterface[9];
        for (int i = 0; i < 9; i++) {
            boards[i] = createBoard();
        }

        return new SimulatorInterfaceImpl(boards);
    }

    /**
     * Create a user interface for a Ultimate TicTacToe simulator.
     *
     * @param symbol Indicates if a simple TicTacTac Toe UI or Ultimate TicTacToe
     *               UI should be started.
     * @return A graphical user interface for a Ultimate TicTacToe simulator.
     */
    public static UserInterface createUserInterface(boolean playUTTT) {
        return new GUI(playUTTT);
    }

    /**
     * Create a Human Ultimate TicTacToe player.
     *
     * @param symbol The symbol the player uses during the game.
     * @return A Ultimate TicTacToe player that uses the user interface to
     * communicate with the human player to select moves.
     */
    public static PlayerInterface createHumanPlayer(Symbol symbol) {
        PlayerInterface player0;
        PlayerInterface player = new PlayerInterfaceImpl(symbol);
        player0 = player;
        return player0;
    }

    /**
     * !!! Relevant for BONUS exercise only. !!!
     * <p>
     * Create a Computer Ultimate TicTacToe player.
     *
     * @param symbol The symbol the player uses during the game.
     * @return A Ultimate TicTacToe player that will play automatically.
     */
    public static PlayerInterface createBonusPlayer(Symbol symbol) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
