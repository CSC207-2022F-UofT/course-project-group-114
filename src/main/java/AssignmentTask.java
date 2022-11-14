public class AssignmentTask extends Task{
    private boolean completed = false;
    private int characterCountNeeded;
    private int currentCharacterCount;

    public AssignmentTask(){
        this.completed = true;
        this.characterCountNeeded = 0;
        this.currentCharacterCount = 0;
    }

    public void
    @Override
    public void setCompletedStatus(boolean completed) {
        this.completed = true;
    }

    @Override
    public boolean getCompletedStatus() {
        return this.completed;
    }


}
