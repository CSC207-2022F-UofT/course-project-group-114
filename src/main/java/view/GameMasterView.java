package view;
import controller.GameMasterController;

import java.awt.*;
import javax.swing.*;
import java.time.Clock;

public class GameMasterView extends JFrame{
    JLayeredPane layers;
    ImageIcon backgroundIcon;
    JLabel background;
    ImageIcon catClockIcon;
    JLabel catClock;
    ImageIcon thermostatIcon;
    JLabel thermostat;
    ImageIcon phoneIcon;
    JLabel phone;
    ImageIcon screenIcon;
    JLabel screen;
    ImageIcon assignmentButtonIcon;
    JLabel assignmentButton;
    ImageIcon assignmentWarningIcon;
    JLabel assignmentWarning;
    ImageIcon memoryWarningIcon;
    JLabel memoryWarning;
    ImageIcon memoryButtonIcon;
    JLabel memoryButton;
    ImageIcon wireIcon;
    JLabel wire;

    public GameMasterView() {
        layers = new JLayeredPane();

        // Create background JLabel
        backgroundIcon = scaleIcon("src\\main\\java\\resources\\GameMaster\\background.jpg");
        background = new JLabel();
        background.setBounds(0, 0, 1280, 720);
        background.setIcon(backgroundIcon);

        // Create cat clock JLabel
        catClockIcon = new ImageIcon("src\\main\\java\\resources\\GameMaster\\clock\\catclock.gif");
        catClock = new JLabel();
        catClock.setBounds(0, 0, 1280, 720);
        catClock.setIcon(catClockIcon);

        // Create thermostat JLabel
        thermostatIcon = scaleIcon("src\\main\\java\\resources\\GameMaster\\heat\\heat neutral.png");
        thermostat = new JLabel();
        thermostat.setBounds(0, 0, 1280, 720);
        thermostat.setIcon(thermostatIcon);

        // Create phone JLabel
        phoneIcon = scaleIcon("src\\main\\java\\resources\\GameMaster\\phone\\phone neutral.png");
        phone = new JLabel();
        phone.setBounds(0, 0, 1280, 720);
        phone.setIcon(phoneIcon);

        // Create screen JLabel
        screenIcon = scaleIcon("src\\main\\java\\resources\\GameMaster\\screen\\screen neutral.png");
        screen = new JLabel();
        screen.setBounds(0, 0, 1280, 720);
        screen.setIcon(screenIcon);

        // Add all neutral elements to the JLayeredPane
        layers.add(background, Integer.valueOf(0));
        layers.add(catClock, Integer.valueOf(1));
        layers.add(thermostat, Integer.valueOf(2));
        layers.add(phone, Integer.valueOf(3));
        layers.add(screen, Integer.valueOf(4));
        layers.setPreferredSize(new Dimension(1280, 720));

        add(layers);

        setSize(1280,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        layers.setVisible(true);

        // Check for every task activation or de-activation
//        Clock clock = Clock.systemDefaultZone();
//        long currTime = clock.millis();
//        int checkInterval = 500; // Interval for checking task status in milliseconds
//        while (GameMasterController.getPlayingStatus()) {
//            if (clock.millis() >= currTime + checkInterval) { // Enough time has passed; check tasks' status
//                currTime = clock.millis(); // Update current time
//                if ()
//            }
//        }
    }

    public static void main(String[] args) {
        new GameMasterView();
    }

    // Helper method for rescaling an ImageIcon
    private ImageIcon scaleIcon(String iconSource) {
        ImageIcon icon = new ImageIcon(iconSource);
        return new ImageIcon(icon.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH));
    }
}
