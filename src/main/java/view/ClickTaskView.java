package view;

import java.awt.*;
import controller.ClickTaskController;
import javax.swing.*;

public class ClickTaskView extends JFrame{

    // 1. Declare variables, but I'm not sure if I should add private/public before type
    // IntelliJ gives warnings when I make it private: variable might be final
    // 2. java doc
    // 3. Test cases
    // 4. Life deduction
    // 5. Print message before closing?

    public ClickTaskView(){
        ClickTaskController clickTaskController = new ClickTaskController();

        // Click Task plane
        JLayeredPane clickTaskPanel = new JLayeredPane();
        clickTaskPanel.setPreferredSize(new Dimension(1920,1080));

        // Header settings
        JTextField header = new JTextField("TODO: CLICK TO EAT AND DON'T WASTE FOOD!! \n Current Clicks: 0");
        header.setHorizontalAlignment(JTextField.RIGHT);
        header.setEditable(false);
        header.setFont(new java.awt.Font("Serif", Font.ITALIC | Font.BOLD, 28));
        header.setBounds(0,0,1280,80);
        header.setOpaque(false);
        header.setBorder(null);
        header.setMargin(new Insets(0,0,0,0));

        // Set background
        ImageIcon bgImg = new ImageIcon("src\\main\\java\\resources\\ClickTask\\background.jpg");
        JLabel background = new JLabel(bgImg);
        background.setPreferredSize(new Dimension(1920,1080));
        background.setBounds(0,0,1920,1080);

        // Read images from folder ClickTask
        ImageIcon full = new ImageIcon("src\\main\\java\\resources\\ClickTask\\full.png");
        ImageIcon first = new ImageIcon("src\\main\\java\\resources\\ClickTask\\first.png");
        ImageIcon second = new ImageIcon("src\\main\\java\\resources\\ClickTask\\second.png");
        ImageIcon third = new ImageIcon("src\\main\\java\\resources\\ClickTask\\third.png");
        ImageIcon last = new ImageIcon("src\\main\\java\\resources\\ClickTask\\last.png");

        // Add the fries
        JButton button = new JButton(full);
        button.setContentAreaFilled(false);
        button.setBounds(0,0,full.getIconWidth(), full.getIconHeight());
        button.setPreferredSize(new Dimension(full.getIconWidth(),full.getIconHeight()));
        button.addActionListener(e -> {
            int currentClicks = clickTaskController.getCurrentClicks() + 1;
            clickTaskController.setCurrentClicks(currentClicks);
            header.setText("TODO: CLICK TO EAT AND DON'T WASTE FOOD!! \nCurrent Clicks: " + currentClicks);

            // Change icons as users make more clicks
            if (currentClicks == clickTaskController.getNeededClicks() - 1) {
                button.setIcon(last);
            } else if (currentClicks == clickTaskController.getNeededClicks() - 2){
                button.setIcon(third);
            } else if (clickTaskController.getPortion()) {
                button.setIcon(second);
            } else {
                button.setIcon(first);
            }

            // determines if the requirement is met
            boolean success = (clickTaskController.getNeededClicks() == currentClicks);
            if (success){
                dispose();
            }
        });

        // Add layers
        clickTaskPanel.add(background, Integer.valueOf(0));
        clickTaskPanel.add(button, Integer.valueOf(1));
//        clickTaskPanel.add(info, Integer.valueOf(2));
        clickTaskPanel.add(header, Integer.valueOf(2));

        add(clickTaskPanel);

        // JFrame settings
        setTitle("Click Task v.1.1.0");
        setSize(1295,760);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Main method
    public static void main(String[] args) {
        new ClickTaskView();
    }
}