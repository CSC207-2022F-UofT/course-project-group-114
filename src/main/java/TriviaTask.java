package entities;

import java.sql.Array;
import java.util.*;

public class TriviaTask extends Task {
    // public int triviaCategory; //can later make changes to code to add categories and get questions and answers from a csv file
    // public static int questionNum; //randomly generated num to select a random question from that category
    public String currentQuestion; // the question. trivia dict at the randomly generated index
    public String playerAnswer; // what the player actually answered
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
    // method to choose a random key from the dictionary
    // has some errors in terms of choosing the right key and value
    // ask ta for some assistance fixing this
    public String getRandomQuestion(){
        Map<String, String> triviaDict = this.getMap();
        Random R = new Random();
        this.currentQuestion = triviaDict.get(R.nextInt(triviaDict.size()));
        this.actualAnswer = triviaDict.get(currentQuestion);
        return currentQuestion;
        //return triviaDict.get(R.nextInt(triviaDict.size()));
    }

//    public String getRandomQuestion(){
//        Map<String, String> triviaDict = this.getMap();
////        Random randomKey = new Random();
//        String randomQuestion = triviaDict.get(this.getRandomKey());
////        int randomKeyNum = ((int) Math.floor(Math.random()*(triviaDict.size()+1)+0));

//    int questionNum = (int) Math.random();
//    public static void getcurrentQuestion(){
//
//    }
//        public int getSize(){
//            return triviaDict.size();
//        }
//        public static void getRandomQuestion(){
//            List<Integer> KeysAsArray = new ArrayList(questionAnswer.keySet());
//        }
//        public int getRandomQ() {
//            return (int) Math.floor(Math.random() * (triviaDict.size() + 1) + 0);
//        }
//        public String getRandomQuestion(){
//            Random generator = new Random();
//            Integer[] keys = questionAnswer.keys().toArray();
//            String currentQuestion = keys[generator.nextInt(questionAnswer.size())];
//            return currentQuestion;
//        }

//        public String getQuestion(){
//            int questionNum = getRandomQ();
//            Object[] keys =  questionAnswer.keys().toArray();
////            this.currentQuestion = triviaDict.get(keysAsArray.get(questionNum));
//            return currentQuestion;
//            }

//        private static Object[] keys() {
//            return keys;
//        }
////            int questionNum = (int) Math.floor(Math.random()*(triviaDict.size()+1)+0);
//            this.currentQuestion = triviaDict.get(keysAsArray.get(questionNum));
//            return currentQuestion;

//    public String getCurrentQuestion(){
//        this.currentQuestion = triviaDict.get(keysAsArray.get(questionAnswer.getRandomQ()));
//    }


    // can be used to add categories of questions next week.
//    List<Map<Key, Value>> dictList = new ArrayList<Map<Key, Value>>();
//    HashMap<String, String> category0 = new HashMap<String, String>();
//    category0.put("What are the first three letters of the alphabet?", "abc");
//    category0.put("What kind of animal is a Python?", "snake");
//    category0.put("In what country is Java located?", "Indonesia");
//    category0.put("What does 'poissson' mean in english?", "fish");
//    Map<String, String> category1 = new HashMap<String, String>();
//    category1.put("What is the missing word: S***D Design Principles", "solid");
//    category1.put("The dude who wrote clean architecture is nicknamed ...", "uncle bob");
//    category1.put("In what room are the csc207 lectures?", "br200");
//    category1.put("What do you call code where the use case depends on the user interface?", "dirty architecture");
//    Map<String, String> category2 = new HashMap<String, String>();
//    category2.put("Canada is divided into how many electoral districts aka ridings?", "308");
//    category2.put("How many electoral votes are needed to becoome President of the United States?", "270");
//    category2.put("How many seats are there in the United States Senate?", "100");
//    category2.put("How many 4-year terms can a US president serve, at most?", "2");
//    category3.put("Who is the Prime Minister of Canada (first and last name)", "Justin Trudeau");
//    Map<String, String> category3 = new HashMap<String, String>();
//    category3.put("What song do the following lyrics come from: it's me, hi, i'm the problem it's me", "antihero");
//    category3.put("Mean girls day is *insert month name* 3rd. What is the month?", "October");
//    category3.put("Who played Cady herron in the original mean girls", "Lindsey Lohan");

// commented out but might be usable if i want to change it to accept more than one correct answer
//    Hashmap<String, ArrayList<String>> category0 = new HashMap<String, List<String>>();
//    category0.put("What is the missing word: S***D Design Principles?"), Arrays.asList("solid");
//    category0.put("Who wrote clean architecture?"), Arrays.asList("uncle bob", "real name");

//    public String current_question;
//    public String player_answer;
//    public String actual_answer;
    // the entities.TriviaTask subclass of entities.Task
    // entities.TriviaTask use case of our game!!

    // the entities.TriviaTask class is the backend of the trivia game!
    // it extends entities.Task

    // is called by entities.TriviaTask controller

    public static void reset() { // inherited reset method, generate random question
        // public int questionNum = random number between 0 and last index of dictionary
    }
    // checks if the answer is correct

    public boolean checkAnswer (String actualAnswer, String playerAnswer){
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
