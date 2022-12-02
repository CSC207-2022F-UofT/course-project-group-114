package controller;
import usecases.TriviaTask;
import javax.swing.*;

public class TriviaTaskController {
    public static void passAnswertoUsecase(String actualAnswer, JTextField playerAnswer){
        // backend checkAnswer compares the playerAnswer to the actualAnswer to determine
        TriviaTask.checkAnswer(actualAnswer, playerAnswer.getText());
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
