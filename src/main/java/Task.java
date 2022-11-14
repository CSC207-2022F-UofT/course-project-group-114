public abstract class Task {
    private boolean completed = false;
    private boolean activated = false;
    public abstract void setCompletedStatus(boolean completed);

    public abstract boolean getCompletedStatus();

}
