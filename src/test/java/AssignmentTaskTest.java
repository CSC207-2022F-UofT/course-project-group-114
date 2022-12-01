import org.junit.jupiter.api.Test;

import usecases.AssignmentTask;

/**
 * The AssignmentTaskTest class checks methods in AssignmentTask.java.
 *
 * @author uoft-flyfreejay
 * @version 1.0
 * @since 2022-11-30
 */
public class AssignmentTaskTest {
    // to test the use case:
    // of other classes calling the class methods
    // 1) Test checkCount()
    // 2) Test reset()
    @Test
    void testCheckCountCorrect(){
        // first set character count needed
        // next test whether implementation of methods work properly around that arbitrary random characterCountNeeded
        AssignmentTask.setCharacterCountNeeded();
        AssignmentTask.setCurrentCharacterCount(AssignmentTask.getCharacterCountNeeded());
        AssignmentTask.checkCount();
        assert(!AssignmentTask.getActivatedStatus("AssignmentTask"));
        assert(AssignmentTask.getCompletionStatus("AssignmentTask"));
    }

    @Test
    void testCheckCountWrong(){
        boolean oldActivatedStatus = AssignmentTask.getActivatedStatus("AssignmentTask");
        AssignmentTask.setCharacterCountNeeded();
        AssignmentTask.setCurrentCharacterCount(-1);   // which is always wrong by the precondition/design
        AssignmentTask.checkCount();
        // if checkCount fails, activatedStatus should remain the same
        assert(AssignmentTask.getActivatedStatus("AssignmentTask") == oldActivatedStatus);
        assert(!AssignmentTask.getCompletionStatus("AssignmentTask"));
    }

    @Test
    void testReset(){
        // test if reset() properly resets needed variables
        AssignmentTask.reset();
        assert(!AssignmentTask.getCompletionStatus("AssignmentTask"));
    }
}
