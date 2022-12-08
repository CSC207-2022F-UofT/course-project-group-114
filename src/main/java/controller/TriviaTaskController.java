package controller;
import usecases.TriviaTask;
import javax.swing.*;

import static usecases.TriviaTask.actualAnswer;

/**
 * The controller for the trivia task.
 * responsible for getting information from the view, translating it into something that the
 * usecase can understand, packaging it, and passing it to the usecase.
 * @author talia
 */
public class TriviaTaskController {
    /**
     * the controller for the trivia task is called by the view. it takes the player's answer (user input),
     * "translates" it into a string, and calls the usecase to check that string for correctness.
     */


    // take the player's answer
    // translate it into something the backend can understand
    // relay it to the backend code and call the backend here
    public static void passAnswer(JTextField playerAnswer){
        // backend checkAnswer compares the playerAnswer to the actualAnswer to determine
        // if it is correct
        TriviaTask.checkAnswer(playerAnswer.getText(), actualAnswer);
    }
    public static void setCompletionStatus(boolean status) {
        TriviaTask.setCompletionStatus("TriviaTask", status);
    }
    public static void setActivatedStatus(boolean status) {
        TriviaTask.setActivatedStatus("TriviaTask", status);
    }
    public static boolean getActivatedStatus() {
        return TriviaTask.getActivatedStatus("TriviaTask");
    }

}
