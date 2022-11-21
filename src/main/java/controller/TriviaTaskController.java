package controller;
import entities.TriviaTask;

import javax.swing.*;

public class TriviaTaskController {
    TriviaTask usecase = new TriviaTask();

    // public int passCategory (JTextField chosen)
    // if it's ... return respective integer
    public String currentQuestion(){
        return usecase.getRandomQuestion();
    }

    // public boolean passAnswer
    public boolean passAnswer(String actualAnswer, JTextField playerAnswer){
        return usecase.checkAnswer(actualAnswer, String.valueOf(playerAnswer));
    }
}
