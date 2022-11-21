package view;

import java.awt.*;
import controller.ClickTaskController;
import controller.WireTaskController;

import javax.swing.*;

public class WireTaskView extends JLayeredPane{

    // IMAGES
    ImageIcon backgroundImage;
    JLabel background;

    ImageIcon r1;
    ImageIcon g1;
    ImageIcon b1;
    ImageIcon r2;
    ImageIcon g2;
    ImageIcon b2;
    JLabel r1button;
    JLabel g1button;
    JLabel b1button;
    JLabel r2button;
    JLabel g2button;
    JLabel b2button;

    private static String previous;
    private static String current;
    private boolean done;

    public WireTaskView() {

    }

    public static void main(String[] args) {
        new WireTaskView();
    }
}
