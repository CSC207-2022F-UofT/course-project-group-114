package entities;

public class MemoryTask extends Task{

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
