package presenter;

import controller.PhoneNumberTaskController;
import usecases.PhoneNumberTask;

public class PhoneNumberTaskPresenter {

    public boolean status;

    public String SuccessfullnessStatus(){
        status = PhoneNumberTask.correct;
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
