package presenter;

import controller.TriviaTaskController;
import usecases.TriviaTask;

import static usecases.TriviaTask.*;

/**
 * The presenter for the trivia task
 * it is responsible for "telling the view what to present to the user"
 * @author talia
 */

public class TriviaTaskPresenter {
    /**
     * The presenter gets information from the usecase (calls the usecase) & uses that information to tell the view what to
     *  display/present to the user (is called by the view)
     * The presenter has been added since milestone 4 to better adhere to single responsibility principle & dependency
     * inversion.
     * @author talia
     */

    /**
     * Calls the usecase to get the random question and decides what update needs
     * to be made to the view.
     * @return String form of the random question that needs to be "presented" to the user.
     */
    public static String tellViewQuestion(){

        return TriviaTask.getRandomQuestion();
    }

    /**
     * Finds out if the player answered the question correctly from the usecase, and decides what
     * message the view needs to "present" to the user.
     * @return String form of the message that needs to be displayed to the user to tell them if they answered
     * the question correctly or not.
     */

    public static String tellCorrectness(){
        String correctnessMessage;
        //if answer is correct
        if (isAnswerCorrect){
            // tell the view to present the word correct to the user
            correctnessMessage = "correct";
            return correctnessMessage;
        }
        else{
            // if not tell the view to present incorrect & what the correct answer would have
            // been to the user
            correctnessMessage = "incorrect. correct answer is: " + actualAnswer;
            return correctnessMessage;
        }

    }
}
