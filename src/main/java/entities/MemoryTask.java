package entities;

public class MemoryTask extends Task{
    public String actual_password;
    public String typed_password;
    @Override
    public void reset() {

    }
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
