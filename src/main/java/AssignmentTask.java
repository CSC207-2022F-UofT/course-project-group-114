public class AssignmentTask extends Task{
    private boolean completed = false;
    private int characterCountNeeded;
    private int currentCharacterCount;

    public AssignmentTask(){
        this.completed = true;
        this.characterCountNeeded = 0;
        this.currentCharacterCount = 0;
    }

    @Override
    public void setCompletedStatus(boolean completed) {
        this.completed = completed;
    }

    @Override
    public void getCompletedStatus() {
        return this.completed;
    }

    @Override
    public void setActivatedStatus(boolean activated) {

    }


}
