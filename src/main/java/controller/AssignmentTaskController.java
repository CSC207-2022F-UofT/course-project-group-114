package controller;
import entities.AssignmentTask;

public class AssignmentTaskController {
    public static int getCharacterCountNeeded(){
        return AssignmentTask.getCharacterCountNeeded();
    }

    public static boolean validate(int currentCharacterCount){
        AssignmentTask.setCurrentCharacterCount(currentCharacterCount);
        AssignmentTask.checkCount();
        return AssignmentTask.getCompletionStatus();
    }
}
