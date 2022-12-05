package usecases;

import org.junit.jupiter.api.Test;

/**
 * Class representing tests for PhoneNumberTask use case class.
 *
 * @author Kaavya Kalani
 */
public class PhoneNumberTaskTest {

    /**
     * Tests if the correct is updated correctly when the same inputs are provided.
     */
    @Test
    void testCheckCorrectAnswer(){
        PhoneNumberTask.checkCorrectness(194823723, 194823723);
        assert(PhoneNumberTask.correct);
        assert(PhoneNumberTask.getCompletionStatus("PhoneNumberTask"));
    }

    /**
     * Tests if the correct is updated correctly when the different inputs are provided.
     */
    @Test
    void testCheckIncorrectAnswer(){
        PhoneNumberTask.checkCorrectness(194823723, 194823724);
        assert(!PhoneNumberTask.correct);
    }
}
