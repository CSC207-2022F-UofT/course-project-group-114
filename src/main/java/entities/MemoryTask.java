package entities;

public class MemoryTask extends Task{   // memory task backend code
    
   
    // checks the correctness of the password entered by the user.
    // typed password relayed here from view by the controller
    public boolean check_correctness(String actual_password, String typed_password){
        if(typed_password.equals(actual_password)){
            setCompletionStatus(true);
            return true;
        }
        else{
            return false;
        }

    }

}
