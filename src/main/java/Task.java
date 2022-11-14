public abstract class Task {
    private boolean completed = false;

    public abstract void setCompletedStatus(boolean completed);

    public abstract void getCompletedStatus();

    public abstract void display();
}
