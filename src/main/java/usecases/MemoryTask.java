package usecases;

/**
 * MemoryTask is a subclass of the abstract class Task and represents the MemoryTask game.
 *
 * @author Kaavya Kalani, Talia Fabregas
 * @inheritDoc Task
 */
public class MemoryTask extends Task{

    public static boolean correct;
    /**
     * Checks if given actualPassword and typedPassword are the same and makes changes
     * accordingly.
     *
     * @param actualPassword the String which was generated and expected to be typed.
     * @param typedPassword the String which was actually typed by the user.
     */
    public static void checkCorrectness(String actualPassword, String typedPassword){
        if(typedPassword.equals(actualPassword)){
            setCompletionStatus("MemoryTask", true);
            correct = true;
        }
        else{
            correct = false;
        }

    }
    /**
     * Resets the task everytime the PhoneNumberTask is called
     */
    public static void reset() {
        Task.reset("MemoryTask");
    }

}
