package controller;

import entities.ClickTask;
import entities.MemoryTask;

import javax.swing.*;

public class MemoryTaskController {

    public boolean passer(String actual_password, JTextField typed_password){
        return (MemoryTask.checkCorrectness(actual_password, typed_password.getText()));
    }
    public static void setCompletionStatus(boolean status) {
        MemoryTask.setCompletionStatus(status);
    }
    public static void setActivatedStatus(boolean status) {
        MemoryTask.setActivatedStatus(status);
    }

}
