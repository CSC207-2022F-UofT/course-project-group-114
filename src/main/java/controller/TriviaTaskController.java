package controller;
import entities.TriviaTask;

import javax.swing.*;

public class TriviaTaskController {
    private String playerAnswer;
    private String[] actualAnswer;
    TriviaTask TriviaTaskUsecase = new TriviaTask();

    public boolean answerChecker(String actualAnswer, JTextField playerAnswer){
        return (TriviaTaskUsecase.checkAnswer(actualAnswer, playerAnswer.getText()));
    }

}
