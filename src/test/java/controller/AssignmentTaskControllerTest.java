package controller;

import org.junit.jupiter.api.Test;
import controller.AssignmentTaskController;
import usecases.AssignmentTask;

/**
 * The AssignmentTaskTest class checks methods in AssignmentTask.java.
 *
 * @author uoft-flyfreejay
 * @version 1.0
 * @since 2022-12-02
 */

public class AssignmentTaskControllerTest {
    // test if validate works correctly succeeds with correct parameters
    @Test
    void testValidateCorrect(){
        assert(AssignmentTaskController.validate(AssignmentTaskController.getCharacterCountNeeded()));
    }

    // test if validate fails correctly
    @Test
    void testValidateWrong(){
        //this should always fail because of precondition
        AssignmentTaskController.setCompletionStatus(false);
        assert(!AssignmentTaskController.validate(-1));
    }
}
