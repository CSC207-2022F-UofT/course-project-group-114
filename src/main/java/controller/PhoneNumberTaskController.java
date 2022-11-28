package controller;

import entities.PhoneNumberTask;
public class PhoneNumberTaskController {

    public boolean passer(int actualNumber, String pressedNumber){
        if(pressedNumber.length() > 9){
            int input_number = Integer.parseInt(pressedNumber.substring(0,9));
            return (PhoneNumberTask.checkCorrectness(actualNumber, input_number));
        }
        else{
            return(PhoneNumberTask.checkCorrectness(actualNumber, Integer.parseInt(pressedNumber)));
        }
    }
    public static void setCompletionStatus(boolean status) {
        PhoneNumberTask.setCompletionStatus(status);
    }
    public static void setActivatedStatus(boolean status) {
        PhoneNumberTask.setActivatedStatus(status);
    }
}
