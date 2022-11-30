package usecases;

public class AssignmentTask extends Task {
    private static final int COUNT_UPPERBOUND = 70;
    private static final int COUNT_LOWERBOUND = 50;
    protected static int characterCountNeeded =
            (int) Math.floor(Math.random()*(COUNT_UPPERBOUND - COUNT_LOWERBOUND +1)+ COUNT_LOWERBOUND);
    protected static int currentCharacterCount;

    public static int getCharacterCountNeeded(){
        return characterCountNeeded;
    }


    public static void setCharacterCountNeeded(){
        // generate random number from lowerbound and upperbound
        characterCountNeeded =
                (int) Math.floor(Math.random()*(COUNT_UPPERBOUND - COUNT_LOWERBOUND +1)+ COUNT_LOWERBOUND);
    }

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

    public static void checkCount(){
        if (currentCharacterCount >= characterCountNeeded){
            setCompletionStatus("AssignmentTask",true);
            setActivatedStatus("AssignmentTask",false);
        }
    }

    public static void reset(){
        Task.reset("AssignmentTask");
        setCharacterCountNeeded();
        setCurrentCharacterCount(0);
    }

}