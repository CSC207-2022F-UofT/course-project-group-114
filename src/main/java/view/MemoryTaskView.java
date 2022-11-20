package view;

import controller.MemoryTaskController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MemoryTaskView extends JFrame{


    MemoryTaskView(){


        MemoryTaskController controller = new MemoryTaskController();

        JLayeredPane memoryTaskPanel = new JLayeredPane();
        memoryTaskPanel.setPreferredSize(new Dimension(1280, 720));

        ImageIcon bg = new ImageIcon("src\\main\\java\\resources\\MemoryTask\\bg.jpg");
        JLabel background = new JLabel(bg);
        background.setPreferredSize(new Dimension(1280,720));
        background.setBounds(0,     0, 1280, 720);

        ImageIcon log_in = new ImageIcon("src\\main\\java\\resources\\MemoryTask\\login.png");
        JButton log_in_button = new JButton(log_in);
        log_in_button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        log_in_button.setBounds(200, 580, log_in.getIconWidth(), log_in.getIconHeight());

        JTextField password = new JTextField("Enter the password");
        password.setEditable(true);
        password.setHorizontalAlignment(JTextField.LEFT);
        password.setFont(new java.awt.Font("Serif", Font.ITALIC | Font.BOLD, 18));
        password.setForeground(Color.BLACK);
        password.setBounds(120, 476, 268, 62);
        password.setOpaque(false);
        password.setMargin(new Insets(0, 0, 0, 0));

        memoryTaskPanel.add(background, Integer.valueOf(0));
        memoryTaskPanel.add(log_in_button, Integer.valueOf(1));
        memoryTaskPanel.add(password, Integer.valueOf(2));

        add(memoryTaskPanel);


        setTitle("Memory Task");
        setSize(1295,760);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        log_in_button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // passes the text collected to the controller
                password.getText();
            }
        });

    }
    public static void main(String[] args) {
        new MemoryTaskView();
    }
}
