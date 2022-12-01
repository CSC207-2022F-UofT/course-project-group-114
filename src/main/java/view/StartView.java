package view;

import controller.NonGameController;
import presenter.HighscorePresenter;

import javax.swing.*;
import java.awt.*;

/**
 * This view class draws the JFrame that displays the start menu
 * and high score board
 *
 * @author Ming Hin Joshua Li
 */
public class StartView extends JFrame {

    /**
     * This constructor creates multiple panels that are stored into a
     * CardLayout. The panels include: a start menu that contains
     * a button to start the game, a menu that allows the player to
     * switch to the AuthenticatorView or view the high scores, and
     * a high score board that showcases the highest scores retrieved from
     * the txt file by the use case (retrieved from the controller and
     * presenters) with a button that switched the view to the
     * AuthenticatorView.
     */
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
        NonGameController.getScores();
        ImageIcon backButton = new ImageIcon("src/main/java/resources/return.png");
        JButton goBack = new JButton(backButton);
        goBack.setBorderPainted(false);
        goBack.setBorder(null);
        goBack.setMargin(new Insets(0, 0, 0, 0));
        goBack.setContentAreaFilled(false);
        goBack.setBounds(860, 550, backButton.getIconWidth(), backButton.getIconHeight());
        highscorePanel.add(notepad, Integer.valueOf(0));
        highscorePanel.add(goBack, Integer.valueOf(2));


        JPanel main = new JPanel(new CardLayout());
        main.add(startPanel);
        main.add(menuPanel);
        main.add(highscorePanel);
        add(main);

        setTitle("Start Menu");
        setSize(1290,750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // these buttons switches the panels
        start.addActionListener(e -> {
            menuPanel.setVisible(true);
            startPanel.setVisible(false);
        });

        highscoreButton.addActionListener(e -> {
            menuPanel.setVisible(false);
            NonGameController.getScores();
            highscorePanel.add(HighscorePresenter.getScore(), Integer.valueOf(1));
            highscorePanel.setVisible(true);
        });

        // both these buttons doe the same thing (switches to the AuthenticatorView)
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
