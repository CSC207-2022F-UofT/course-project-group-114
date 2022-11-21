package controller;

import entities.MemoryTask;

import javax.swing.*;

public class MemoryTaskController {

    public boolean passer(String actual_password, JTextField typed_password){
        return (MemoryTask.check_correctness(actual_password, typed_password.getText()));
    }

}
