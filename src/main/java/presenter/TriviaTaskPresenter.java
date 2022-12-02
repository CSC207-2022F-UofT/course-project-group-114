package presenter;

import static controller.TriviaTaskController.triviataskusecase;

/**
 * The presenter task for the TriviaTask
 * explain what it does here in a couple of sentences ...
 * The presenter is responsible for telling the view what to show the user
 * @author talia
 */

public class TriviaTaskPresenter {
    // another thing for dependency inversion rule & clean architecture
    // tells the view what it needs to prevent to the user
    // basically relaying what needs to be presented between usecase & view
    //while adhering to clean architecture layers inverted dependency rule
    // never want the controller or backend or presenter to call the view
    // tell the view to display the question
    public static String tellViewWhatQuestionToShow(){

        //return TriviaTaskController.passRandomQuestion();
        //incorrect or at least not the best way to do this ... try not to call something in the same "layer". just go to the usecase
        return triviataskusecase.getRandomQuestion();
        // fixed??? now just calls an inner layer once
    }

    // tell the view to display whether the player's answer is correct or incorrect
    // going to need to make small changes in backend and controller to make this one work
    public String tellViewIfAnswerIsCorrect(){
        //boolean correct = TriviaTask.checkAnswer();
        // check the answer

        // if it's correct

        // if it's incorrect
        // this line is just a placeholder
        return "string x";

    }
}
