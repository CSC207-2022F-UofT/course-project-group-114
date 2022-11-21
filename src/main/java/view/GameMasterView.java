package view;
import controller.GameMasterController;
import controller.HeatAdjustmentTaskController;
import entities.GameMaster;
import entities.PhoneNumberTask;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.Clock;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class GameMasterView extends JFrame{
    public static JPanel main;
    public static JLayeredPane layers;
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

    public GameMasterView() {
        main = new JPanel(new CardLayout());
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

        // Create trivia JLabel
//        triviaIcon = scaleIcon("src\\main\\java\\resources\\GameMaster\\trivia\\wire task prompt.png");

        // Create image icons for activated versions of heat, phone and click tasks
        activeCatClockIcon = scaleIcon("src\\main\\java\\resources\\GameMaster\\clock\\eat alert.gif");
        activePhoneIcon = scaleIcon("src\\main\\java\\resources\\GameMaster\\phone\\phone alert.png");
        activeThermostatIcon = scaleIcon("src\\main\\java\\resources\\GameMaster\\heat\\heat alert.png");

        // Create invisible buttons for each task to click
        clickableAssignment = new JButton();
        clickableAssignment.setOpaque(false);
        clickableAssignment.setContentAreaFilled(false);
        clickableAssignment.setBorderPainted(false);
        clickableAssignment.setBounds(530, 450, 60, 60);

        clickableClick = new JButton();
        clickableClick.setOpaque(false);
        clickableClick.setContentAreaFilled(false);
        clickableClick.setBorderPainted(false);
        clickableClick.setBounds(690, 235, 200, 230);

        clickableHeat = new JButton();
        clickableHeat.setOpaque(false);
        clickableHeat.setContentAreaFilled(false);
        clickableHeat.setBorderPainted(false);
        clickableHeat.setBounds(1050, 0, 230, 70);

        clickableMemory = new JButton();
        clickableMemory.setOpaque(false);
        clickableMemory.setContentAreaFilled(false);
        clickableMemory.setBorderPainted(false);
        clickableMemory.setBounds(40, 450, 182, 70);

        clickablePhone = new JButton();
        clickablePhone.setOpaque(false);
        clickablePhone.setContentAreaFilled(false);
        clickablePhone.setBorderPainted(false);
        clickablePhone.setBounds(1000, 520, 280, 200);

        clickableWire = new JButton();
        clickableWire.setOpaque(false);
        clickableWire.setContentAreaFilled(false);
        clickableWire.setBorderPainted(false);
        clickableWire.setBounds(40, 200, 190, 70);

        // Add click event listeners for clickable buttons to switch to correct view
        AddClickEvents();

        // TODO add trivia task button

        main.add(layers);
        add(main);

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

    // Helper method for activating the given tasks
    private void activateTasks(Set<String> activeTasks) {
        Component[] comps = layers.getComponentsInLayer(5);
        List<Component> compsList = Arrays.asList(comps);
        Component[] alreadyClickable = layers.getComponentsInLayer(6);
        List<Component> alreadyClickableList = Arrays.asList(alreadyClickable);
        if (activeTasks.contains("HeadAdjustmentTask") && !alreadyClickableList.contains(clickableHeat)) {
            thermostat.setIcon(activeThermostatIcon);
            layers.add(clickableHeat, Integer.valueOf(6));
        } else if (alreadyClickableList.contains(clickableHeat)) {
            thermostat.setIcon(thermostatIcon);
            layers.remove(clickableHeat);
        }
        if (activeTasks.contains("ClickTask") && !alreadyClickableList.contains(clickableClick)) {
            catClock.setIcon(activeCatClockIcon);
            layers.add(clickableClick, Integer.valueOf(6));
        } else if (alreadyClickableList.contains(clickableClick)){
            catClock.setIcon(catClockIcon);
            layers.remove(clickableClick);
        }
        if (activeTasks.contains("PhoneNumberTask") && !alreadyClickableList.contains(clickablePhone)) {
            phone.setIcon(activePhoneIcon);
            layers.add(clickablePhone, Integer.valueOf(6));
        } else if (alreadyClickableList.contains(clickablePhone)){
            phone.setIcon(phoneIcon);
            layers.remove(clickablePhone);
        }
        if (activeTasks.contains("AssignmentTask") && !compsList.contains(assignmentButton)) {
            layers.add(assignmentButton, Integer.valueOf(5));
            layers.add(assignmentWarning, Integer.valueOf(5));
            layers.add(clickableAssignment, Integer.valueOf(6));
        } else if (compsList.contains(assignmentButton)) {
            layers.remove(assignmentButton);
            layers.remove(assignmentWarning);
            layers.remove(clickableAssignment);
        }
        if (activeTasks.contains("MemoryTask") && !compsList.contains(memoryButton)) {
            layers.add(memoryButton, Integer.valueOf(5));
            layers.add(memoryWarning, Integer.valueOf(5));
            layers.add(clickableMemory, Integer.valueOf(6));
        } else if (compsList.contains(memoryButton)) {
            layers.remove(memoryButton);
            layers.remove(memoryWarning);
            layers.remove(clickableMemory);
        }
        if (activeTasks.contains("WireTask") && !compsList.contains(wire)) {
            layers.add(wire, Integer.valueOf(5));
            layers.add(clickableWire, Integer.valueOf(6));
        } else if (compsList.contains(wire)) {
            layers.remove(wire);
            layers.remove(clickableWire);
        }
        // Must also add for trivia task, art not yet in resources
    }

    private static void AddClickEvents() {
        clickableAssignment.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                main.add(AssignmentTaskView.layers);
                main.remove(layers);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        clickableClick.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                main.add(ClickTaskView.layers);
                main.remove(layers);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        clickablePhone.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                main.add(PhoneNumberTaskView.layers);
                main.remove(layers);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        clickableWire.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                main.add(WireTaskView.layers);
                main.remove(layers);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        clickableMemory.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                main.add(MemoryTaskView.layers);
                main.remove(layers);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        clickableHeat.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                main.add(HeatAdjustmentTaskView.layers);
                main.remove(layers);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        clickableTrivia.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                main.add(TriviaTaskView.layers);
                main.remove(layers);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }

    public static void backToMain() {
        main.removeAll();
        main.add(layers);
    }
}
