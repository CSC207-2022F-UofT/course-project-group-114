import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.LifeMaster;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class LifeMasterTest {
    @Test
    void testDeductLifeInitialLifeLost() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        LifeMaster.reset();
        int initialLives = LifeMaster.getLives();
        LifeMaster.deductLife();
        assert(initialLives == LifeMaster.getLives() + 1);
    }

    @Test
    void testDeductLifeLastLifeLost() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        LifeMaster.reset();
        int initLives = LifeMaster.getLives();
        for (int i = 0; i < initLives; i++) {
            LifeMaster.deductLife();
        }
        assert(LifeMaster.getLives() == 0);
    }

    @Test
    void testLifeMasterInitialTaskCount() {
        LifeMaster.reset();
        assert(LifeMaster.getTaskCount() == 0);
    }

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
