package usecases;

import org.junit.jupiter.api.Test;

import usecases.LifeMaster;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * Class representing tests for the LifeMaster use case class.
 *
 * @author Elena Scobici
 */

public class LifeMasterTest {
    /**
     * Test that the value of LifeMaster.getLives() changes correctly when 1 life is deducted from the initial state.
     * @throws ClassNotFoundException If the needed class is not found
     * @throws InvocationTargetException If an exception is thrown within the invoked method
     * @throws NoSuchMethodException If the needed method is not found
     * @throws IllegalAccessException If the needed class or method cannot be accessed
     */
    @Test
    void testDeductLifeInitialLifeLost() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        LifeMaster.reset();
        int initialLives = LifeMaster.getLives();
        LifeMaster.deductLife();
        assert(initialLives == LifeMaster.getLives() + 1);
    }

    /**
     * Test that, if every life is deducted one by one, we are left with 0 lives.
     * @throws ClassNotFoundException If the needed class is not found
     * @throws InvocationTargetException If an exception is thrown within the invoked method
     * @throws NoSuchMethodException If the needed method is not found
     * @throws IllegalAccessException If the needed class or method cannot be accessed
     */
    @Test
    void testDeductLifeLastLifeLost() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        LifeMaster.reset();
        int initLives = LifeMaster.getLives();
        for (int i = 0; i < initLives; i++) {
            LifeMaster.deductLife();
        }
        assert(LifeMaster.getLives() == 0);
    }

    /**
     * Test that the initial task count is 0.
     */
    @Test
    void testLifeMasterInitialTaskCount() {
        LifeMaster.reset();
        assert(LifeMaster.getTaskCount() == 0);
    }

    /**
     * Test that, if we call incrementTaskCount() a random number of times, that number will be the value of
     * LifeMaster.getTaskCount().
     */
    @Test
    void testIncrementTaskCountRand() {
        LifeMaster.reset();
        Random rand = new Random();
        int randInt = rand.nextInt(20);
        for (int i = 0; i < randInt; i++) {
            LifeMaster.incrementTaskCount();
        }
        assert(LifeMaster.getTaskCount() == randInt);
    }
}
