package usecases;

/**
 * PhoneNumberTask is a subclass of the abstract class Task and represents the PhoneNumberTask game.
 *
 * @author Kaavya Kalani
 * @inheritDoc Task
 */
public class PhoneNumberTask extends Task {

    public static boolean correct;

    /**
     * Checks if given actualNumber and pressedNumber are the same and makes
     * changes accordingly.
     *
     * @param actualNumber the int which was generated and expected to be typed.
     * @param pressedNumber the int which was actually pressed by the user.
     */
    public static void checkCorrectness(int actualNumber, int pressedNumber){
        if(actualNumber == pressedNumber){
            setCompletionStatus("PhoneNumberTask", true);
            correct = true;
        } else {
            correct = false;
        }
    }

    /**
     * Resets the task everytime the PhoneNumberTask is called
     */
    public static void reset() {
        Task.reset("PhoneNumberTask");
    }
}

