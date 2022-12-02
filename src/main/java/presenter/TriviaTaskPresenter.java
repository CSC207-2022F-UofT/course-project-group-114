package presenter;
import usecases.TriviaTask;
import javax.swing.*;

import static usecases.TriviaTask.actualAnswer;
import static usecases.TriviaTask.isAnswerCorrect;

public class TriviaTaskPresenter {
    TriviaTask triviaUsecase;

    public String tellViewQuestion(){
        return TriviaTask.getRandomQuestion();
    }

    public String tellViewCorrectness(){
        // if the answer is correct what should the view present?
        if (isAnswerCorrect){
            return "that is correct";

        }

        // what if the answer is incorrect?
        //return "abc";
        else{
            return "incorrect. the correct answer is " + actualAnswer;
        }
    }
}
