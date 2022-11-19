package view;
import controller.NonGameController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartView extends JFrame implements ActionListener {
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

    StartView(){
        NonGameController controller = new NonGameController();

        startPanel = new JPanel();
        door = new ImageIcon("src\\main\\java\\resources\\start.jpg");
        start = new JButton(door);
        start.setPreferredSize(new Dimension(1280,720));
        start.addActionListener(this);
        startPanel.add(start);

        menuPanel = new JLayeredPane();
        menuPanel.setPreferredSize(new Dimension(1280,1080));
        play = new ImageIcon("src\\main\\java\\resources\\play_button.png");
        playButton = new JButton(play);
        playButton.setBorderPainted(false);
        playButton.setBorder(null);
        playButton.setMargin(new Insets(0, 0, 0, 0));
        playButton.setContentAreaFilled(false);
        playButton.setBounds(320, 300, play.getIconWidth(), play.getIconHeight());
        bg = new ImageIcon("src\\main\\java\\resources\\menu.jpg");
        background = new JLabel(bg);
        background.setPreferredSize(new Dimension(1280,720));
        background.setBounds(0,     0, 1280, 720);
        menuPanel.add(background, Integer.valueOf(0));
        menuPanel.add(playButton, Integer.valueOf(1));

        main = new JPanel(new CardLayout());
        main.add(menuPanel, "MENUPANEL");
        main.add(startPanel, "STARTPANEL");
        add(main);
        // for the pull request
        start.add(new JLabel("Start"));

        setTitle("StartMenu");
        setSize(1280,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        menuPanel.setVisible(false);
        startPanel.setVisible(true);
    }

    public static void main(String[] args) {
        new StartView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menuPanel.setVisible(true);
        startPanel.setVisible(false);
    }
}
