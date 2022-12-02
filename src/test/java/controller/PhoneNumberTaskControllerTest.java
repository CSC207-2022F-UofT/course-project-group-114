package controller;

import org.junit.jupiter.api.Test;
import usecases.PhoneNumberTask;

/**
 * Class representing the tests for the HeatAdjustmentTaskController class.
 *
 * @author Kaavya Kalani
 */
public class PhoneNumberTaskControllerTest {

    /**
     * Tests is the activation status is set to true correctly
     */
    @Test
    void testActivationStatusTrue(){
        PhoneNumberTask.setActivatedStatus("PhoneNumberTask", false);
        PhoneNumberTaskController.setActivatedStatus(true);
        assert(PhoneNumberTaskController.getActivatedStatus());
    }

    /**
     * Tests is the activation status is set to false correctly
     */
    @Test
    void testActivationStatusFalse(){
        PhoneNumberTask.setActivatedStatus("PhoneNumberTask", true);
        PhoneNumberTaskController.setActivatedStatus(false);
        assert(!PhoneNumberTaskController.getActivatedStatus());
    }
}
