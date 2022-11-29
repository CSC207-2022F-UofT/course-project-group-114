package controller;
import entities.AssignmentTask;
import entities.PhoneNumberTask;

public class AssignmentTaskController {
    public static int getCharacterCountNeeded(){
        return AssignmentTask.getCharacterCountNeeded();
    }

    public static boolean validate(int currentCharacterCount){
        AssignmentTask.setCurrentCharacterCount(currentCharacterCount);
        AssignmentTask.checkCount();
        return AssignmentTask.getCompletionStatus("AssignmentTask");
    }

    public static void setCompletionStatus(boolean status) {
        AssignmentTask.setCompletionStatus("AssignmentTask", status);
    }
    public static void setActivatedStatus(boolean status) {
        AssignmentTask.setActivatedStatus("AssignmentTask", status);
    }
}
