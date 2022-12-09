package controller;

import org.junit.jupiter.api.Test;

import use_cases.GameMaster;

/**
 * Class representing the tests for the GameMasterController class.
 *
 * @author Elena Scobici
 */

public class GameMasterControllerTest {
    /**
     * Test that the GameMasterController getPlayingStatus method returns true when the GameMaster playing
     * variable is true.
     */
    @Test
    void testGetPlayingStatusTrue() {
        GameMaster.playing = true;
        assert(GameMasterController.getPlayingStatus());
    }

    /**
     * Test that the GameMasterController getPlayingStatus method returns false when the GameMaster playing
     * variable is false.
     */
    @Test
    void testGetPlayingStatusFalse() {
        GameMaster.playing = false;
        assert(!GameMasterController.getPlayingStatus());
    }

    /**
     * Test that the GameMasterController getTaskInterval method returns the same value as the GameMaster
     * getTaskInterval method.
     */
    @Test
    void testGetTaskInterval() {
        assert(GameMaster.getTaskInterval() == GameMasterController.getTaskInterval());
    }

    /**
     * Test that the setTaskInterval method of the GameMasterController correctly sets the taskInterval value of the
     * GameMaster class.
     */
    @Test
    void testSetTaskInterval() {
        GameMasterController.setTaskInterval(-1);
        assert(GameMaster.getTaskInterval() == -1);
    }
}
