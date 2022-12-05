package presenter;

import static usecases.TriviaTask.*;

/**
 * The TriviaTask presenter is responsible for "telling the view what to present to the user"
 * @author talia
 */

public class TriviaTaskPresenter {

    public String tellViewQuestion(){

        return currentQuestion;
    }

    public static String tellViewCorrectness(){
        // if the answer is correct what should the view present to the user?
        // what if the answer is incorrect?
        return "placeholder";
    }
}
