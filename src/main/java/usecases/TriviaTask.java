package entities;

import java.sql.Array;
import java.util.*;



public class TriviaTask extends Task {
    // this is where it'll be changed to a csv
    // figure this out asap
    // public int triviaCategory; //can later make changes to code to add categories and get questions and answers from a csv file
    public String currentQuestion; // the question. generated from trivia dict at the randomly generated index
    public String actualAnswer; // the correct answer corresponding value to the key in triviaDict
    // creating the trivia dictionary
    // want to change this to a csv to improve project
    public Map<String, String> getMap()
    {
       Map<String, String> triviaDict = new HashMap<>();
            triviaDict.put("What kind of animal is a Python?", "snake");
            triviaDict.put("In what country is Java located?", "Indonesia");
            triviaDict.put("What does 'poissson' mean in english?", "fish");
            triviaDict.put("What is the missing word: S***D Design Principles", "solid");
            triviaDict.put("The dude who wrote clean architecture is nicknamed ...", "uncle bob");
            triviaDict.put("In what room are the csc207 lectures?", "br200");
            return triviaDict;
    }
    public String getRandomQuestion(){
        Map<String, String> triviaDict = this.getMap();
        Set <String> keySet = triviaDict.keySet();
        List<String> keys = new ArrayList<>(keySet);
        int size = keys.size();
        int randomKeyIndex = new Random().nextInt(size);
        this.currentQuestion = keys.get(randomKeyIndex);
        this.actualAnswer = triviaDict.get(currentQuestion);
        return currentQuestion;
    }
    public String getActualAnswer(){
        return actualAnswer;
    }

    // is called by entities.TriviaTask controller

//    public static void reset() {
//        this.getRandomQuestion();
//    }

//    // checks if the answer is correct

    public static boolean checkAnswer (String actualAnswer, String playerAnswer){
        // case for if the actual answer is an integer????? this can be added later.
        if (playerAnswer.toLowerCase().equals(actualAnswer.toLowerCase())){
            setCompletionStatus(true);
            return true;
        }
        else{
            return false;
        }
        // if i want to change it to categories and more than one correct answer or to accept variations of the same answer will
        // need to check that playerAnswer is in the list of possible answers
    }
}
