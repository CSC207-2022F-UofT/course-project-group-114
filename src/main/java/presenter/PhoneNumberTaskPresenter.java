package presenter;

import controller.PhoneNumberTaskController;
import usecases.PhoneNumberTask;

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
            PhoneNumberTaskController.setCompletionStatus(true);
            return("Correct");
        }
        else {
            PhoneNumberTaskController.setCompletionStatus(false);
            return("Incorrect");
        }
    }


}
