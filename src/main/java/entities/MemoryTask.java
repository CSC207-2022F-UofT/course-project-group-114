package entities;

public class MemoryTask extends Task{

    public boolean check_correctness(String actual_password, String typed_password){
        if(actual_password.equals(typed_password)){
            setCompletionStatus(true);
            return true;
        }
        else{
            return false;
        }

    }

}
