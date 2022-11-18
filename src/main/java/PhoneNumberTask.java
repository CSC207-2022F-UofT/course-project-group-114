public class PhoneNumberTask extends Task {
    public int actual_number;
    public int pressed_number;

    public PhoneNumberTask(int actual, int pressed){
        this.actual_number = actual;
        this.pressed_number = pressed;
    }

    public void check_correctness(int actual_number, int pressed_number){
        if(actual_number == pressed_number){
            this.setCompletedStatus(true);
            GameMaster.tasksCompletedCount ++;
            this.setActivationStatus(false);
        } else {
            lifeMaster.deductLife();
            this.setActivationStatus(false);
        }
    }

}
