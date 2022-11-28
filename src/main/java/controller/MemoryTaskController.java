package controller;

import entities.MemoryTask;

import javax.swing.*;

public class MemoryTaskController {

    public boolean passer(String actualPassword, JTextField typedPassword){
        return (MemoryTask.checkCorrectness(actualPassword, typedPassword.getText()));
    }
    public static void setCompletionStatus(boolean status) {
        MemoryTask.setCompletionStatus(status);
    }
    public static void setActivatedStatus(boolean status) {
        MemoryTask.setActivatedStatus(status);
    }

}
