package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.game.MarkInterface;
import uttt.utils.Symbol;

public class TestBoardTests {

    @Test
    public void testWrongGetMarks() {
        BoardInterface boardInterface = UTTTFactory.createBoard();
        MarkInterface[] marks = boardInterface.getMarks();
        assertNotNull("Invalid mark array", marks);
        assertTrue("invalid lenght", marks.length == 9);
    }

    @Test
    public void testWrongReturnIsClosed() {
        BoardInterface boardInterface = UTTTFactory.createBoard();
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
        BoardInterface boardInterface = UTTTFactory.createBoard();

        boardInterface.setMarkAt(Symbol.CIRCLE, 0);
        boardInterface.setMarkAt(Symbol.CROSS, 0);

        MarkInterface[] marks = boardInterface.getMarks();
        assertEquals(Symbol.CIRCLE, marks[0].getSymbol());
    }

    @Test
    public void testWrongReturnIsMovePossible() {
        BoardInterface boardInterface = UTTTFactory.createBoard();
        MarkInterface[] marks = boardInterface.getMarks();
        for (int i = 0; i < 9; i++) {
            marks[i].setSymbol(Symbol.CIRCLE);
            assertTrue(boardInterface.isMovePossible(i) == false);
        }

    }

    @Test
    public void testWrongIndexSetMarkAt() {
        BoardInterface boardInterface = UTTTFactory.createBoard();
        assertTrue(boardInterface.setMarkAt(Symbol.CIRCLE, 0));
        assertFalse(boardInterface.setMarkAt(Symbol.CROSS, 0));
    }

    //TODO: send
    @Test
    public void testWrongSetMarksShouldWork() {
        BoardInterface boardInterface = UTTTFactory.createBoard();

        MarkInterface[] marks = new MarkInterface[9];
        for (MarkInterface mark : marks) {
            mark.setSymbol(Symbol.EMPTY);
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

        boardInterface.setMarks(marks);

        MarkInterface[] markInterfaces = boardInterface.getMarks();
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
    public void testWrongExceptionCaseSetMarkAt() {
        BoardInterface boardInterface = UTTTFactory.createBoard();
        assertThrows(IllegalArgumentException.class, () ->
                boardInterface.setMarkAt(Symbol.CIRCLE, 10));
    }

    @Test
    public void testWrongWinConditionIsClosed() {
        BoardInterface boardInterface = UTTTFactory.createBoard();
        boardInterface.setMarkAt(Symbol.CROSS, 0);
        boardInterface.setMarkAt(Symbol.CIRCLE, 1);
        boardInterface.setMarkAt(Symbol.CIRCLE, 2);
        boardInterface.setMarkAt(Symbol.CIRCLE, 3);
        boardInterface.setMarkAt(Symbol.CIRCLE, 4);
        boardInterface.setMarkAt(Symbol.CROSS, 5);
        boardInterface.setMarkAt(Symbol.CROSS, 6);
        boardInterface.setMarkAt(Symbol.CROSS, 7);
        boardInterface.setMarkAt(Symbol.CIRCLE, 8);

        assertFalse(boardInterface.isClosed());
    }

}
