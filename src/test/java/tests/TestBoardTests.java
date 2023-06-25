package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.game.MarkInterface;
import uttt.utils.Symbol;

public class TestBoardTests {
    private BoardInterface boardInterface;

    @Before
    public void setUp() {
        boardInterface = UTTTFactory.createBoard();
    }

    @Test
    public void simpleSetPieceTest() {
        assertNotNull(boardInterface);
    }

    @Test
    public void testWrongGetMarks() {
        MarkInterface[] marks = boardInterface.getMarkInterfaces();
        assertNotNull("Invalid mark array", marks);
        assertEquals("invalid lenght", 9, marks.length);
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

    @Test
    public void testWrongSimpleSetMarkAt() {
        boardInterface.setMarkAt(Symbol.CIRCLE, 0);
        boardInterface.setMarkAt(Symbol.CROSS, 0);

        MarkInterface[] marks = boardInterface.getMarkInterfaces();
        assertEquals(Symbol.CIRCLE, marks[0].getSymbol());
    }

    @Test
    public void testWrongReturnIsMovePossible() {
        MarkInterface[] marks = boardInterface.getMarkInterfaces();
        for (int i = 0; i < 9; i++) {
            marks[i].setSymbol(Symbol.EMPTY);
            assertTrue(boardInterface.isMovePossible(i));
        }
        for (int i = 0; i < 9; i++) {
            marks[i].setSymbol(Symbol.CIRCLE);
            assertFalse(boardInterface.isMovePossible(i));
        }

    }

    @Test
    public void testWrongReturnIsMovePossibleExc() {
        assertThrows(IllegalArgumentException.class, () -> boardInterface.isMovePossible(10));
    }

    @Test
    public void testWrongIndexSetMarkAt() {
        assertTrue(boardInterface.setMarkAt(Symbol.CIRCLE, 0));
        assertFalse(boardInterface.setMarkAt(Symbol.CROSS, 0));
    }

    @Test
    public void testWrongSetMarksShouldWork() {
        MarkInterface[] marks = new MarkInterface[9];
        for (int i = 0; i < 9; i++) {
            marks[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
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
        MarkInterface[] marks = new MarkInterface[12];
        assertThrows(IllegalArgumentException.class,
                () -> boardInterface.setMarkInterfaces(marks));
    }

    @Test
    public void testWrongExceptionCaseSetMarkAt() {
        assertThrows(IllegalArgumentException.class,
                () -> boardInterface.setMarkAt(Symbol.CIRCLE, 10));
    }

    @Test
    public void testWrongWinConditionIsClosed() {
        assertNotNull(boardInterface);
        boardInterface.setMarkAt(Symbol.CROSS, 0);
        boardInterface.setMarkAt(Symbol.CIRCLE, 1);
        boardInterface.setMarkAt(Symbol.CIRCLE, 2);
        boardInterface.setMarkAt(Symbol.CIRCLE, 3);
        boardInterface.setMarkAt(Symbol.CROSS, 5);
        boardInterface.setMarkAt(Symbol.CROSS, 6);
        boardInterface.setMarkAt(Symbol.CROSS, 7);
        boardInterface.setMarkAt(Symbol.CIRCLE, 8);

        assertFalse(boardInterface.isClosed());
    }
}
