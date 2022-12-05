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

    @Test
    public void endGameEnoughClicksTest(){

    }

    @Test
    public void endGameNotEnoughClicksTest(){

    }
}
