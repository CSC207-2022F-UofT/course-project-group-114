package presenter;

import org.junit.jupiter.api.Test;
import usecases.PhoneNumberTask;

/**
 * Class representing the tests for the PhoneNumberTaskPresenter class.
 *
 * @author Kaavya Kalani
 */
public class PhoneNumberTaskPresenterTest {

    /**
     * Tests if the "Correct" string is correctly generated according to the correctness
     * status got from the use case class. Also tests if the completion status
     * is updated correctly.
     */
    @Test
    void testCorrectAnswer(){
        PhoneNumberTaskPresenter presenter = new PhoneNumberTaskPresenter();
        PhoneNumberTask.checkCorrectness(194823723, 194823723);
        assert(presenter.correctnessStatus().equals("Correct"));
        assert(PhoneNumberTask.getCompletionStatus("PhoneNumberTask"));
    }

    /**
     * Tests if the "Incorrect" string is correctly generated according to the
     * correctness status got from the use case class. Also tests if the
     * completion status is updated correctly.
     */
    @Test
    void testIncorrectAnswer(){
        PhoneNumberTaskPresenter presenter = new PhoneNumberTaskPresenter();
        PhoneNumberTask.checkCorrectness(194823723, 194823724);
        assert(presenter.correctnessStatus().equals("Incorrect"));
        assert(!PhoneNumberTask.getCompletionStatus("PhoneNumberTask"));
    }

    /**
     * Tests if the completion status is updated correctly when the result
     * of check is correct.
     */
    @Test
    void testCorrectStatusUpdateTrue(){
        PhoneNumberTaskPresenter presenter = new PhoneNumberTaskPresenter();
        PhoneNumberTask.checkCorrectness(194823723, 194823723);
        presenter.correctnessStatus();
        assert(PhoneNumberTask.getCompletionStatus("PhoneNumberTask"));
    }

    /**
     * Tests if the completion status is updated correctly when the result
     * of check is Incorrect.
     */
    @Test
    void testCorrectStatusUpdateFalse(){
        PhoneNumberTaskPresenter presenter = new PhoneNumberTaskPresenter();
        PhoneNumberTask.checkCorrectness(194823723, 194823724);
        presenter.correctnessStatus();
        assert(!PhoneNumberTask.getCompletionStatus("PhoneNumberTask"));
    }

    /**
     * Tests that the setCompletionStatus method sets the status to true correctly.
     */
    @Test
    void testCompletionStatusTrue(){
        PhoneNumberTask.setCompletionStatus("PhoneNumberTask", false);
        PhoneNumberTaskPresenter.setCompletionStatus(true);
        assert(PhoneNumberTask.getCompletionStatus("PhoneNumberTask"));
    }

    /**
     * Tests that the setCompletionStatus method sets the status to false correctly.
     */
    @Test
    void testCompletionStatusFalse(){
        PhoneNumberTask.setCompletionStatus("PhoneNumberTask", true);
        PhoneNumberTaskPresenter.setCompletionStatus(false);
        assert(!PhoneNumberTask.getCompletionStatus("PhoneNumberTask"));
    }
}
