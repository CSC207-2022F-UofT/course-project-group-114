public class AssignmentTask extends Task{
    protected boolean completed = false;
    protected int characterCountNeeded;
    protected int currentCharacterCount;

    public AssignmentTask(){
        this.completed = false;
        setCharacterCountNeeded();
        this.currentCharacterCount = 0;
    }


    public void setCharacterCountNeeded(){
        // generate random number from lowerbound and upperbound
        int COUNT_UPPERBOUND = 50;
        int COUNT_LOWERBOUND = 30;
        this.characterCountNeeded =
                (int) Math.floor(Math.random()*(COUNT_UPPERBOUND - COUNT_LOWERBOUND +1)+ COUNT_LOWERBOUND);
    }

    public void setCurrentCharacterCount(int currCharCount){
        this.currentCharacterCount = currCharCount;
    }

    public void checkCount(){
        if (this.currentCharacterCount >= this.characterCountNeeded){
            this.setCompletionStatus(true);
            this.setActivatedStatus(false);
        }
    }




}
