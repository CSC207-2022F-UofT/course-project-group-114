package usecases;

import org.junit.jupiter.api.Test;

public class PhoneNumberTaskTest {

    @Test
    void testCheckCorrectAnswer(){
        PhoneNumberTask.checkCorrectness(194823723, 194823723);
        assert(PhoneNumberTask.correct);
        assert(PhoneNumberTask.getCompletionStatus("PhoneNumberTask"));
    }

    @Test
    void testCheckIncorrectAnswer(){
        PhoneNumberTask.checkCorrectness(194823723, 194823724);
        assert(!PhoneNumberTask.correct);
    }
}
