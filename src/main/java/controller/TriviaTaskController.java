package controller;
import entities.ClickTask;
import entities.TriviaTask;
import javax.swing.*;

public class TriviaTaskController {
//    private String playerAnswer;
//    private String[] actualAnswer;
    TriviaTask TriviaTaskUsecase = new TriviaTask();

    public boolean answerChecker(String actualAnswer, JTextField playerAnswer){
        return (TriviaTaskUsecase.checkAnswer(actualAnswer, playerAnswer.getText()));
    }
    public static void setCompletionStatus(boolean status) {
        TriviaTask.setCompletionStatus(status);
    }
    public static void setActivatedStatus(boolean status) {
        TriviaTask.setActivatedStatus(status);
    }

}
