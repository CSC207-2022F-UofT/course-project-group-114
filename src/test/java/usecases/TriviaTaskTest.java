package usecases;
import org.junit.jupiter.api.Test;
import usecases.TriviaTask;

/**
 * Class representing test cases for the TriviaTask
 */

public class TriviaTaskTest {

    @Test
    void testCorrectPlayerAnswer(){
        String playerAnswer = "abcdefg";
        String actualAnswer = "abcdefg";
        TriviaTask.checkAnswer(playerAnswer, actualAnswer);
        assert(TriviaTask.isAnswerCorrect);
        assert(TriviaTask.getCompletionStatus("TriviaTask"));
    }

    @Test
    void testCorrectPlayerAnswerIgnoreCase(){
        String playerAnswer = "inDoNeSIa";
        String actualAnswer = "indonesia";
        TriviaTask.checkAnswer(playerAnswer, actualAnswer);
        assert(TriviaTask.isAnswerCorrect);
        assert(TriviaTask.getCompletionStatus("TriviaTask"));
    }

    @Test
    void testIncorrectPlayerAnswer(){
        String playerAnswer = "cat";
        String actualAnswer = "snake";
        TriviaTask.checkAnswer(playerAnswer, actualAnswer);
        assert(!TriviaTask.isAnswerCorrect);
        assert(!TriviaTask.getCompletionStatus("TriviaTask"));
    }

}
