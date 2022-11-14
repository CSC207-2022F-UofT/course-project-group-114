public abstract class Task {
    protected boolean completed = false;
    protected boolean activated = false;
    public abstract void setCompletedStatus(boolean completed);

    public abstract boolean getCompletedStatus();

    public abstract void setActivatedStatus(boolean activated);
}
