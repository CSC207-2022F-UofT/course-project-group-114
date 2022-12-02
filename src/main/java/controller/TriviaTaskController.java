package controller;
import usecases.TriviaTask;
import javax.swing.*;

public class TriviaTaskController {
//    private String playerAnswer;
//    private String[] actualAnswer;
    TriviaTask triviaTaskUsecase = new TriviaTask();

    // passes the random question thru the controller from backend to view
    public String passRandomQuestion(){
        return triviaTaskUsecase.getRandomQuestion();
    }

    // take the player's answer
    // translate it into something the backend can understand
    // relay it to the backend code and call the backend here
    public boolean answerChecker(String actualAnswer, JTextField playerAnswer){
        // backend checkAnswer compares the playerAnswer to the actualAnswer to determine
        // if it is correct
        return (TriviaTask.checkAnswer(actualAnswer, playerAnswer.getText()));
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
