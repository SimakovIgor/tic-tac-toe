package tests;

import static org.junit.Assert.*;
import org.junit.Before;

import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.MarkInterface;
import uttt.utils.Symbol;

public class TestMarkTests {
    MarkInterface mark_sim;

    @Before
    public void setUp() throws Exception {
        mark_sim = UTTTFactory.createMark(Symbol.CIRCLE, 5);
    }

    @Test
    public void simpleSetPieceTest() {
        assertNotNull(mark_sim);
    }

    //
    @Test
    public void testWrongGetSymbol() {
        assertTrue("Wrong getSymble: should be \"CIRCLE\"", mark_sim.getSymbol() == Symbol.CIRCLE);
        mark_sim = UTTTFactory.createMark(Symbol.CROSS, 5);
        assertTrue("Wrong getSymble: should be \"CROSS\"", mark_sim.getSymbol() == Symbol.CROSS);
        mark_sim = UTTTFactory.createMark(Symbol.EMPTY, 5);
        assertTrue("Wrong getSymble: should be \"EMPTY\"", mark_sim.getSymbol() == Symbol.EMPTY);

    }

    @Test
    public void testWrongSimpleGetPosition() {
        for (int i = 0; i < 9; ++i) {
            mark_sim = UTTTFactory.createMark(Symbol.EMPTY, i);
            assertTrue("Wrong getPosition: should be \"" + i + "\"", mark_sim.getPosition() == i);
        }

    }

    // @Test
    // public void testExceptionSetSymbol() {
    // MarkInterface mark_sim2 = UTTTFactory.createMark(Symbol.CROSS, 5);
    // assertNotNull(mark_sim2);
    // assertThrows(IllegalArgumentException.class, () ->
    // mark_sim2.setSymbol(Symbol.EMPTY));
    // }

    @Test
    public void testNoExceptionSetSymbol() {
        MarkInterface mark_sim3 = UTTTFactory.createMark(Symbol.EMPTY, 0);
        assertNotNull(mark_sim3);

        mark_sim3.setSymbol(Symbol.CIRCLE);
        assertTrue("Wrong setSymbol: should be \"CIRCLE\"", Symbol.CIRCLE == mark_sim3.getSymbol());

        // mark_sim.setSymbol(Symbol.CROSS);
        // assertTrue("Wrong setSymbol: should be \"CROSS\"", Symbol.CROSS ==
        // mark_sim.getSymbol());

    }

}
