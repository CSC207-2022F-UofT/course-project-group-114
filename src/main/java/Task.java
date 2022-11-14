public abstract class Task {
    private boolean completed = false;

    public abstract void setCompletedStatus(boolean completed);

    public abstract boolean getCompletedStatus();

    public abstract void display();
}
