package entities;

public class TriviaTask extends Task {
    public int triviaCategory;
    public String currentQuestion;
    public String playerAnswer;
    public String actualAnswer;


    Hashmap<String, ArrayList<String>> category0 = new HashMap<String, List<String>>();
    category0.put("What is the missing word: S***D Design Principles?"), Arrays.asList("solid");
    category0.put("Who wrote clean architecture?"), Arrays.asList("uncle bob", "real name");



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
    public void reset() { // TriviaTask inherited reset method from its parent class.
        // choose the question aka current_question
        // get the actual_answer of the corresponding question
    }
    public boolean checkAnswer (String actualAnswer, String playerAnswer){
        if (playerAnswer.equals(actualAnswer)){
            setCompletionStatus(true);
            return true;
        }
        return false;
    }
}