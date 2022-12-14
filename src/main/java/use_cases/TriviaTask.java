package use_cases;

import java.util.*;

/**
 * Use case class for the TriviaTask.
 * invoked when the game master randomly assigns the trivia task.
 * Responsible for choosing a random trivia question and checking the player's answer for correctness.
 * @author talia
 */

public class TriviaTask extends Task {
    public static String currentQuestion; // the question. trivia dict at the randomly generated index
    public static String actualAnswer; // the correct answer corresponding value to the key
    public static boolean isAnswerCorrect;

    // creating the trivia dictionary
    public static Map<String, String> getMap()
    {
        Map<String, String> triviaDict = new HashMap<>();
        triviaDict.put("What kind of animal is a Python?", "snake");
        triviaDict.put("In what country is Java located?", "indonesia");
        triviaDict.put("A poisson is a... ", "FISH");
        triviaDict.put("What is the missing word: S***D Design Principles", "solid");
        triviaDict.put("A violation of clean architecture is called *missing word* architecture", "dIrTy");
        triviaDict.put("The dude who wrote clean architecture is nicknamed ...", "uncle bob");
        triviaDict.put("REALLY BAD clean arc violations are called F***Y arc", "filthy");
        triviaDict.put("what do you call code that totally disregards solid deign?", "liquid");
        triviaDict.put("what is the 11th month of the year?", "november");
        triviaDict.put("what is the capital of canada?", "ottawa");
        return triviaDict;
    }
    
    
    /** Method for choosing a random question.
     * @return the randomly chosen question from the trivia dictionary.
     */
    public static String getRandomQuestion(){
        Map<String, String> triviaDict = getMap();
        Set <String> keySet = triviaDict.keySet();
        List<String> keys = new ArrayList<>(keySet);
        int size = keys.size();
        int randomKeyIndex = new Random().nextInt(size);
        currentQuestion = keys.get(randomKeyIndex);
        actualAnswer = triviaDict.get(currentQuestion);
        return currentQuestion;
    }
    
    /**
     * Reset method, inherited from the task abstract class
     */
    public static void reset() { // inherited reset method, generate random question
    }
    
    /**
     * Method for checking the correctness of the player's answer.
     * @param playerAnswer the string version of the answer inputted by the user
     */

    public static void checkAnswer(String playerAnswer, String actualAnswer){
        // check to see if the answer is correct.
        // checking for the same word, not case-sensitive.
        // if the answer is correct
        if (playerAnswer.equalsIgnoreCase(actualAnswer)){
            // set the completion status to true
            setCompletionStatus("TriviaTask", true);
            // and the answer correctness status to true
            isAnswerCorrect = true;
        }
        else{
            setCompletionStatus("TriviaTask", false);
            isAnswerCorrect = false;
        }
    }
}
