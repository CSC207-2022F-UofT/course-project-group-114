package entities;

public class TriviaTask extends Task {
//    public int triviaCategory; //can later make changes to code to add categories and get questions and answers from a csv file
    public int questionNum; //randomly generated num to select a random question from that category
    public String currentQuestion; // the question
    public String playerAnswer; // what the player actually answered
    public String actualAnswer; // the correct answer


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

    // checks the player's answer to the question
    // if the answer is correct
    // if the answer is incorrect


    public static void reset() { // inherited reset method, generate random question
        // public int questionNum = random number between 0 and last index of dictionary
    }
    public boolean checkAnswer (String actualAnswer, String playerAnswer){
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