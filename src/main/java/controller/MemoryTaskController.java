package controller;

import entities.MemoryTask;

import javax.swing.*;

public class MemoryTaskController {
    MemoryTask usecase = new MemoryTask();

    public boolean passer(String actual_password, JTextField typed_password){
        return (usecase.check_correctness(actual_password, typed_password.getText()));
    }

}
