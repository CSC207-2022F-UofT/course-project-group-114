package controller;

import org.junit.jupiter.api.Test;

public class PhoneNumberTaskControllerTest {

    @Test
    void testNoLengthManipulation(){
        PhoneNumberTaskController controller = new PhoneNumberTaskController();
        controller.passer(123456789, "123456789");
    }

}
