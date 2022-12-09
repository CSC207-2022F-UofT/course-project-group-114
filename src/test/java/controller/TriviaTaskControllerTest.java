package controller;
import org.junit.jupiter.api.Test;
import usecases.TriviaTask;

/**
 * Class representing tests for the TriviaTaskController
 * @author talia
 */

public class TriviaTaskControllerTest {

    /**
     * Checks that the activation status is correctly set to true.
     */

    @Test
    void checkActivationT(){
        TriviaTask.setActivatedStatus("TriviaTask", false);
        TriviaTaskController.setActivatedStatus(true);
        assert(TriviaTaskController.getActivatedStatus());
    }

    /**
     * Checks that the activation status is correctly set to false by controller.
     */
    @Test
    void checkActivationF(){
        TriviaTask.setActivatedStatus("TriviaTask", true);
        TriviaTaskController.setActivatedStatus(false);
        assert(!TriviaTaskController.getActivatedStatus());
    }

    /**
     * Checks that the TriviaTask controller correctly returns activated status true
     */
    @Test
    void checkGetActivatedT(){
        TriviaTaskController.setActivatedStatus(true);
        boolean activatedStatus = TriviaTaskController.getActivatedStatus();
        assert(activatedStatus);
    }

    /**
     * Checks that the trivia task controller correctly returns activated status false
     */
    @Test
    void checkGetActivatedF(){
        TriviaTaskController.setActivatedStatus(false);
        boolean activatedStatus = TriviaTaskController.getActivatedStatus();
        assert(!activatedStatus);
    }
}
