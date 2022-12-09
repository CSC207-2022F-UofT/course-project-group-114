package use_cases;

/**
 * Class representing the AssignmentTask use case, which is responsible for Assignment mini-game
 *
 * @author uoft-flyfreejay
 */
public class AssignmentTask extends Task {
    private static final int COUNT_UPPERBOUND = 70;
    private static final int COUNT_LOWERBOUND = 50;

    protected static int characterCountNeeded =
            (int) Math.floor(Math.random()*(COUNT_UPPERBOUND - COUNT_LOWERBOUND +1)+ COUNT_LOWERBOUND);
    protected static int currentCharacterCount;

    /**
     * Getter method that returns characterCountNeeded
     *
     * @return character count needed to finish the current Assignment task
     */
    public static int getCharacterCountNeeded(){
        return characterCountNeeded;
    }

    /**
     * Setter method that sets characterCountNeeded as a random number between the lowerbound and upperbound
     *
     */
    public static void setCharacterCountNeeded(){
        // generate random number from lowerbound and upperbound
        characterCountNeeded =
                (int) Math.floor(Math.random()*(COUNT_UPPERBOUND - COUNT_LOWERBOUND +1)+ COUNT_LOWERBOUND);
    }
    /**
     * Setter method that sets currentCharacterCount as a given parameter
     *
     * @param currCharCount an integer value you want to set currentCharacterCount to
     */
    public static void setCurrentCharacterCount(int currCharCount){
        currentCharacterCount = currCharCount;
    }
//    public static void setCompletionStatus(boolean status) {
//        completed = status;
//    }
//    public static boolean getCompletionStatus() {
//        return completed;
//    }
//    public static void setActivatedStatus(boolean status) {
//        activated = status;
//    }
//    public static boolean getActivatedStatus() {
//        return activated;
//    }

    /**
     * a method that checks whether the currentCharacterCount is greater than or equal to characterCountNeeded
     * to see if the mini-game has been completed or not
     *
     */
    public static void checkCount(){
        if (currentCharacterCount >= characterCountNeeded){
            setCompletionStatus("AssignmentTask",true);
            setActivatedStatus("AssignmentTask",false);
        }
    }
    /**
     * a method that resets all the class variables and sets the characterCountNeeded again.
     *
     */
    public static void reset(){
        Task.reset("AssignmentTask");
        setCharacterCountNeeded();
        setCurrentCharacterCount(0);
    }

}