package presenter;

import controller.TriviaTaskController;
import usecases.TriviaTask;

import static usecases.TriviaTask.*;

/**
 * The TriviaTask presenter is responsible for "telling the view what to present to the user"
 * The presenter gets information from the usecase & uses that information to tell the view what to
 * display/present to the user
 *
 * @author talia
 */

public class TriviaTaskPresenter {

    public static String tellViewQuestion(){

        return TriviaTask.getRandomQuestion();
    }

    public static String tellCorrectness(){
        //if answer is correct
        if (isAnswerCorrect){
            // tell the view to present the word correct to the user
            return "correct";
        }
        else{
            // if not tell the view to present incorrect & what the correct answer would have
            // been to the user
            return "incorrect. correct answer is: " + actualAnswer;
        }

    }
}
