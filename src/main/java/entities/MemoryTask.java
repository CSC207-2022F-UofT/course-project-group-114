package entities;

/**
 * MemoryTask is a subclass of the abstact class Task and represents the MemoryTask game.
 *
 * @author Kaavya Kalani, Talia Fabregas
 * @inheritDoc Task
 */
public class MemoryTask extends Task{

    /**
     * Checks if given actualPassword and typedPassword are the same
     *
     * @param actualPassword the String which was generated and expected to be typed.
     * @param typedPassword the String which was actually typed by the user.
     * @return true if given actualPassword and typedPassword are the same and false otherwise.
     */
    public static boolean checkCorrectness(String actualPassword, String typedPassword){
        if(typedPassword.equals(actualPassword)){
            setCompletionStatus("MemoryTask",true);
            return true;
        }
        else{
            return false;
        }

    }
    public static void reset() {
        Task.reset("MemoryTask");
    }

}
