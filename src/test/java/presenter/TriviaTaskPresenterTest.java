package presenter;
import org.junit.jupiter.api.Test;
import usecases.TriviaTask;

/**
 * Class representing tests for the TriviaTask presenter.
 * @author talia
 */

public class TriviaTaskPresenterTest {

    /**
     * Checks that the correctness message is generated correctly and according to whether or not the player's answer
     * was correct.
     */

    @Test
    public void testTellCorrect(){
        TriviaTask.isAnswerCorrect = true;
        String message = TriviaTaskPresenter.tellCorrectness();
        assert(message.equals("that is correct!"));
    }
    @Test
    public void testTellIncorrect(){
        TriviaTask.isAnswerCorrect = false;
        String message = TriviaTaskPresenter.tellCorrectness();
        assert(message.equals("incorrect!"));


    }
}
