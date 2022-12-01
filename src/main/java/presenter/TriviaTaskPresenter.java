package presenter;
import controller.TriviaTaskController;
import usecases.TriviaTask;

public class TriviaTaskPresenter {
    // another thing for dependency inversion rule & clean architecture
    // tells the view what it needs to prevent to the user
    // basically relaying what needs to be presented between usecase & view
    //while adhering to clean architecture layers inverted dependency rule
    // never want the controller or backend or presenter to call the view


    // tell the view to display the question
    public String tellViewWhatQuestionToShow(){
        return TriviaTaskController.passRandomQuestion();
    }

    // tell the view to display whether the player's answer is correct or incorrect
    // going to need to make small changes in backend and controller to make this one work
    public String tellViewIfAnswerIsCorrect(){
        //boolean correct = TriviaTask.checkAnswer();
        return "string x";

    }
}
