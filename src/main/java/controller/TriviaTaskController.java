package controller;
import entities.TriviaTask;
import javax.swing.*;

public class TriviaTaskController {
//    private String playerAnswer;
//    private String[] actualAnswer;
    TriviaTask TriviaTaskUsecase = new TriviaTask();

    // take the player's answer
    // translate it into something the backend can understand
    // relay it to the backend code and call the backend here
    public boolean answerChecker(String actualAnswer, JTextField playerAnswer){
        // backend checkAnswer compares the playerAnswer to the actualAnswer to determine
        // if it is correct
        return (TriviaTaskUsecase.checkAnswer(actualAnswer, playerAnswer.getText()));
    }

}
