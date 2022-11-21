package controller;
import entities.PhoneNumberTask;
public class PhoneNumberTaskController {

    public boolean passer(int actual_number, String pressed_number){
        if(pressed_number.length() > 9){
            int input_number = Integer.parseInt(pressed_number.substring(0,9));
            return (PhoneNumberTask.check_correctness(actual_number, input_number));
        }
        else{
            return(PhoneNumberTask.check_correctness(actual_number, Integer.parseInt(pressed_number)));
        }
    }
}
