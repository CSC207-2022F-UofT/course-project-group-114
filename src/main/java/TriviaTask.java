import java.util.Dictionary;

public class TriviaTask extends Task{
    public String currentQuestion;
    public String playerAnswer;
    // public String actualAnswer;

    public TriviaTask(String playerInput, String actualAnswer){
        this.playerAnswer = playerAnswer; // change that to the answer inputted by the player
        this.actualAnswer = playerInput;
    }

    // step 1: generate a question
    public void getQuestion(){
        // function to get the question
        // generate a random number between zero and length of dictionary minus 1
        // choose that dictionary key aka question
        // get the actual answer, which is mapped to it
    }

    public void checkAnswer(String playerAnswer, String actualAnswer){
        // check the fucking answer
    }

//  public String current_question;
//    public String player_answer;
//    public String actual_answer;
    // the TriviaTask subclass of Task
    // TriviaTask use case of our game!!

    // the TriviaTask class is the backend of the trivia game!
    // it extends Task

    // is called by TriviaTask controller

    // checks the player's answer to the question
    // if the answer is correct
    // if the answer is incorrect

    @Override
    public void reset() {
        // generate a new question and answer

    }
    // public void check_answer(String actualAnswer, String playerAnswer){
    // // if answer is correct
        // trivia task is completed
    // if answer is wrong
        // deduct a "life"
    // }
//    public void check_answer(String actual_answer, String player_answer){
//        // if the answer is correct
//        // add to score
//        // do what you do if someone answers correct in trivia
//
//        // else (aka if answer is incorrect)
//        // subtract the number of points that the question is worth from the player's score
//        // if the player's Trivia score is LESS THAN ZERO
//        // game's over and deduct a life
//        // lifeMaster.deductLife()
//    }
}