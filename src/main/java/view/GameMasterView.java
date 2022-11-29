package view;
import controller.GameMasterController;
import entities.GameMaster;
import entities.HeatAdjustmentTask;
import entities.LifeMaster;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.Clock;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.TimerTask;
import java.util.Timer;

public class GameMasterView extends JFrame{
    public static JPanel main;
    public static JLayeredPane layers;
    ImageIcon backgroundIcon;
    JLabel background;
    JLabel scoreDisplay;
    JLabel livesDisplay;
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
    ImageIcon triviaIcon;
    JLabel trivia;

    // Buttons for each task
    static JButton clickableHeat;
    static JButton clickableClick;
    static JButton clickableMemory;
    static JButton clickableTrivia;
    static JButton clickableWire;
    static JButton clickableAssignment;
    static JButton clickablePhone;

    // JPanels representing task views
    public static JLayeredPane assignmentTaskView;
    public static JLayeredPane clickTaskView;
    public static JLayeredPane phoneTaskView;
    public static JLayeredPane memoryTaskView;
    public static JLayeredPane wireTaskView;
    public static JLayeredPane heatTaskView;
    public static JLayeredPane triviaTaskView;

    public GameMasterView() {
        main = new JPanel(new CardLayout());
        layers = new JLayeredPane();

        scoreDisplay = new JLabel("0");
        scoreDisplay.setBounds(780, 270, 200, 250);
        scoreDisplay.setForeground(new Color(200, 255, 255));
        scoreDisplay.setFont(new Font("Comic Sans MS", Font.BOLD, 30));

        livesDisplay = new JLabel((Integer.toString(LifeMaster.getLives())));
        livesDisplay.setBounds(360, 0, 200, 100);
        livesDisplay.setForeground(new Color(200, 255, 255));
        livesDisplay.setFont(new Font("Comic Sans MS", Font.BOLD, 30));

        // Create background JLabel
        backgroundIcon = scaleIcon("src/main/java/resources/GameMaster/background.jpg");
        background = new JLabel();
        background.setBounds(0, 0, 1280, 720);
        background.setIcon(backgroundIcon);

        // Create cat clock JLabel
        catClockIcon = new ImageIcon("src/main/java/resources/GameMaster/clock/catclock.gif");
        catClock = new JLabel();
        catClock.setBounds(0, 0, 1280, 720);
        catClock.setIcon(catClockIcon);

        // Create thermostat JLabel
        thermostatIcon = scaleIcon("src/main/java/resources/GameMaster/heat/heat neutral.png");
        thermostat = new JLabel();
        thermostat.setBounds(0, 0, 1280, 720);
        thermostat.setIcon(thermostatIcon);

        // Create phone JLabel
        phoneIcon = scaleIcon("src/main/java/resources/GameMaster/phone/phone neutral.png");
        phone = new JLabel();
        phone.setBounds(0, 0, 1280, 720);
        phone.setIcon(phoneIcon);

        // Create screen JLabel
        screenIcon = scaleIcon("src/main/java/resources/GameMaster/screen/screen neutral.png");
        screen = new JLabel();
        screen.setBounds(0, 0, 1280, 720);
        screen.setIcon(screenIcon);

        // Add all neutral elements to the JLayeredPane
        layers.add(background, Integer.valueOf(0));
        layers.add(catClock, Integer.valueOf(1));
        layers.add(thermostat, Integer.valueOf(2));
        layers.add(phone, Integer.valueOf(3));
        layers.add(screen, Integer.valueOf(4));
        layers.add(scoreDisplay, Integer.valueOf(4));
        layers.add(livesDisplay, Integer.valueOf(4));
        layers.setPreferredSize(new Dimension(1280, 720));

        // Create the non-neutral JLabels; that is, the ones that are not visible at the start of the game
        // Create assignment button JLabel
        assignmentButtonIcon = scaleIcon("src/main/java/resources/GameMaster/screen/assignment task button.png");
        assignmentButton = new JLabel();
        assignmentButton.setBounds(0, 0, 1280, 720);
        assignmentButton.setIcon(assignmentButtonIcon);
        assignmentButton.setVisible(false);

        // Create assignment warning JLabel
        assignmentWarningIcon = scaleIcon("src/main/java/resources/GameMaster/screen/assignment task warning.png");
        assignmentWarning = new JLabel();
        assignmentWarning.setBounds(0, 0, 1280, 720);
        assignmentWarning.setIcon(assignmentWarningIcon);
        assignmentWarning.setVisible(false);

        // Create memory warning JLabel
        memoryWarningIcon = scaleIcon("src/main/java/resources/GameMaster/screen/memory task warning.png");
        memoryWarning = new JLabel();
        memoryWarning.setBounds(0, 0, 1280, 720);
        memoryWarning.setIcon(memoryWarningIcon);
        memoryWarning.setVisible(false);

        // Create memory button JLabel
        memoryButtonIcon = scaleIcon("src/main/java/resources/GameMaster/screen/memory task prompt.png");
        memoryButton = new JLabel();
        memoryButton.setBounds(0, 0, 1280, 720);
        memoryButton.setIcon(memoryButtonIcon);
        memoryButton.setVisible(false);

        // Create wire JLabel
        wireIcon = scaleIcon("src/main/java/resources/GameMaster/screen/wire task prompt.png");
        wire = new JLabel();
        wire.setBounds(0, 0, 1280, 720);
        wire.setIcon(wireIcon);
        wire.setVisible(false);

        // Create trivia JLabel
        triviaIcon = scaleIcon("src/main/java/resources/GameMaster/trivia/trivia task alert.png");
        trivia = new JLabel();
        trivia.setBounds(0, 0, 1280, 720);
        trivia.setIcon(triviaIcon);
        trivia.setVisible(false);

        // Create image icons for activated versions of heat, phone and click tasks
        activeCatClockIcon = new ImageIcon("src/main/java/resources/GameMaster/clock/eat alert.gif");
        activePhoneIcon = scaleIcon("src/main/java/resources/GameMaster/phone/phone alert.png");
        activeThermostatIcon = scaleIcon("src/main/java/resources/GameMaster/heat/heat alert.png");

        // Create invisible buttons for each task to click
        clickableAssignment = new JButton();
        clickableAssignment.setVisible(false);
        clickableAssignment.setOpaque(false);
        clickableAssignment.setContentAreaFilled(false);
        clickableAssignment.setBorderPainted(false);
        clickableAssignment.setBounds(530, 450, 60, 60);

        clickableClick = new JButton();
        clickableClick.setVisible(false);
        clickableClick.setOpaque(false);
        clickableClick.setContentAreaFilled(false);
        clickableClick.setBorderPainted(false);
        clickableClick.setBounds(690, 235, 200, 230);

        clickableHeat = new JButton();
        clickableHeat.setVisible(false);
        clickableHeat.setOpaque(false);
        clickableHeat.setContentAreaFilled(false);
        clickableHeat.setBorderPainted(false);
        clickableHeat.setBounds(1050, 0, 230, 70);

        clickableMemory = new JButton();
        clickableMemory.setVisible(false);
        clickableMemory.setOpaque(false);
        clickableMemory.setContentAreaFilled(false);
        clickableMemory.setBorderPainted(false);
        clickableMemory.setBounds(40, 450, 182, 70);

        clickablePhone = new JButton();
        clickablePhone.setVisible(false);
        clickablePhone.setOpaque(false);
        clickablePhone.setContentAreaFilled(false);
        clickablePhone.setBorderPainted(false);
        clickablePhone.setBounds(1000, 520, 280, 200);

        clickableWire = new JButton();
        clickableWire.setVisible(false);
        clickableWire.setOpaque(false);
        clickableWire.setContentAreaFilled(false);
        clickableWire.setBorderPainted(false);
        clickableWire.setBounds(40, 200, 190, 70);

        clickableTrivia = new JButton();
        clickableTrivia.setVisible(false);
        clickableTrivia.setOpaque(false);
        clickableTrivia.setContentAreaFilled(false);
        clickableTrivia.setBorderPainted(false);
        clickableTrivia.setBounds(42, 295, 170, 65);

        // Add buttons which are initially invisible to JLayeredPane
        layers.add(assignmentButton, Integer.valueOf(5));
        layers.add(assignmentWarning, Integer.valueOf(5));
        layers.add(memoryButton, Integer.valueOf(5));
        layers.add(memoryWarning, Integer.valueOf(5));
        layers.add(trivia, Integer.valueOf(5));
        layers.add(wire, Integer.valueOf(5));
        layers.add(clickableHeat, Integer.valueOf(6));
        layers.add(clickableAssignment, Integer.valueOf(6));
        layers.add(clickablePhone, Integer.valueOf(6));
        layers.add(clickableTrivia, Integer.valueOf(6));
        layers.add(clickableWire, Integer.valueOf(6));
        layers.add(clickableMemory, Integer.valueOf(6));
        layers.add(clickableClick, Integer.valueOf(6));

        main.add(layers);
        add(main);

        // Add click event listeners for clickable buttons to switch to correct view
        clickableAssignment.addActionListener(e -> {
            assignmentTaskView = new AssignmentTaskView();
            main.add(assignmentTaskView);
            assignmentTaskView.setVisible(true);
            layers.setVisible(false);
        });
        clickableClick.addActionListener(e -> {
            clickTaskView = new ClickTaskView();
            main.add(clickTaskView);
            clickTaskView.setVisible(true);
            layers.setVisible(false);
        });
        clickablePhone.addActionListener(e -> {
            phoneTaskView = new PhoneNumberTaskView();
            main.add(phoneTaskView);
            phoneTaskView.setVisible(true);
            layers.setVisible(false);
        });
        clickableWire.addActionListener(e -> {
            //wireTaskView = new WireTaskView();
//                main.add(wireTaskView);
            JOptionPane.showMessageDialog(null, "i should pop up");

        });
        clickableMemory.addActionListener(e -> {
            memoryTaskView = new MemoryTaskView();
            main.add(memoryTaskView);
            memoryTaskView.setVisible(true);
            layers.setVisible(false);
        });
        clickableHeat.addActionListener(e -> {
            heatTaskView = new HeatAdjustmentTaskView();
            main.add(heatTaskView);
            heatTaskView.setVisible(true);
            layers.setVisible(false);
        });
        clickableTrivia.addActionListener(e -> {
//                triviaTaskView = new TriviaTaskView();
//                main.add(triviaTaskView);
            JOptionPane.showMessageDialog(null, "i should pop up");

        });

        setSize(1280,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        layers.setVisible(true);

        // Check for every task activation or de-activation
        Timer timer = new Timer();
        Clock clock = Clock.systemDefaultZone();
//        long currTime = clock.millis();
        int taskInterval = GameMaster.getTaskInterval(); // Interval for creating tasks
//        GameMasterController.createNewTask(currTime);
        @SuppressWarnings("unchecked")
        final Hashtable<String, Long>[] times = new Hashtable[1];
        times[0] = GameMaster.getTimes();
        @SuppressWarnings("unchecked")
        final Set<String>[] activeTasks = new Set[]{times[0].keySet()};
//        activateTasks(activeTasks[0]);

        TimerTask gameLoop = new TimerTask() {
            long currTime = clock.millis();
            long checkTime = currTime + taskInterval;
            @Override
            public void run() {
                currTime = clock.millis();
                if (clock.millis() >= checkTime) { // Create new task if interval has passed
                    checkTime = clock.millis() + taskInterval; // Update current time
                    GameMasterController.createNewTask(currTime);
                    System.out.println("Task created");
                }
                GameMasterController.checkTasksCompletion(currTime); // Check for tasks completion
                times[0] = GameMasterController.getTimes();
                activeTasks[0] = times[0].keySet();
//                System.out.println(Arrays.toString(activeTasks));
                activateTasks(activeTasks[0]);
                scoreDisplay.setText(Integer.toString(GameMasterController.getScore()));
                livesDisplay.setText(Integer.toString(LifeMaster.getLives()));
            }
        };

        timer.schedule(gameLoop, 50, 1000);
        if (!GameMasterController.getPlayingStatus()) {
            gameLoop.cancel();
        }
    }

    // Helper method for rescaling an ImageIcon
    private ImageIcon scaleIcon(String iconSource) {
        ImageIcon icon = new ImageIcon(iconSource);
        return new ImageIcon(icon.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH));
    }

