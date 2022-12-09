package presenter;

import org.junit.jupiter.api.Test;

import use_cases.GameMaster;
import use_cases.LifeMaster;

/**
 * Class representing the tests for the GameMasterPresenter class.
 *
 * @author Elena Scobici
 */

public class GameMasterPresenterTest {
    /**
     * Test that the GameMasterPresenter getActiveTasks method returns a set of the keys of the times HashMap in
     * the GameMaster class.
     */
    @Test
    void testGetActiveTasksEquality() {
        assert(GameMasterPresenter.getActivateTasks() == GameMaster.getTimes().keySet());
    }

    /**
     * Test that the GameMasterPresenter getTaskCount method returns the same value as the getTaskCount method
     * of the GameMaster class.
     */
    @Test
    void testGetTaskCount() {
        assert(GameMasterPresenter.getTaskCount() == LifeMaster.getTaskCount());
    }

    /**
     * Test that the GameMasterPresenter getScoreText method returns a string representation of the
     * tasksCompletedCount variable of the LifeMaster class.
     */
    @Test
    void testGetScoreText() {
        assert(GameMasterPresenter.getScoreText().equals(Integer.toString(LifeMaster.getTaskCount())));
    }

    /**
     * Test that the GameMasterPresenter getLivesText method returns a string representation of the lives variable
     * of the LifeMaster class.
     */
    @Test
    void testGetLivesText() {
        assert(GameMasterPresenter.getLivesText().equals(Integer.toString(LifeMaster.getLives())));
    }
}
