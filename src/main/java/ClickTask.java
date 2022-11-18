import java.util.Random;

public class ClickTask extends Task{
    private int currentClicks;
    private int neededClicks;
    // changes as difficulty level increases, so I'm making upperbond static for now
    final int upperbond = 60;

    public ClickTask() {
        super();
        this.setNeededClicks();
    }

    private void setNeededClicks() {
        Random newNeed = new Random();
        this.neededClicks = newNeed.nextInt(upperbond);
    }

    public int getNeededClicks(){
        return this.neededClicks;
    }

    public void setCurrentClicks(int newCurrentClicks){
        this.currentClicks = newCurrentClicks;
    }

    @Override
    public void reset() {
        this.currentClicks = 0;
        this.neededClicks = 0;
    }
}
