package use_cases;
import org.junit.jupiter.api.Test;

/**
 * Class representing test cases for the TriviaTask
 */

public class TriviaTaskTest {

    /**
     * Checks that isAnswerCorrect is updated correctly when the player's inputted answer matches the actual answer.
     */

    @Test
    void testCorrectPlayerAnswer(){
        TriviaTask.checkAnswer("snake", "snake");
        assert(TriviaTask.isAnswerCorrect);
        assert(TriviaTask.getCompletionStatus("TriviaTask"));
    }

    /**
     * Checks that the checkAnswer method in the use case is NOT case-sensitive.
     */
    @Test
    void testCorrectPlayerAnswerIgnoreCase(){
        String playerAnswer = "inDoNeSIa";
        String actualAnswer = "indonesia";
        TriviaTask.checkAnswer(playerAnswer, actualAnswer);
        assert(TriviaTask.isAnswerCorrect);
        assert(TriviaTask.getCompletionStatus("TriviaTask"));
    }

    /**
     * Checks that isAnswerCorrect when the player's inputted answer does NOT match the actual answer.
     */
    @Test
    void testIncorrectPlayerAnswer(){
        String playerAnswer = "cat";
        String actualAnswer = "snake";
        TriviaTask.checkAnswer(playerAnswer, actualAnswer);
        assert(!TriviaTask.isAnswerCorrect);
        assert(!TriviaTask.getCompletionStatus("TriviaTask"));
    }

}
