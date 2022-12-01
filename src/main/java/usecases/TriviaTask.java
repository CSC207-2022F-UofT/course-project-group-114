package usecases;

import java.util.*;

public class TriviaTask extends Task {
    // public int triviaCategory; //can later make changes to code to add categories and get questions and answers from a csv file
    // public static int questionNum; //randomly generated num to select a random question from that category
    public String currentQuestion; // the question. trivia dict at the randomly generated index
    public String actualAnswer; // the correct answer corresponding value to the key

    // creating the trivia dictionary

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

//    public static void reset() { // inherited reset method, generate random question
//        // public int questionNum = random number between 0 and last index of dictionary
//    }
    // checks if the answer is correct

    public static boolean checkAnswer (String actualAnswer, String playerAnswer){
        // case for if the actual answer is an integer????? this can be added later.
        if (playerAnswer.toLowerCase().equals(actualAnswer.toLowerCase())){
            setCompletionStatus("TriviaTask", true);
            return true;
        }
        else{
            return false;
        }
    }
}
