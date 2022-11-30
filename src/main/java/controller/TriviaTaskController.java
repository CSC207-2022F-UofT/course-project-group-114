package controller;
import usecases.TriviaTask;
import javax.swing.*;

public class TriviaTaskController {
//    private String playerAnswer;
//    private String[] actualAnswer;
    TriviaTask TriviaTaskUsecase = new TriviaTask();

    // passes the random question thru the controller from backend to view
    public String passRandomQuestion(){
        return TriviaTaskUsecase.getRandomQuestion();
    }
    public String passActualAnswer(){
        return TriviaTaskUsecase.getActualAnswer();
    }

// public boolean passAnswer
    public boolean passAnswer(String actualAnswer, JTextField playerAnswer){
        // backend checkAnswer compares the playerAnswer to the actualAnswer to determine
        // if it is correct
        return (TriviaTaskUsecase.checkAnswer(actualAnswer, playerAnswer.getText()));
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
