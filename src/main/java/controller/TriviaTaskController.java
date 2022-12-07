package controller;
import usecases.TriviaTask;
import javax.swing.*;

public class TriviaTaskController {

    TriviaTask TriviaTaskUsecase = new TriviaTask();

    // take the player's answer
    // translate it into something the backend can understand
    // relay it to the backend code and call the backend here
    public static void passAnswer(JTextField playerAnswer){
        // backend checkAnswer compares the playerAnswer to the actualAnswer to determine
        // if it is correct
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
