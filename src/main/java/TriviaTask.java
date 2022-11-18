import java.util.*;

public class TriviaTask extends Task{
    public String currentQuestion;
    public String playerAnswer;
    public String actualAnswer;

     //dictionary mapping questions to answers
    Map<String, String> triviaDictionary = new Map<String, String>() {
         @Override
         public int size() {
             return 0;
         }

         @Override
         public boolean isEmpty() {
             return false;
         }

         @Override
         public boolean containsKey(Object key) {
             return false;
         }

         @Override
         public boolean containsValue(Object value) {
             return false;
         }

         @Override
         public String get(Object key) {
             return null;
         }

         @Override
         public String put(String key, String value) {
             return null;
         }

         @Override
         public String remove(Object key) {
             return null;
         }

         @Override
         public void putAll(Map<? extends String, ? extends String> m) {

         }

         @Override
         public void clear() {

         }

         @Override
         public Set<String> keySet() {
             return null;
         }

         @Override
         public Collection<String> values() {
             return null;
         }

         @Override
         public Set<Entry<String, String>> entrySet() {
             return null;
         }
     }; // change second String to a list of strings
//    triviaQA.put("What is the first letter of the alphabet", "a");
//    triviaQA.put("What is the capital of Canada", "Ottawa");
//    triviaQA.put("What is python", "a type of snake");

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