package controller;
import entities.TriviaTask;

import javax.swing.*;

public class TriviaTaskController {
    TriviaTask usecase = new TriviaTask();

    // public int passCategory (JTextField chosen)
    // if it's ... return respective integer
    public String passRandomQuestion(){
        return usecase.getRandomQuestion();
    }
    public String passActualAnswer(){return usecase.getActualAnswer();}

    // public boolean passAnswer
    public boolean passAnswer(String actualAnswer, JTextField playerAnswer){
        // sends the actualAnswer & playerAnswer into the backend
        // "translates" playerAnswer into a String which the backend can then understand
        // & compare to the actualAnswer to check for correctness
        return TriviaTask.checkAnswer(actualAnswer, String.valueOf(playerAnswer));
    }
}
