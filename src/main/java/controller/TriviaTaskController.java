package controller;
import usecases.TriviaTask;
import javax.swing.*;

/**
 * The controller for the trivia task.
 * responsible for getting information from the view, translating it into something that the
 * usecase can understand, packaging it, and passing it to the usecase.
 * @author talia
 */
public class TriviaTaskController {

    /**
     * Takes inputs passed by the TriviaTaskView and translates them into an appropriate
     * data type for the usecase.
     * @param playerAnswer the answer which the user has typed
     */
    public static void passAnswer(JTextField playerAnswer){
        // backend checkAnswer compares the playerAnswer to the actualAnswer to determine
        // if it is correct
        TriviaTask.checkAnswer(playerAnswer.getText());
    }

    /**
     * Sets the completed status of the trivia task to the boolean passed
     * @param status boolean value that the completed status TriviaTask needs to be set to.
     */
    public static void setCompletionStatus(boolean status) {
        TriviaTask.setCompletionStatus("TriviaTask", status);
    }

    /**
     * Sets the activated status of the trivia task to the boolean passed.
     * @param status boolean value that the activated status of TriviaTask needs to be set to.
     */
    public static void setActivatedStatus(boolean status) {
        TriviaTask.setActivatedStatus("TriviaTask", status);
    }

    /**
     * gets the activated status of the TriviaTask.
     * @return boolean value of the activated status of the TriviaTask.
     */
    public static boolean getActivatedStatus() {
        return TriviaTask.getActivatedStatus("TriviaTask");
    }

}
