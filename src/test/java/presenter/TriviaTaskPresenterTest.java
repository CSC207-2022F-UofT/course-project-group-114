package presenter;
import org.junit.jupiter.api.Test;
import use_cases.TriviaTask;

/**
 * Class representing tests for the TriviaTask presenter.
 * @author talia
 */

public class TriviaTaskPresenterTest {

    /**
     * Checks that the incorrect message is correctly generated when the player's answer was incorrect.
     */
    @Test
    public void testTellIncorrect(){
        TriviaTask.isAnswerCorrect = false;
        String message = TriviaTaskPresenter.tellCorrectness();
        assert(message.equals("incorrect!"));


    }
}
