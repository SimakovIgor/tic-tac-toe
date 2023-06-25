package tests;

import org.junit.Before;
import org.junit.Test;
import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.game.SimulatorInterface;
import uttt.utils.Symbol;

import static org.junit.Assert.*;

public class TestSimulatorTests {

    private SimulatorInterface simulatorInterface;

    private static void fillGameBoardsWithEmpty(BoardInterface[] boards) {
        for (int i = 0; i < 9; i++) {
            boards[i] = UTTTFactory.createBoard();
            for (int j = 0; j < 9; j++) {
                boards[i].setMarkAt(Symbol.EMPTY, j);
            }
        }
    }

    @Before
    public void beforeEach() {
        simulatorInterface = UTTTFactory.createSimulator();
    }

    @Test
    public void simpleSetPieceTest() {
        assertNotNull(simulatorInterface);
    }

    @Test
    public void testWrongGetWinnerCross() {
        BoardInterface[] boards = new BoardInterface[9];
        fillGameBoardsWithEmpty(boards);

        Symbol cross = Symbol.CROSS;

        boards[1].setMarkAt(cross, 1);
        boards[1].setMarkAt(cross, 4);
        boards[1].setMarkAt(cross, 7);

        boards[4].setMarkAt(cross, 1);
        boards[4].setMarkAt(cross, 4);
        boards[4].setMarkAt(cross, 7);

        boards[7].setMarkAt(cross, 1);
        boards[7].setMarkAt(cross, 4);
        boards[7].setMarkAt(cross, 7);

        simulatorInterface.setBoards(boards);
        assertEquals(cross, simulatorInterface.getWinner());
        assertTrue(simulatorInterface.isGameOver());

    }

    @Test
    public void testWrongGetWinnerCircle() {
        BoardInterface[] boards = new BoardInterface[9];
        fillGameBoardsWithEmpty(boards);

        Symbol circle = Symbol.CIRCLE;

        boards[0].setMarkAt(circle, 0);
        boards[0].setMarkAt(circle, 4);
        boards[0].setMarkAt(circle, 8);

        boards[4].setMarkAt(circle, 0);
        boards[4].setMarkAt(circle, 4);
        boards[4].setMarkAt(circle, 8);

        boards[8].setMarkAt(circle, 0);
        boards[8].setMarkAt(circle, 4);
        boards[8].setMarkAt(circle, 8);

        simulatorInterface.setBoards(boards);

        assertEquals(circle, simulatorInterface.getWinner());
        assertTrue(simulatorInterface.isGameOver());
    }

    @Test
    public void testWrongGetWinnerEmpty() {
        assertEquals(Symbol.EMPTY, simulatorInterface.getWinner());
        assertFalse(simulatorInterface.isGameOver());
    }

