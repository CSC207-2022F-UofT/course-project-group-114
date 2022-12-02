package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controller.WireTaskController;
import presenter.WireTaskPresenter;

/**
 * A class representing WireTaskView, which has the role of creating the UI for WireTask.
 *
 * @author Roy
 */

public class WireTaskView extends JLayeredPane{
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

    public WireTaskView() {

    }

    public static void main(String[] args) {

        new WireTaskView();
    }
}
