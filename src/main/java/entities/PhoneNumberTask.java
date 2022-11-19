package entities;

public class PhoneNumberTask extends Task {
    public int actual_number;
    public int pressed_number;

    public boolean check_correctness(int actual_number, int pressed_number){
        if(actual_number == pressed_number){
            setCompletionStatus(true);
            lifeMaster.incrementTaskCount();
            setActivatedStatus(false);
            return true;
        } else {
            lifeMaster.deductLife();
            setActivatedStatus(false);
            return false;
        }
    }
}

