package view;

import controller.ClickTaskController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClickTaskView extends JFrame implements ActionListener{

    // 1. Declare variables, but I'm not sure if I should add private/public before type
    // IntelliJ gives warnings when I make it private: variable might be final
    JLabel background;
    JLabel printText;
    JLabel printNeed;
    int currentClicks;
    JButton button;
    ImageIcon full;
    ClickTaskController clickTaskController;
    public ClickTaskView(){
        clickTaskController = new ClickTaskController();
        setTitle("Click entities.Task v.1.0.0");
        setSize(1920,1080);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        // 2. JFrame and JPanel difference?
        // 3. Different layout for different pane?
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("src\\main\\java\\resources\\background.jpg")));
        setLayout(new FlowLayout());
        background = new JLabel();
        full = new ImageIcon("src\\main\\java\\resources\\full.png");
        // Few things I need to fix about the button:
        // 4. Transparent background
        // 5. Adjust position
        button = new JButton(full);
        button.setPreferredSize(new Dimension(192,108));
        button.addActionListener(this);
        printText = new JLabel("Current clicks: 0");
        printNeed = new JLabel("Needed clicks: " + clickTaskController.getNeededClicks());
        add(background);
        add(button);
        // 6. Adjust text positions (not on button, and separate two labels)
        button.add(printText);
        button.add(printNeed);
        setSize(1920,1080);
    }

    public static void main(String[] args) {
        new ClickTaskView();
    }

    // 7. No time method
    // 8. Button picture changes as currentClicks go up
    // 9. Picture size doesn't seem right
    // 10. Test cases
    // 11. Life deduction
    @Override
    public void actionPerformed(ActionEvent e) {
        currentClicks ++;
        clickTaskController.setCurrentClicks(currentClicks);
        printText.setText("Current clicks: " + currentClicks);
        boolean success = (clickTaskController.getNeededClicks() == currentClicks);
        if (success){
            System.exit(0);
        }
    }
}