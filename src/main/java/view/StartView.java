package view;
import controller.NonGameController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartView extends JFrame {
    private JPanel main;
    private JButton start;
    private JButton playButton;
    private JButton highscoreButton;
    private ImageIcon door;
    private ImageIcon play;
    private ImageIcon highscore;
    private ImageIcon bg;

    private JLabel background;

    private JPanel startPanel;

    private JLayeredPane menuPanel;
    private final Dimension maxSize = new Dimension(1280, 720);;

    StartView(){

        startPanel = new JPanel();
        door = new ImageIcon("src\\main\\java\\resources\\start.jpg");
        start = new JButton(door);
        start.setPreferredSize(new Dimension(1280,720));
        startPanel.add(start);

        menuPanel = new JLayeredPane();
        menuPanel.setPreferredSize(maxSize);
        play = new ImageIcon("src\\main\\java\\resources\\play_button.png");
        playButton = new JButton(play);
        playButton.setBorderPainted(false);
        playButton.setBorder(null);
        playButton.setMargin(new Insets(0, 0, 0, 0));
        playButton.setContentAreaFilled(false);
        playButton.setBounds(340, 200, play.getIconWidth(), play.getIconHeight());
        highscore = new ImageIcon("src\\main\\java\\resources\\highscore_button.png");
        highscoreButton = new JButton(highscore);
        highscoreButton.setBorderPainted(false);
        highscoreButton.setBorder(null);
        highscoreButton.setMargin(new Insets(0, 0, 0, 0));
        highscoreButton.setContentAreaFilled(false);
        highscoreButton.setBounds(320, 420, play.getIconWidth() + 50, play.getIconHeight());
        bg = new ImageIcon("src\\main\\java\\resources\\menu.jpg");
        background = new JLabel(bg);
        background.setPreferredSize(maxSize);
        background.setBounds(0,     0, 1280, 720);
        menuPanel.add(background, Integer.valueOf(0));
        menuPanel.add(playButton, Integer.valueOf(1));
        menuPanel.add(highscoreButton, Integer.valueOf(1));

        JLayeredPane highscorePanel = new JLayeredPane();
        highscorePanel.setPreferredSize(maxSize);
        ImageIcon highscoreBackground = new ImageIcon("src\\main\\java\\resources\\highscore_bg.jpg");
        JLabel notepad = new JLabel(highscoreBackground);
        notepad.setPreferredSize(maxSize);
        notepad.setBounds(0,     0, 1280, 720);
        //go when button pressed, tell controller to tell user to grab stuff then here we ask view to grab from controller
        JTextField scores = new JTextField(NonGameController.getScores());
        scores.setEditable(false);
        scores.setHorizontalAlignment(JTextField.CENTER);
        scores.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 50));
        scores.setForeground(Color.BLACK);
        scores.setBounds(0, 0, 1280, 720);
        scores.setOpaque(false);
        scores.setBorder(null);
        scores.setMargin(new Insets(0, 0, 0, 0));
        ImageIcon backButton = new ImageIcon("src\\main\\java\\resources\\play.png");
        JButton goBack = new JButton(backButton);
        goBack.setBorderPainted(false);
        goBack.setBorder(null);
        goBack.setMargin(new Insets(0, 0, 0, 0));
        goBack.setContentAreaFilled(false);
        goBack.setBounds(340, 200, play.getIconWidth(), play.getIconHeight());
        highscorePanel.add(notepad, Integer.valueOf(0));
        highscorePanel.add(scores, Integer.valueOf(1));


        main = new JPanel(new CardLayout());
        main.add(menuPanel, "MENUPANEL");
        main.add(startPanel, "STARTPANEL");
        main.add(highscorePanel, "HIGHSCOREPANEL");
        add(main);

        setTitle("StartMenu");
        setSize(1280,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        menuPanel.setVisible(false);
        highscorePanel.setVisible(false);
        playButton.setVisible(false);
        highscoreButton.setVisible(false);
        startPanel.setVisible(true);

        start.addActionListener(e -> {
            menuPanel.setVisible(true);
            playButton.setVisible(true);
            highscoreButton.setVisible(true);
            startPanel.setVisible(false);
        });

        highscoreButton.addActionListener(e -> {
            menuPanel.setVisible(false);
            highscorePanel.setVisible(true);
        });
    }

    public static void main(String[] args) {
        new StartView();
    }
}
