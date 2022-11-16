public abstract class Task {
    protected boolean completed = false;
    protected boolean activated = false;
    public abstract void setCompletionStatus(boolean completed);

    public abstract boolean getCompletionStatus();

    public abstract void setActivatedStatus(boolean activated);
    public abstract boolean getActivatedStatus();
}
