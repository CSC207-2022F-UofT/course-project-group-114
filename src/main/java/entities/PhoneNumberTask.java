package entities;

public class PhoneNumberTask extends Task {

    public static boolean checkCorrectness(int actual_number, int pressed_number){
        if(actual_number == pressed_number){
            setCompletionStatus(true);
            return true;
        } else {
            return false;
        }
    }
}

