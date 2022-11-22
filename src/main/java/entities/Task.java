package entities;

public abstract class Task {

    protected static boolean completed = false;
    protected static boolean activated = false;

    public static void setCompletionStatus(boolean status) {
        completed = status;
    }

    public static boolean getCompletionStatus() {
        return completed;
    }


    public static void setActivatedStatus(boolean status) {
        activated = status;
    }

    public static boolean getActivatedStatus() {
        return activated;
    }

    public static void reset() {
        setCompletionStatus(false);
    }
}
