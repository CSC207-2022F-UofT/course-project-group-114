package controller;

import usecases.PhoneNumberTask;

/**
 * The controller for the Phone Number Task which is responsible to take inputs from the view and
 * convert them to appropriate datatypes for the use case; thus acting like a passer between them.
 *
 * @author Kaavya Kalani
 */
public class PhoneNumberTaskController {

    /**
     * Takes inputs passed by PhoneNumberTaskView and converts them to appropriate
     * datatypes for the use case and passes it to them.
     *
     * @param actualNumber the int which was generated and expected to be pressed.
     * @param pressedNumber the String where was actually pressed by the user.
     * @return the boolean value returned by the checkCorrectness method in PhoneNumberTask
     */
    public boolean passer(int actualNumber, String pressedNumber){
        if(pressedNumber.length() > 9){
            int input_number = Integer.parseInt(pressedNumber.substring(0,9));
            return (PhoneNumberTask.checkCorrectness(actualNumber, input_number));
        }
        else{
            return(PhoneNumberTask.checkCorrectness(actualNumber, Integer.parseInt(pressedNumber)));
        }
    }

    /**
     * sets the CompletionStatus of the PhoneNumberTask to the boolean passed
     * @param status boolean value the CompletionStatus of the PhoneNumberTask needs to be set to
     */
    public static void setCompletionStatus(boolean status) {
        PhoneNumberTask.setCompletionStatus("PhoneNumberTask", status);
    }

    /**
     * sets the ActivatedStatus of the PhoneNumberTask to the boolean passed
     * @param status boolean value the ActivatedStatus of the PhoneNumberTask needs to be set to
     */
    public static void setActivatedStatus(boolean status) {
        PhoneNumberTask.setActivatedStatus("PhoneNumberTask", status);
    }
    public static boolean getActivatedStatus() {
        return PhoneNumberTask.getActivatedStatus("PhoneNumberTask");
    }
}
