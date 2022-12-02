package presenter;
import usecases.TriviaTask;
import javax.swing.*;

import static usecases.TriviaTask.*;

public class TriviaTaskPresenter {

    public String tellViewQuestion(){

        return currentQuestion;
    }

    public String tellViewCorrectness(){
        // if the answer is correct what should the view present?
        if (isAnswerCorrect){
            return "that is correct!";

        }

        else{
            return "that is incorrect. the correct answer is " + actualAnswer;
        }
    }
}