    @Test
    public void isMovePossibleDoubleArgsThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> simulatorInterface.isMovePossible(123, 122));
    }

    @Test
    public void isMovePossibleDoubleArgsFalse() {
        simulatorInterface.setCurrentPlayerSymbol(Symbol.CROSS);
        simulatorInterface.setMarkAt(Symbol.CROSS, 2, 4);
        assertFalse(simulatorInterface.isMovePossible(0, 0));
    }

    @Test
    public void isMovePossibleDoubleArgsTrue() {
        simulatorInterface.setCurrentPlayerSymbol(Symbol.CROSS);
        simulatorInterface.setMarkAt(Symbol.CROSS, 2, 4);
        assertTrue(simulatorInterface.isMovePossible(4, 0));
    }

    @Test
    public void isMovePossibleThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> simulatorInterface.isMovePossible(15));
    }

    @Test
    public void isMovePossibleFalse() {
        simulatorInterface.setCurrentPlayerSymbol(Symbol.CROSS);
        simulatorInterface.setMarkAt(Symbol.CROSS, 2, 4);
        assertFalse(simulatorInterface.isMovePossible(1));
    }

    @Test
    public void isMovePossibleTrue() {
        simulatorInterface.setCurrentPlayerSymbol(Symbol.CROSS);
        simulatorInterface.setMarkAt(Symbol.CROSS, 2, 4);
        assertTrue(simulatorInterface.isMovePossible(4));
    }

    @Test
    public void getIndexNextBoardFirstStep() {
        assertEquals(-1, simulatorInterface.getIndexNextBoard());
    }

    @Test
    public void getIndexNextBoardNotFirstStep() {
        simulatorInterface.setCurrentPlayerSymbol(Symbol.CROSS);
        simulatorInterface.setMarkAt(Symbol.CROSS, 2, 4);
        assertEquals(4, simulatorInterface.getIndexNextBoard());
    }

    @Test
    public void setMarkAtShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> simulatorInterface.setMarkAt(Symbol.CROSS, 123, 421));
    }

    @Test
    public void setMarkAtTrue() {
        simulatorInterface.setCurrentPlayerSymbol(Symbol.CROSS);
        assertTrue(simulatorInterface.setMarkAt(Symbol.CROSS, 2, 4));
    }

    @Test
    public void setMarkAtFalse() {
        simulatorInterface.setCurrentPlayerSymbol(Symbol.CROSS);
        simulatorInterface.setMarkAt(Symbol.CROSS, 2, 4);
        simulatorInterface.setCurrentPlayerSymbol(Symbol.CIRCLE);
        assertFalse(simulatorInterface.setMarkAt(Symbol.CIRCLE, 0, 0));
    }

    @Test
    public void testWrongSetMarkAtPositionX() {
        BoardInterface[] boards = new BoardInterface[9];
        fillGameBoardsWithEmpty(boards);
        simulatorInterface.setBoards(boards);
        simulatorInterface.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simulatorInterface.setMarkAt(Symbol.CIRCLE, 4, 4);
        simulatorInterface.setCurrentPlayerSymbol(Symbol.CROSS);
        assertFalse(simulatorInterface.setMarkAt(Symbol.CROSS, 4, 4));
    }

    @Test
    public void testWrongSetMarkAtNull() {
        BoardInterface[] boards = new BoardInterface[9];
        fillGameBoardsWithEmpty(boards);
        simulatorInterface.setBoards(boards);
        for (int i = 0; i < 9; i++) {
            boards[i] = null;
        }

        assertThrows(IllegalArgumentException.class,
                () -> simulatorInterface.setMarkAt(Symbol.CROSS, 0, 0));

    }

    @Test
    public void getCurrentPlayerCross() {
        simulatorInterface.setCurrentPlayerSymbol(Symbol.CROSS);
        simulatorInterface.setMarkAt(Symbol.CROSS, 2, 4);
        simulatorInterface.setCurrentPlayerSymbol(Symbol.CIRCLE);
        assertEquals(Symbol.CIRCLE, simulatorInterface.getCurrentPlayerSymbol());
    }

    @Test
    public void getCurrentPlayerCircle() {
        simulatorInterface.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simulatorInterface.setMarkAt(Symbol.CIRCLE, 2, 4);
        simulatorInterface.setCurrentPlayerSymbol(Symbol.CROSS);
        assertEquals(Symbol.CROSS, simulatorInterface.getCurrentPlayerSymbol());
    }

    @Test
    public void getCurrentPlayerEmpty() {
        assertEquals(Symbol.EMPTY, simulatorInterface.getCurrentPlayerSymbol());
    }

    @Test
    public void getBoardsSuccess() {
        BoardInterface[] boards = new BoardInterface[9];
        fillGameBoardsWithEmpty(boards);
        boards[0].setMarkAt(Symbol.CROSS, 0);

        simulatorInterface.setBoards(boards);
        BoardInterface[] actualBoards = simulatorInterface.getBoards();

        assertEquals(Symbol.CROSS, actualBoards[0].getMarkInterfaces()[0].getSymbol());
        assertEquals(Symbol.EMPTY, actualBoards[0].getMarkInterfaces()[1].getSymbol());
    }

}
