package presenter;

import presenter.ClickTaskPresenter;
import usecases.ClickTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Random;

/**
 * The ClickTaskPresenterTest class checks methods in
 * ClickTaskPresenter.java.
 *
 * @author Siyuan Deng
 */
public class ClickTaskPresenterTest {

    /**
     * This tests if the setActivatedStatus method works when it's set
     * to true.
     */
    @Test
    public void setActivatedStatusTrueTest(){
        ClickTaskPresenter.setActivatedStatus(true);
        Assertions.assertTrue(ClickTask.getActivatedStatus("ClickTask"));
    }

    /**
     * This tests if the setActivatedStatus method works when it's set
     * to false.
     */
    @Test
    public void setActivatedStatusFalseTest(){
        ClickTaskPresenter.setActivatedStatus(false);
        Assertions.assertFalse(ClickTask.getActivatedStatus("ClickTask"));
    }

    /**
     * This tests if the setCompletionStatus method works when it's set
     * to true.
     */
    @Test
    public void setCompletionStatusTrueTest(){
        ClickTaskPresenter.setCompletionStatus(true);
        Assertions.assertTrue(ClickTask.getCompletionStatus("ClickTask"));
    }

    /**
     * This tests if the setCompletionStatus method works when it's set
     * to false.
     */
    @Test
    public void setCompletionStatusFalseTest(){
        ClickTaskPresenter.setCompletionStatus(false);
        Assertions.assertTrue(ClickTask.getCompletionStatus("ClickTask"));
    }

    /**
     * This tests if the endGame method works when the user has made enough clicks.
     */
    @Test
    public void endGameEnoughClicksTest(){
        ClickTaskPresenter clickTaskPresenter = new ClickTaskPresenter();
        ClickTask.setNeededClicks();
        int neededClicks = ClickTask.getNeededClicks();
        ClickTask.setCurrentClicks(neededClicks);
        clickTaskPresenter.endGame(true);
        Assertions.assertTrue(ClickTask.getCompletionStatus("ClickTask"));
        Assertions.assertFalse(ClickTask.getActivatedStatus("ClickTask"));
    }

    /**
     * This tests if the endGame method works when the user hasn't made enough clicks.
     */
    @Test
    public void endGameNotEnoughClicksTest(){
        ClickTaskPresenter clickTaskPresenter = new ClickTaskPresenter();
        ClickTask.setNeededClicks();
        int currentClicks = ClickTask.getNeededClicks() - 1;
        ClickTask.setCurrentClicks(currentClicks);
        clickTaskPresenter.endGame(false);
        Assertions.assertTrue(ClickTask.getActivatedStatus("ClickTask"));
        Assertions.assertFalse(ClickTask.getCompletionStatus("ClickTask"));
    }
}
