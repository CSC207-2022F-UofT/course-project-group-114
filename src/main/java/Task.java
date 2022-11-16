public abstract class Task {

    protected boolean completed = false;
    protected boolean activated = false;

    public void setCompletionStatus(boolean completed) {
        this.completed = completed;
    }

    public boolean getCompletionStatus() {
        return this.completed;
    }


    public void setActivatedStatus(boolean activated) {
        this.activated = activated;
    }

    public boolean getActivatedStatus() {
        return this.activated;
    }


}
