package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controller.GameMasterController;

public class GameMasterView extends JFrame{
    JLayeredPane layers;
    ImageIcon backgroundIcon;
    JLabel background;
    ImageIcon catClockIcon;
    JLabel catClock;

    public GameMasterView() {
        layers = new JLayeredPane();

        backgroundIcon = scaleIcon("src\\main\\java\\resources\\GameMaster\\background.jpg", 1280, 720);
        background = new JLabel();
        background.setBounds(0, 0, 1280, 720);
        background.setIcon(backgroundIcon);

//        catClockIcon = scaleIcon("src\\main\\java\\resources\\GameMaster\\clock\\catclock2.png", 200, 100);
        catClockIcon = new ImageIcon("src\\main\\java\\resources\\GameMaster\\clock\\catclock.gif");
        catClock = new JLabel();
        catClock.setBounds(0, 0, 1280, 720);
        catClock.setIcon(catClockIcon);

        layers.add(background, Integer.valueOf(0));
        layers.add(catClock, Integer.valueOf(1));
        layers.setPreferredSize(new Dimension(1280, 720));

        add(layers);

        setSize(1280,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        layers.setVisible(true);
    }

    public static void main(String[] args) {
        new GameMasterView();
    }

    private ImageIcon scaleIcon(String iconSource, int w, int h) {
        ImageIcon icon = new ImageIcon(iconSource);
        return new ImageIcon(icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
    }
}
