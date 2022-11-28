package entities;

public class PhoneNumberTask extends Task {

    public static boolean checkCorrectness(int actualNumber, int pressedNumber){
        if(actualNumber == pressedNumber){
            setCompletionStatus(true);
            return true;
        } else {
            return false;
        }
    }
}

