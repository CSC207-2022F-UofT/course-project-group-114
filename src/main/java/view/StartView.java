package view;

import controller.NonGameController;

import javax.swing.*;
import java.awt.*;

public class StartView extends JFrame {

    StartView(){
        Dimension maxSize = new Dimension(1280, 720);

        JPanel startPanel = new JPanel();
        ImageIcon door = new ImageIcon("src/main/java/resources/start.jpg");
        JButton start = new JButton(door);
        // clean up variables if theyre not needed beyond contructor
        start.setPreferredSize(maxSize);
        startPanel.add(start);

        JLayeredPane menuPanel = new JLayeredPane();
        menuPanel.setPreferredSize(maxSize);
        ImageIcon play = new ImageIcon("src/main/java/resources/play_button.png");
        JButton playButton = new JButton(play);
        playButton.setBorderPainted(false);
        playButton.setBorder(null);
        playButton.setMargin(new Insets(0, 0, 0, 0));
        playButton.setContentAreaFilled(false);
        playButton.setBounds(340, 200, play.getIconWidth(), play.getIconHeight());
        ImageIcon highscore = new ImageIcon("src/main/java/resources/highscore_button.png");
        JButton highscoreButton = new JButton(highscore);
        highscoreButton.setBorderPainted(false);
        highscoreButton.setBorder(null);
        highscoreButton.setMargin(new Insets(0, 0, 0, 0));
        highscoreButton.setContentAreaFilled(false);
        highscoreButton.setBounds(320, 420, highscore.getIconWidth(), highscore.getIconHeight());
        ImageIcon bg = new ImageIcon("src/main/java/resources/menu.jpg");
        JLabel background = new JLabel(bg);
        background.setPreferredSize(maxSize);
        background.setBounds(0,     0, 1280, 720);
        menuPanel.add(background, Integer.valueOf(0));
        menuPanel.add(playButton, Integer.valueOf(1));
        menuPanel.add(highscoreButton, Integer.valueOf(1));

        JLayeredPane highscorePanel = new JLayeredPane();
        highscorePanel.setPreferredSize(maxSize);
        ImageIcon highscoreBackground = new ImageIcon("src/main/java/resources/highscore_bg.jpg");
        JLabel notepad = new JLabel(highscoreBackground);
        notepad.setPreferredSize(maxSize);
        notepad.setBounds(0,     0, 1280, 720);
        //go when button pressed, tell controller to tell user to grab stuff then here we ask view to grab from controller
        JTextArea scores = new JTextArea(NonGameController.getScores());
        scores.setEditable(false);
        scores.setFont(new Font("Snell Roundhand", Font.ITALIC | Font.BOLD, 40));
        scores.setForeground(Color.BLACK);
        scores.setBounds(460, 300, 1280, 720); // FIX THIS LATER
        scores.setOpaque(false);
        scores.setBorder(null);
        scores.setMargin(new Insets(0, 0, 0, 0));
        ImageIcon backButton = new ImageIcon("src/main/java/resources/return.png");
        JButton goBack = new JButton(backButton);
        goBack.setBorderPainted(false);
        goBack.setBorder(null);
        goBack.setMargin(new Insets(0, 0, 0, 0));
        goBack.setContentAreaFilled(false);
        goBack.setBounds(860, 550, backButton.getIconWidth(), backButton.getIconHeight());
        highscorePanel.add(notepad, Integer.valueOf(0));
        highscorePanel.add(scores, Integer.valueOf(1));
        highscorePanel.add(goBack, Integer.valueOf(2));


        JPanel main = new JPanel(new CardLayout());
        main.add(startPanel);
        main.add(menuPanel);
        main.add(highscorePanel);
        add(main);

        setTitle("StartMenu");
        setSize(1290,750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        start.addActionListener(e -> {
            menuPanel.setVisible(true);
            startPanel.setVisible(false);
        });

        highscoreButton.addActionListener(e -> {
            menuPanel.setVisible(false);
            highscorePanel.setVisible(true);
        });

        playButton.addActionListener(e -> {
            this.dispose();
            new AuthenticatorView();
        });

        goBack.addActionListener(e -> {
            this.dispose();
            new AuthenticatorView();
        });
    }

    public static void main(String[] args) {
        new StartView();
    }
}
