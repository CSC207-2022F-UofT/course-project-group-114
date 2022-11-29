package entities;

public class PhoneNumberTask extends Task {

    public static boolean checkCorrectness(int actualNumber, int pressedNumber){
        if(actualNumber == pressedNumber){
            setCompletionStatus("PhoneNumberTask", true);
            return true;
        } else {
            return false;
        }
    }
    public static void reset() {
        Task.reset("PhoneNumberTask");
    }
}

