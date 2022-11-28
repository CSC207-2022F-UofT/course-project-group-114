import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.AssignmentTask;

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
        assert(!AssignmentTask.getActivatedStatus());
        assert(AssignmentTask.getCompletionStatus());
    }

    @Test
    void testCheckCountWrong(){
        AssignmentTask.setCharacterCountNeeded();
        AssignmentTask.setCurrentCharacterCount(-1);   // which is always wrong by the precondition/design
        AssignmentTask.checkCount();
        assert(!AssignmentTask.getActivatedStatus());  //this should be kept false until GameMaster activates
        assert(!AssignmentTask.getCompletionStatus());
    }

    @Test
    void testReset(){
        // test if reset() properly resets needed variables
        AssignmentTask.reset();
        assert(!AssignmentTask.getCompletionStatus());
    }
}
