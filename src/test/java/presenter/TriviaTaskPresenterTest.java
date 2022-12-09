package presenter;
import org.junit.jupiter.api.Test;
import usecases.TriviaTask;

/**
 * Class representing tests for the TriviaTask presenter.
 * @author talia
 */

public class TriviaTaskPresenterTest {

    /**
     * Tests if the question string correctly generated according to the random
     * question from the use case class.
     */
//    @Test
//    void testTellQuestion(){
//        String usecaseQ = TriviaTask.getRandomQuestion();
//        String question = TriviaTaskPresenter.tellViewQuestion();
//        assert(question.equals(usecaseQ));
//    }

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
