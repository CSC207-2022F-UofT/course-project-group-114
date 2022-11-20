package entities;

import entities.Task;

public class TriviaTask extends Task {
//    public String current_question;
//    public String player_answer;
//    public String actual_answer;
    // the entities.TriviaTask subclass of entities.Task
    // entities.TriviaTask use case of our game!!

    // the entities.TriviaTask class is the backend of the trivia game!
    // it extends entities.Task

    // is called by entities.TriviaTask controller

    // checks the player's answer to the question
    // if the answer is correct
    // if the answer is incorrect

    @Override
    public void reset() {

    }
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