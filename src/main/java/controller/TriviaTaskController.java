package controller;
import usecases.TriviaTask;
import javax.swing.*;

/**
 * The trivia task controller is responsible for taking the player's input,
 * (player's answer to the trivia question), "translating" it into something that the usecase
 * can understand, and "
 *
 * @author talia
 */
public class TriviaTaskController {
    public static boolean passAnswertoUsecase(JTextField playerAnswer){
        // backend checkAnswer compares the playerAnswer to the actualAnswer to determine correctness
        boolean variable = TriviaTask.checkAnswer(playerAnswer.getText());
        return variable;
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