    // Helper method for activating the given tasks
    private void activateTasks(Set<String> activeTasks) {
        if (activeTasks.contains("HeatAdjustmentTask")) {
            thermostat.setIcon(activeThermostatIcon);
            clickableHeat.setVisible(true);
        } else {
            thermostat.setIcon(thermostatIcon);
            clickableHeat.setVisible(false);
        }
        if (activeTasks.contains("ClickTask")) {
            catClock.setIcon(activeCatClockIcon);
            clickableClick.setVisible(true);
        } else {
            catClock.setIcon(catClockIcon);
            clickableClick.setVisible(false);
        }
        if (activeTasks.contains("PhoneNumberTask")) {
            phone.setIcon(activePhoneIcon);
            clickablePhone.setVisible(true);
        } else {
            phone.setIcon(phoneIcon);
            clickablePhone.setVisible(false);
        }
        if (activeTasks.contains("AssignmentTask")) {
            assignmentButton.setVisible(true);
            assignmentWarning.setVisible(true);
            clickableAssignment.setVisible(true);
        } else {
            assignmentButton.setVisible(false);
            assignmentWarning.setVisible(false);
            clickableAssignment.setVisible(false);
        }
        if (activeTasks.contains("MemoryTask")) {
            memoryButton.setVisible(true);
            memoryWarning.setVisible(true);
            clickableMemory.setVisible(true);
        } else {
            memoryButton.setVisible(false);
            memoryWarning.setVisible(false);
            clickableMemory.setVisible(false);
        }
        if (activeTasks.contains("WireTask")) {
            wire.setVisible(true);
            clickableWire.setVisible(true);
        } else {
            wire.setVisible(false);
            clickableWire.setVisible(false);
        }
        if (activeTasks.contains("TriviaTask")) {
            trivia.setVisible(true);
            clickableTrivia.setVisible(true);
        } else {
            trivia.setVisible(false);
            clickableTrivia.setVisible(false);
        }
    }
    // TODO delete main method
    public static void main(String[] args) {
        new GameMasterView();
    }

    public static void backToMain(JLayeredPane taskToRemove) {
        layers.setVisible(true);
        taskToRemove.setVisible(false);
    }
}
