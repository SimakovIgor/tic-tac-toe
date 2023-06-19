package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.game.MarkInterface;
import uttt.utils.Symbol;

public class TestBoardTests {
    BoardInterface board_sim;

    @Before
    public void setUp() throws Exception {
        board_sim = UTTTFactory.createBoard();
    }

    @Test
    public void simpleSetPieceTest() {
        assertNotNull(board_sim);
    }

    @Test
    public void testWrongGetMarks() {
        MarkInterface[] marks = board_sim.getMarkInterfaces();
        assertNotNull("Invalid mark array", marks);
        assertTrue("invalid lenght", marks.length == 9);
    }

    @Test
    public void testWrongReturnIsClosed() {
        BoardInterface boardInterface = UTTTFactory.createBoard();
        assertNotNull(boardInterface);
        boardInterface.setMarkAt(Symbol.CROSS, 0);
        boardInterface.setMarkAt(Symbol.CIRCLE, 1);
        boardInterface.setMarkAt(Symbol.CROSS, 2);
        boardInterface.setMarkAt(Symbol.CIRCLE, 3);
        boardInterface.setMarkAt(Symbol.CROSS, 4);
        boardInterface.setMarkAt(Symbol.CIRCLE, 5);
        boardInterface.setMarkAt(Symbol.CROSS, 6);

        assertTrue(boardInterface.isClosed());
    }

    /*
     * 
     * 
     * MarkInterface[] marks = new MarkInterface[9];
     * marks[0] = UTTTFactory.createMark(Symbol.CIRCLE, 0);
     * marks[1] = UTTTFactory.createMark(Symbol.CIRCLE, 1);
     * marks[2] = UTTTFactory.createMark(Symbol.EMPTY, 2);
     * marks[3] = UTTTFactory.createMark(Symbol.CROSS, 3);
     * marks[4] = UTTTFactory.createMark(Symbol.CIRCLE, 4);
     * marks[5] = UTTTFactory.createMark(Symbol.CROSS, 5);
     * marks[6] = UTTTFactory.createMark(Symbol.EMPTY, 6);
     * marks[7] = UTTTFactory.createMark(Symbol.EMPTY, 7);
     * marks[8] = UTTTFactory.createMark(Symbol.CROSS, 8);
     */
    @Test
    public void testWrongSimpleSetMarkAt() {
        BoardInterface boardInterface = UTTTFactory.createBoard();
        assertNotNull(boardInterface);
        boardInterface.setMarkAt(Symbol.CIRCLE, 0);
        boardInterface.setMarkAt(Symbol.CROSS, 0);

        MarkInterface[] marks = boardInterface.getMarkInterfaces();
        assertEquals(Symbol.CIRCLE, marks[0].getSymbol());
    }

    @Test
    public void testWrongReturnIsMovePossible() {
        BoardInterface board_sim = UTTTFactory.createBoard();
        assertNotNull(board_sim);
        MarkInterface[] marks = board_sim.getMarkInterfaces();
        for (int i = 0; i < 9; i++) {
            marks[i].setSymbol(Symbol.EMPTY);
            assertTrue(board_sim.isMovePossible(i) == true);
        }
        for (int i = 0; i < 9; i++) {
            marks[i].setSymbol(Symbol.CIRCLE);
            assertTrue(board_sim.isMovePossible(i) == false);
        }

    }

    @Test
    public void testWrongReturnIsMovePossibleExc() {
        BoardInterface boardInterface = UTTTFactory.createBoard();
        assertNotNull(boardInterface);

        assertThrows(IllegalArgumentException.class, () -> boardInterface.isMovePossible(10));

    }

    @Test
    public void testWrongIndexSetMarkAt() {
        BoardInterface boardInterface = UTTTFactory.createBoard();
        assertNotNull(boardInterface);
        assertTrue(boardInterface.setMarkAt(Symbol.CIRCLE, 0));
        assertFalse(boardInterface.setMarkAt(Symbol.CROSS, 0));
    }

    @Test
    public void testWrongSetMarksShouldWork() {
        BoardInterface boardInterface = UTTTFactory.createBoard();
        assertNotNull(boardInterface);
        MarkInterface[] marks = new MarkInterface[9];
        for (int i = 0; i < 9; i++) {
            marks[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
            // marks[i].setSymbol(Symbol.EMPTY);
        }
        marks[0].setSymbol(Symbol.CIRCLE);
        marks[1].setSymbol(Symbol.CROSS);
        marks[2].setSymbol(Symbol.CIRCLE);
        marks[3].setSymbol(Symbol.CROSS);
        marks[4].setSymbol(Symbol.CIRCLE);
        marks[5].setSymbol(Symbol.CROSS);
        marks[6].setSymbol(Symbol.CIRCLE);
        marks[7].setSymbol(Symbol.CROSS);
        marks[8].setSymbol(Symbol.CIRCLE);

        boardInterface.setMarkInterfaces(marks);

        MarkInterface[] markInterfaces = boardInterface.getMarkInterfaces();
        assertEquals(markInterfaces[0].getSymbol(), marks[0].getSymbol());
        assertEquals(markInterfaces[1].getSymbol(), marks[1].getSymbol());
        assertEquals(markInterfaces[2].getSymbol(), marks[2].getSymbol());
        assertEquals(markInterfaces[3].getSymbol(), marks[3].getSymbol());
        assertEquals(markInterfaces[4].getSymbol(), marks[4].getSymbol());
        assertEquals(markInterfaces[5].getSymbol(), marks[5].getSymbol());
        assertEquals(markInterfaces[6].getSymbol(), marks[6].getSymbol());
        assertEquals(markInterfaces[7].getSymbol(), marks[7].getSymbol());
        assertEquals(markInterfaces[8].getSymbol(), marks[8].getSymbol());
    }

    @Test
    public void testWrongSetMarksException() {
        BoardInterface boardInterface = UTTTFactory.createBoard();
        MarkInterface[] marks = new MarkInterface[12];

        assertThrows(IllegalArgumentException.class, () -> boardInterface.setMarkInterfaces(marks));
    }

    @Test
    public void testWrongExceptionCaseSetMarkAt() {
        BoardInterface boardInterface = UTTTFactory.createBoard();
        assertNotNull(boardInterface);
        assertThrows(IllegalArgumentException.class, () -> boardInterface.setMarkAt(Symbol.CIRCLE, 10));
    }

    @Test
    public void testWrongWinConditionIsClosed() {
        BoardInterface boardInterface = UTTTFactory.createBoard();
        assertNotNull(boardInterface);
        boardInterface.setMarkAt(Symbol.CROSS, 0);
        boardInterface.setMarkAt(Symbol.CIRCLE, 1);
        boardInterface.setMarkAt(Symbol.CIRCLE, 2);
        boardInterface.setMarkAt(Symbol.CIRCLE, 3);
        // boardInterface.setMarkAt(Symbol.CIRCLE, 4);
        boardInterface.setMarkAt(Symbol.CROSS, 5);
        boardInterface.setMarkAt(Symbol.CROSS, 6);
        boardInterface.setMarkAt(Symbol.CROSS, 7);
        boardInterface.setMarkAt(Symbol.CIRCLE, 8);

        assertFalse(boardInterface.isClosed());
    }
}
