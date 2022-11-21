package controller;
import entities.TriviaTask;

public class TriviaTaskController {
    TriviaTask TriviaTaskUsecase = new TriviaTask();

    // public int passCategory (JTextField chosen)
    // if it's ... return respective integer
    // can add this in later, not a priority
    public String passRandomQuestion(){
        return TriviaTaskUsecase.getRandomQuestion();
    }

    // public boolean to check the answer
    // backend checkAnswer compares the player's answer to the actual answer to determine if it's correct
    public boolean passAnswer(String actualAnswer, JTextField playerAnswer){
        return (TriviaTaskUsecase.checkAnswer(actualAnswer, playerAnswer);
                }
}
