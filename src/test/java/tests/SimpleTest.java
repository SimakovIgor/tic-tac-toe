package tests;

import org.junit.Before;
import org.junit.Test;
import uttt.UTTTFactory;
import uttt.game.SimulatorInterface;

import static org.junit.Assert.assertNotNull;

public class SimpleTest {

    private SimulatorInterface simulator;

    @Before
    public void setUp() {
        simulator = UTTTFactory.createSimulator();

    }

    @Test
    public void simpleSetPieceTest() {
        assertNotNull(simulator);
    }

}
