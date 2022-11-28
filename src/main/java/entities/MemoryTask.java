package entities;

public class MemoryTask extends Task{   // memory task backend code
    
   
    // checks the correctness of the password entered by the user.
    // typed password relayed here from view by the controller
    public static boolean checkCorrectness(String actualPassword, String typedPassword){
        if(typedPassword.equals(actualPassword)){
            setCompletionStatus(true);
            return true;
        }
        else{
            return false;
        }

    }

}
