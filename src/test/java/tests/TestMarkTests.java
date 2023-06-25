package tests;

import org.junit.Before;
import org.junit.Test;
import uttt.UTTTFactory;
import uttt.game.MarkInterface;
import uttt.utils.Symbol;

import static org.junit.Assert.*;

public class TestMarkTests {
    MarkInterface markInterface;

    @Before
    public void setUp() {
        markInterface = UTTTFactory.createMark(Symbol.CIRCLE, 5);
    }

    @Test
    public void simpleSetPieceTest() {
        assertNotNull(markInterface);
    }

    @Test
    public void testWrongGetSymbol() {
        assertSame(Symbol.CIRCLE, markInterface.getSymbol());
        markInterface = UTTTFactory.createMark(Symbol.CROSS, 5);
        assertSame(Symbol.CROSS, markInterface.getSymbol());
        markInterface = UTTTFactory.createMark(Symbol.EMPTY, 5);
        assertSame(Symbol.EMPTY, markInterface.getSymbol());

    }

    @Test
    public void testWrongSimpleGetPosition() {
        for (int i = 0; i < 9; ++i) {
            markInterface = UTTTFactory.createMark(Symbol.EMPTY, i);
            assertEquals(markInterface.getPosition(), i);
        }

    }

    @Test
    public void testNoExceptionSetSymbol() {
        MarkInterface markInterface = UTTTFactory.createMark(Symbol.EMPTY, 0);
        markInterface.setSymbol(Symbol.CIRCLE);
        assertSame(Symbol.CIRCLE, markInterface.getSymbol());
    }

}
