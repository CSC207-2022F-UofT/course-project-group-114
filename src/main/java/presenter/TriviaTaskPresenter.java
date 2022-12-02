package presenter;

import usecases.TriviaTask;
import javax.swing.*;


// shouldn't really be calling the controller here because it's in the same clean arc layer ... doing that wouldn't violate clean arc
// it would just add a little dirt ... a little dirt isnt the WORST but the cleaner the better!!
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
    public String tellViewWhatQuestionToShow(){
        return TriviaTask.getRandomQuestion();
    }


    // tell the view to display whether the player's answer is correct or incorrect
    // going to need to make small changes in backend and controller to make this one work

    // might be redundant
//    public String tellViewActualAnswer(){
//        return TriviaTask.getActualAnswer();
//    }

    public String tellViewIfAnswerIsCorrect(String actualAnswer, JTextField playerAnswer){
        //boolean correct = TriviaTask.checkAnswer();
        // check the answer
        // have the usecase check if the answer is correct
        //boolean correct = triviataskusecase.checkAnswer(String actualAnswer, JTextField playerAnswer);
        //boolean isAnswerCorrect = TriviaTask.checkAnswer(actualAnswer, playerAnswer.getText());

        // if it's incorrect
        if(isAnswerCorrect){
            // set completed status to true ... or should controller still do that???
            return "correct!";
        }
        else{
            return "incorrect! the correct answer is: " + actualAnswer;
        }
        // tell the user that it's incorrect
        // tell them the actual answer
        // this line is just a placeholder


    }
}
