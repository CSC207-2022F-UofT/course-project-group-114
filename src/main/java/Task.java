public abstract class Task {
    private boolean completed = false;

    public abstract void setGetCompletedStatus(boolean completed);

    public abstract void getCompletedStatus();

    public abstract void display();
}
