package view;

import controller.MemoryTaskController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.UUID;

import java.util.Timer;

/**
 * The View class for the Memory Task which creates a JLayeredPane that
 * displays all components needed for the Memory Task.
 * @author Kaavya
 * @inheritDoc JLayeredPane
 */
public class MemoryTaskView extends JLayeredPane{

    /**
     * The constructor for the MemoryTaskView which creates and places all the
     * required components on the JLayeredPane and has event listeners which
     * pass information to the controller when needed.
     */
    MemoryTaskView(){

        MemoryTaskController controller = new MemoryTaskController();
        String actualPassword = (UUID.randomUUID().toString().replaceAll("-", "")).substring(0,8);

        JLabel message = new JLabel("Your password to remember is: " + actualPassword);
        message.setPreferredSize(new Dimension(1280,720));
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setFont(new java.awt.Font("Serif", Font.BOLD, 22));
        message.setBounds(0,     0, 1280, 720);

        ImageIcon bg = new ImageIcon("src/main/java/resources/MemoryTask/bg.jpg");
        JLabel background = new JLabel(bg);
        background.setPreferredSize(new Dimension(1280,720));
        background.setBounds(0,     0, 1280, 720);

        ImageIcon logIn = new ImageIcon("src/main/java/resources/MemoryTask/login.png");
        JButton logInButton = new JButton(logIn);
        logInButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        logInButton.setBounds(200, 580, logIn.getIconWidth(), logIn.getIconHeight());

        JTextField password = new JTextField();
        password.setEditable(true);
        password.setHorizontalAlignment(JTextField.LEFT);
        password.setFont(new java.awt.Font("Serif", Font.BOLD, 18));
        password.setForeground(Color.BLACK);
        password.setBounds(120, 476, 268, 62);
        password.setOpaque(false);
        password.setMargin(new Insets(0, 0, 0, 0));


        setPreferredSize(new Dimension(1280,720));
        setVisible(true);

        add(message, Integer.valueOf(0));

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                remove(0);
                add(background, Integer.valueOf(0));
                add(logInButton, Integer.valueOf(1));
                add(password, Integer.valueOf(2));
                // Check if time ran out / task was deactivated
                if (!MemoryTaskController.getActivatedStatus()) {
                    GameMasterView.backToMain(GameMasterView.memoryTaskView);
                }
            }
        };

        timer.schedule(task, 5000);

        logInButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
//                 passes the text collected to the controller
                String typedPassword = password.getText();
                boolean success = controller.passer(actualPassword, typedPassword);
                if(success){
                    JOptionPane.showMessageDialog(null, "Successful");
                    MemoryTaskController.setCompletionStatus(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Unsuccessful");
                    MemoryTaskController.setCompletionStatus(false);
                }
                setVisible(false);
                MemoryTaskController.setActivatedStatus(false);
                GameMasterView.backToMain(GameMasterView.memoryTaskView);
            }
        });

    }
    public static void main(String[] args) {
        new MemoryTaskView();
    }
}
