package controller;

import org.junit.jupiter.api.Test;

import controller.PhoneNumberTaskController;
import usecases.PhoneNumberTask;

public class PhoneNumberTaskControllerTest {

    @Test
    void testNoLengthManipulation(){
        PhoneNumberTaskController controller = new PhoneNumberTaskController();
        controller.passer(123456789, "123456789");
    }

}
