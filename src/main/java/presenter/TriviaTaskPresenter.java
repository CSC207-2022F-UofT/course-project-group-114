package presenter;
import usecases.TriviaTask;
import javax.swing.*;

import static usecases.TriviaTask.*;

/**
 * The TriviaTask presenter is responsible for "telling the view what to present to the user"
 * @author talia
 */

public class TriviaTaskPresenter {

    public String tellViewQuestion(){

        return currentQuestion;
    }

    public String tellViewCorrectness(String actualAnswer, JTextField playerAnswer){
        // if the answer is correct what should the view present to the user?
        if (isAnswerCorrect){
            return "that is correct!";
        }

        // what if the answer is incorrect?
        else{
            return "that is incorrect. the correct answer is " + actualAnswer;
        }
    }
}
