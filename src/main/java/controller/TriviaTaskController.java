package controller;
import usecases.TriviaTask;
import javax.swing.*;

/**
 * The controller for the trivia task.
 * Responsible for taking the user's input from the view, "translating" it into the appropriate datatype for the
 * usecase.
 * Acts as a "passer" between the view and the use case.
 * @author talia
 */

public class TriviaTaskController {
    /**
     * Takes the user inputs passed by TriviaTaskView, and translates/packages then passes
     * it to the usecase.
     *
     * @param playerAnswer the answer inputted by the user
     */

    public static void passAnswer(JTextField playerAnswer){
        TriviaTask.checkAnswer(playerAnswer.getText());
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
