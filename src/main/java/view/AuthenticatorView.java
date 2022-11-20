package view;

import javax.swing.*;
import java.awt.*;
import controller.NonGameController;

public class AuthenticatorView extends JFrame {
    AuthenticatorView(){
        Dimension maxSize = new Dimension(1280, 720);
        ImageIcon loginIcon = new ImageIcon("src/main/java/resources/log_in_button.png");
        ImageIcon signinIcon = new ImageIcon("src/main/java/resources/sign_in_button.png");
        Color blue = new Color(150,132,255);

        JLayeredPane loginPanel = new JLayeredPane();
        JButton loginSubmit = new JButton(loginIcon);
        loginSubmit.setBorderPainted(false);
        loginSubmit.setBorder(null);
        loginSubmit.setMargin(new Insets(0, 0, 0, 0));
        loginSubmit.setContentAreaFilled(false);
        loginSubmit.setBounds(430, 590, loginIcon.getIconWidth(), loginIcon.getIconHeight());
        JButton signinSwitch = new JButton(signinIcon);
        signinSwitch.setBorderPainted(false);
        signinSwitch.setBorder(null);
        signinSwitch.setMargin(new Insets(0, 0, 0, 0));
        signinSwitch.setContentAreaFilled(false);
        signinSwitch.setBounds(1000, 400, signinIcon.getIconWidth(), signinIcon.getIconHeight());
        JTextField loginUsername = new JTextField(20);
        loginUsername.setHorizontalAlignment(JTextField.LEFT);
        loginUsername.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 50));
        loginUsername.setForeground(blue);
        loginUsername.setBounds(400, 300, 350, 65);
        loginUsername.setOpaque(true);
        loginUsername.setMargin(new Insets(0, 0, 0, 0));
        JTextField loginPassword = new JTextField(20);
        loginPassword.setHorizontalAlignment(JTextField.LEFT);
        loginPassword.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 50));
        loginPassword.setForeground(blue);
        loginPassword.setBounds(400, 500, 350, 65);
        loginPassword.setOpaque(true);
        loginPassword.setMargin(new Insets(0, 0, 0, 0));
        ImageIcon loginImage = new ImageIcon("src/main/java/resources/log_in_bg.jpg");
        JLabel loginBackground = new JLabel(loginImage);
        loginBackground.setPreferredSize(maxSize);
        loginBackground.setBounds(0,     0, 1280, 720);
        loginPanel.add(loginBackground, Integer.valueOf(0));
        loginPanel.add(loginSubmit, Integer.valueOf(1));
        loginPanel.add(signinSwitch, Integer.valueOf(1));
        loginPanel.add(loginUsername, Integer.valueOf(1));
        loginPanel.add(loginPassword, Integer.valueOf(1));

        JLayeredPane signinPanel = new JLayeredPane();
        JButton signinSubmit = new JButton(signinIcon);
        signinSubmit.setBorderPainted(false);
        signinSubmit.setBorder(null);
        signinSubmit.setMargin(new Insets(0, 0, 0, 0));
        signinSubmit.setContentAreaFilled(false);
        signinSubmit.setBounds(740, 500, loginIcon.getIconWidth(), loginIcon.getIconHeight());
        JButton loginSwitch = new JButton(loginIcon);
        loginSwitch.setBorderPainted(false);
        loginSwitch.setBorder(null);
        loginSwitch.setMargin(new Insets(0, 0, 0, 0));
        loginSwitch.setContentAreaFilled(false);
        loginSwitch.setBounds(1000, 400, signinIcon.getIconWidth(), signinIcon.getIconHeight());
        ImageIcon signinImage = new ImageIcon("src/main/java/resources/sign_in_bg.jpg");
        JLabel signinBackground = new JLabel(signinImage);
        signinBackground.setPreferredSize(maxSize);
        signinBackground.setBounds(0,     0, 1280, 720);
        signinPanel.add(signinBackground, Integer.valueOf(0));
        signinPanel.add(signinSubmit, Integer.valueOf(1));
        signinPanel.add(loginSwitch, Integer.valueOf(1));

        JPanel main = new JPanel(new CardLayout());
        main.add(loginPanel);
        main.add(signinPanel);
        add(main);

        setTitle("Your information");
        setSize(1290,750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        signinSwitch.addActionListener(e -> {
            loginPanel.setVisible(false);
            signinPanel.setVisible(true);
        });

        loginSwitch.addActionListener(e -> {
            signinPanel.setVisible(false);
            loginPanel.setVisible(true);
        });

        loginSubmit.addActionListener(e -> {
            if(NonGameController.login(loginUsername.getText(), loginPassword.getText())){
                // call gamemaster view
                JOptionPane.showMessageDialog(null, "works lol");
            }
            else {
                JOptionPane.showMessageDialog(null, "Error loggin in!");
            }
        });
    }
}
