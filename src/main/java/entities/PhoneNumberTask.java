package entities;

/**
 * PhoneNumberTask is a subclass of the abstact class Task and represents the PhoneNumberTask game.
 *
 * @author Kaavya Kalani
 * @inheritDoc Task
 */
public class PhoneNumberTask extends Task {

    /**
     * Checks if given actualNumber and pressedNumber are the same
     *
     * @param actualNumber the int which was generated and expected to be typed.
     * @param pressedNumber the int which was actually pressed by the user.
     * @return true if given actualNumber and pressedPassword are the same and false otherwise.
     */
    public static boolean checkCorrectness(int actualNumber, int pressedNumber){
        if(actualNumber == pressedNumber){
            setCompletionStatus("PhoneNumberTask", true);
            return true;
        } else {
            return false;
        }
    }
    public static void reset() {
        Task.reset("PhoneNumberTask");
    }
}

