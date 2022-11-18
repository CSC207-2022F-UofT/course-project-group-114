package view;
import controller.NonGameController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartView extends JFrame implements ActionListener {
    private JPanel main;
    private JButton start;
    private ImageIcon door;
    private ImageIcon play;
    private ImageIcon highscore;
    private ImageIcon bg;

    private JLabel background;

    private JLayeredPane menuPanel;
    private JPanel startPanel;

    StartView(){
        NonGameController controller = new NonGameController();

        startPanel = new JPanel();
        door = new ImageIcon("src\\main\\java\\resources\\start.jpg");
        start = new JButton(door);
        start.setPreferredSize(new Dimension(1920,1080));
        start.addActionListener(this);
        startPanel.add(start);

        menuPanel = new JLayeredPane();
        bg = new ImageIcon("src\\main\\java\\resources\\menu.jpg");
        background = new JLabel(bg);
        background.setPreferredSize(new Dimension(1920,1080));
        menuPanel.add(background);

        main = new JPanel(new CardLayout());
        main.add(menuPanel, "MENUPANEL");
        main.add(startPanel, "STARTPANEL");
        add(main);
        // for the pull request
        start.add(new JLabel("Start"));

        setTitle("StartMenu");
        setSize(1920,1080);
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
        startPanel.setVisible(false);
        menuPanel.setVisible(true);
    }
}
