package presenter;

import controller.TriviaTaskController;
import usecases.TriviaTask;

import static usecases.TriviaTask.*;

/**
 * The TriviaTask presenter is responsible for "telling the view what to present to the user"
 * The presenter gets information from the usecase & uses that information to tell the view what to
 * display/present to the user
 * @author talia
 */

public class TriviaTaskPresenter {

    public String tellViewQuestion(){

        return TriviaTask.getRandomQuestion();
    }

    public static String tellCorrectness(){
        //boolean correct = TriviaTask.checkAnswer();
        //if answer is correct
        //correct = TriviaTask.checkAnswer();
        return "placeholder";

    }
}
