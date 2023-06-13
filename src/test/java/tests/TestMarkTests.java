package tests;

import static org.junit.Assert.*;
import org.junit.Before;

import org.junit.Test;

import uttt.game.MarkInterface;
import uttt.utils.Symbol;
import uttt.UTTTFactory;

public class TestMarkTests {

    @Test
    public void simpleSetPieceTest() {
        MarkInterface markInterface = UTTTFactory.createMark(Symbol.CIRCLE, 5);
        assertNotNull(markInterface);
    }

    @Test
    public void testWrongGetSymbol() {
        MarkInterface markInterface = UTTTFactory.createMark(Symbol.CIRCLE, 5);
        assertTrue("Wrong getSymble: should be \"CIRCLE\"", markInterface.getSymbol() == Symbol.CIRCLE);
        markInterface = UTTTFactory.createMark(Symbol.CROSS, 5);
        assertTrue("Wrong getSymble: should be \"CROSS\"", markInterface.getSymbol() == Symbol.CROSS);
        markInterface = UTTTFactory.createMark(Symbol.EMPTY, 5);
        assertTrue("Wrong getSymble: should be \"EMPTY\"", markInterface.getSymbol() == Symbol.EMPTY);
    }

    @Test
    public void testWrongSimpleGetPosition() {
        for (int i = 0; i < 9; ++i) {
            MarkInterface markInterface = UTTTFactory.createMark(Symbol.EMPTY, i);
            assertTrue("Wrong getPosition: should be \"" + i + "\"", markInterface.getPosition() == i);
        }

    }

    @Test
    public void testNoExceptionSetSymbol() {
        MarkInterface markInterface = UTTTFactory.createMark(Symbol.EMPTY, 0);
        assertTrue("Wrong setSymbol: should be \"EMPTY\"", Symbol.EMPTY == markInterface.getSymbol());
        markInterface.setSymbol(Symbol.CIRCLE);
        assertTrue("Wrong setSymbol: should be \"CIRCLE\"", Symbol.CIRCLE == markInterface.getSymbol());
        markInterface.setSymbol(Symbol.CROSS);
        assertTrue("Wrong setSymbol: should be \"CROSS\"", Symbol.CROSS == markInterface.getSymbol());
    }
}
