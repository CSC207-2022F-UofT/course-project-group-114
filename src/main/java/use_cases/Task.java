package use_cases;

import java.util.Hashtable;

public abstract class Task {
    protected static Hashtable<String, Boolean> completions = new Hashtable<>();
    protected static Hashtable<String, Boolean> activations = new Hashtable<>();
    public static void setCompletionStatus(String task, boolean status) {
        completions.remove(task);
        completions.put(task, status);
    }
    public static boolean getCompletionStatus(String task) {
        return completions.get(task);
    }
    public static void setActivatedStatus(String task, boolean status) {
        activations.remove(task);
        activations.put(task, status);
    }
    public static boolean getActivatedStatus(String task) {
        return activations.get(task);
    }
    public static void reset(String task) {
        setCompletionStatus(task, false);
        setActivatedStatus(task, true);
    }
}
