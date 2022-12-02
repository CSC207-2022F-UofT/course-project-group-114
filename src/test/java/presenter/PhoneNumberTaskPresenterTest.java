package presenter;

import org.junit.jupiter.api.Test;

import usecases.PhoneNumberTask;
import presenter.PhoneNumberTaskPresenter;

public class PhoneNumberTaskPresenterTest {
    @Test
    void testCorrectAnswer(){
        PhoneNumberTaskPresenter presenter = new PhoneNumberTaskPresenter();
        PhoneNumberTask.checkCorrectness(194823723, 194823723);
        assert(presenter.correctnessStatus().equals("Correct"));
        assert(PhoneNumberTask.getCompletionStatus("PhoneNumberTask"));
    }

    @Test
    void testIncorrectAnswer(){
        PhoneNumberTaskPresenter presenter = new PhoneNumberTaskPresenter();
        PhoneNumberTask.checkCorrectness(194823723, 194823724);
        assert(presenter.correctnessStatus().equals("Incorrect"));
        assert(!PhoneNumberTask.getCompletionStatus("PhoneNumberTask"));
    }
}
