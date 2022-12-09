package presenter;

import use_cases.PhoneNumberTask;

/**
 * The Presenter class for PhoneNumberTask which gets information from the
 * use case and decides what needs to be changed/shown on the view
 *
 * @author Kaavya Kalani
 */
public class PhoneNumberTaskPresenter {
    /**
     * Gets the status from the use case and decided what update needs
     * to be made to the view.
     * It also sets the completionStatus accordingly
     * @return String form of the message that needs to be displayed in the view
     */
    public String correctnessStatus(){
        boolean status = PhoneNumberTask.correct;
        if(status){
            setCompletionStatus(true);
            return("Correct");
        }
        else {
            setCompletionStatus(false);
            return("Incorrect");
        }
    }

    /**
     * sets the CompletionStatus of the PhoneNumberTask to the boolean passed
     * @param status boolean value the CompletionStatus of the PhoneNumberTask needs to be set to
     */
    public static void setCompletionStatus(boolean status) {
        PhoneNumberTask.setCompletionStatus("PhoneNumberTask", status);
    }

}
