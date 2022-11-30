package usecases;

import java.util.Hashtable;

public abstract class Task {

//    protected static boolean completed = false;
//    protected static boolean activated = false;
//
//    public static void setCompletionStatus(boolean status) {
//        completed = status;
//    }
//
//    public static boolean getCompletionStatus() {
//        return completed;
//    }
//
//
//    public static void setActivatedStatus(boolean status) {
//        activated = status;
//    }
//
//    public static boolean getActivatedStatus() {
//        return activated;
//    }
    protected static Hashtable<String, Boolean> completions = new Hashtable<String, Boolean>();
    protected static Hashtable<String, Boolean> activations = new Hashtable<String, Boolean>();
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
