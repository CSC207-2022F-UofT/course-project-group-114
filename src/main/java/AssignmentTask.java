//public class AssignmentTask extends Task{
//    private static final int COUNT_UPPERBOUND = 50;
//    private static final int COUNT_LOWERBOUND = 30;
//    protected static int characterCountNeeded =
//            (int) Math.floor(Math.random()*(COUNT_UPPERBOUND - COUNT_LOWERBOUND +1)+ COUNT_LOWERBOUND);
//    protected static int currentCharacterCount;
//
//
//    public static void setCharacterCountNeeded(){
//        // generate random number from lowerbound and upperbound
//        characterCountNeeded =
//                (int) Math.floor(Math.random()*(COUNT_UPPERBOUND - COUNT_LOWERBOUND +1)+ COUNT_LOWERBOUND);
//    }
//
//    public static void setCurrentCharacterCount(int currCharCount){
//        currentCharacterCount = currCharCount;
//    }
//
//    public static void checkCount(){
//        if (currentCharacterCount >= characterCountNeeded){
//            setCompletionStatus(true);
//            setActivatedStatus(false);
//        }
//    }
//
//    public static void reset(){
//        Task.reset();
//        setCharacterCountNeeded();
//        setCurrentCharacterCount(0);
//    }
//
//}