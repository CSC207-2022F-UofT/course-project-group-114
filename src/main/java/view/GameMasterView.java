package view;
import controller.GameMasterController;
import entities.GameMaster;

import java.awt.*;
import javax.swing.*;
import java.time.Clock;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class GameMasterView extends JFrame{
    JLayeredPane layers;
    ImageIcon backgroundIcon;
    JLabel background;
    ImageIcon catClockIcon;
    ImageIcon activeCatClockIcon;
    JLabel catClock;
    ImageIcon thermostatIcon;
    ImageIcon activeThermostatIcon;
    JLabel thermostat;
    ImageIcon phoneIcon;
    ImageIcon activePhoneIcon;
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

        // Create the non-neutral JLabels; that is, the ones that are not visible at the start of the game
        // Create assignment button JLabel
        assignmentButtonIcon = scaleIcon("src\\main\\java\\resources\\GameMaster\\screen\\assignment task button.png");
        assignmentButton = new JLabel();
        assignmentButton.setBounds(0, 0, 1280, 720);
        assignmentButton.setIcon(assignmentButtonIcon);

        // Create assignment warning JLabel
        assignmentWarningIcon = scaleIcon("src\\main\\java\\resources\\GameMaster\\screen\\assignment task warning.png");
        assignmentWarning = new JLabel();
        assignmentWarning.setBounds(0, 0, 1280, 720);
        assignmentWarning.setIcon(assignmentWarningIcon);

        // Create memory warning JLabel
        memoryWarningIcon = scaleIcon("src\\main\\java\\resources\\GameMaster\\screen\\memory task warning.png");
        memoryWarning = new JLabel();
        memoryWarning.setBounds(0, 0, 1280, 720);
        memoryWarning.setIcon(memoryWarningIcon);

        // Create memory button JLabel
        memoryButtonIcon = scaleIcon("src\\main\\java\\resources\\GameMaster\\screen\\memory task prompt.png");
        memoryButton = new JLabel();
        memoryButton.setBounds(0, 0, 1280, 720);
        memoryButton.setIcon(memoryButtonIcon);

        // Create wire JLabel
        wireIcon = scaleIcon("src\\main\\java\\resources\\GameMaster\\screen\\wire task prompt.png");
        wire = new JLabel();
        wire.setBounds(0, 0, 1280, 720);
        wire.setIcon(wireIcon);

        // Create image icons for activated versions of heat, phone and click tasks
        activeCatClockIcon = scaleIcon("src\\main\\java\\resources\\GameMaster\\clock\\eat alert.gif");
        activePhoneIcon = scaleIcon("src\\main\\java\\resources\\GameMaster\\phone\\phone alert.png");
        activeThermostatIcon = scaleIcon("src\\main\\java\\resources\\GameMaster\\heat\\heat alert.png");

        add(layers);

        setSize(1280,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        layers.setVisible(true);

        // Check for every task activation or de-activation
        Clock clock = Clock.systemDefaultZone();
        long currTime = clock.millis();
        int checkInterval = 500; // Interval for checking task status in milliseconds
        Hashtable<String, Long> times;
        while (GameMasterController.getPlayingStatus()) {
            if (clock.millis() >= currTime + checkInterval) { // Enough time has passed; check tasks' status
                currTime = clock.millis(); // Update current time
                times = GameMaster.getTimes();
                Set<String> activeTasks = times.keySet();
                activateTasks(activeTasks);
            }
        }
    }

    public static void main(String[] args) {
        new GameMasterView();
    }

    // Helper method for rescaling an ImageIcon
    private ImageIcon scaleIcon(String iconSource) {
        ImageIcon icon = new ImageIcon(iconSource);
        return new ImageIcon(icon.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH));
    }

    // Helper method for visually activating the given tasks
    private void activateTasks(Set<String> activeTasks) {
        Component[] comps = layers.getComponentsInLayer(5);
        List<Component> compsList = Arrays.asList(comps);
        if (activeTasks.contains("HeadAdjustmentTask")) {
            thermostat.setIcon(activeThermostatIcon);
        } else {
            thermostat.setIcon(thermostatIcon);
        }
        if (activeTasks.contains("ClickTask")) {
            catClock.setIcon(activeCatClockIcon);
        } else {
            catClock.setIcon(catClockIcon);
        }
        if (activeTasks.contains("PhoneNumberTask")) {
            phone.setIcon(activePhoneIcon);
        } else {
            phone.setIcon(phoneIcon);
        }
        if (activeTasks.contains("AssignmentTask") && !compsList.contains(assignmentButton)) {
            layers.add(assignmentButton, Integer.valueOf(5));
            layers.add(assignmentWarning, Integer.valueOf(5));
        } else if (compsList.contains(assignmentButton)) {
            layers.remove(assignmentButton);
            layers.remove(assignmentWarning);
        }
        if (activeTasks.contains("MemoryTask") && !compsList.contains(memoryButton)) {
            layers.add(memoryButton, Integer.valueOf(5));
            layers.add(memoryWarning, Integer.valueOf(5));
        } else if (compsList.contains(memoryButton)) {
            layers.remove(memoryButton);
            layers.remove(memoryWarning);
        }
        if (activeTasks.contains("WireTask") && !compsList.contains(wire)) {
            layers.add(wire, Integer.valueOf(5));
        } else if (compsList.contains(wire)) {
            layers.remove(wire);
        }
        // Must also add for trivia task, art not yet in resources
    }
}
