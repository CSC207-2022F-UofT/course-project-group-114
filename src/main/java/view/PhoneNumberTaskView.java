package view;

import presenter.PhoneNumberTaskPresenter;
import controller.PhoneNumberTaskController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * The View class for the Phone Number Task which creates a JLayeredPane that
 * displays all components needed for the Phone Number Task.
 * @author Kaavya
 * @inheritDoc JLayeredPane
 */
public class PhoneNumberTaskView extends JLayeredPane{

    Random rand = new Random();
    private final int actualNumber = rand.nextInt((999999999-100000000) + 1) + 100000000;

    private String numberSoFar = "";

    /**
     * The constructor for the PhoneNumberTaskView which creates and places all the
     * required components on the JLayeredPane and has event listeners which keep track
     * of the actions and pass information to the controller when needed.
     */
    PhoneNumberTaskView(){
        PhoneNumberTaskController controller = new PhoneNumberTaskController();
        PhoneNumberTaskPresenter presenter = new PhoneNumberTaskPresenter();

        setPreferredSize(new Dimension(1280, 720));

        JTextField textField = new JTextField("TO DO : DIAL THE NUMBER ON THE STICKY NOTE");
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setFont(new java.awt.Font("Serif", Font.ITALIC | Font.BOLD, 28));
        textField.setForeground(Color.BLACK);
        textField.setBounds(0, 0, 1280, 80);
        textField.setOpaque(false);
        textField.setBorder(null);
        textField.setMargin(new Insets(0, 0, 0, 0));

        JTextField number = new JTextField(String.valueOf(actualNumber));
        number.setEditable(false);
        number.setHorizontalAlignment(JTextField.CENTER);
        number.setFont(new java.awt.Font("Serif", Font.ITALIC | Font.BOLD, 28));
        number.setForeground(Color.BLACK);
        number.setBounds(880, 130, 150, 80);
        number.setOpaque(false);
        number.setBorder(null);
        number.setMargin(new Insets(0, 0, 0, 0));

        ImageIcon bg = new ImageIcon("src/main/java/resources/PhoneNumberTask/bg.jpg");
        JLabel background = new JLabel(bg);
        background.setPreferredSize(new Dimension(1280,720));
        background.setBounds(0,     0, 1280, 720);

        ImageIcon zero = new ImageIcon("src/main/java/resources/PhoneNumberTask/0.png");
        JButton zeroButton = new JButton(zero);
        zeroButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        zeroButton.setBounds(700, 625, zero.getIconWidth(), zero.getIconHeight());

        ImageIcon one = new ImageIcon("src/main/java/resources/PhoneNumberTask/1.png");
        JButton oneButton = new JButton(one);
        oneButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        oneButton.setBounds(600, 380, one.getIconWidth(), one.getIconHeight());

        ImageIcon two = new ImageIcon("src/main/java/resources/PhoneNumberTask/2.png");
        JButton twoButton = new JButton(two);
        twoButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        twoButton.setBounds(700, 380, two.getIconWidth(), two.getIconHeight());

        ImageIcon three = new ImageIcon("src/main/java/resources/PhoneNumberTask/3.png");
        JButton threeButton = new JButton(three);
        threeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        threeButton.setBounds(800, 380, three.getIconWidth(), three.getIconHeight());

        ImageIcon four = new ImageIcon("src/main/java/resources/PhoneNumberTask/4.png");
        JButton fourButton = new JButton(four);
        fourButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        fourButton.setBounds(600, 460, four.getIconWidth(), four.getIconHeight());

        ImageIcon five = new ImageIcon("src/main/java/resources/PhoneNumberTask/5.png");
        JButton fiveButton = new JButton(five);
        fiveButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        fiveButton.setBounds(700, 460, five.getIconWidth(), five.getIconHeight());

        ImageIcon six = new ImageIcon("src/main/java/resources/PhoneNumberTask/6.png");
        JButton sixButton = new JButton(six);
        sixButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        sixButton.setBounds(800, 460, six.getIconWidth(), six.getIconHeight());

        ImageIcon seven = new ImageIcon("src/main/java/resources/PhoneNumberTask/7.png");
        JButton sevenButton = new JButton(seven);
        sevenButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        sevenButton.setBounds(600, 540, seven.getIconWidth(), seven.getIconHeight());

        ImageIcon eight = new ImageIcon("src/main/java/resources/PhoneNumberTask/8.png");
        JButton eightButton = new JButton(eight);
        eightButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        eightButton.setBounds(700, 540, eight.getIconWidth(), eight.getIconHeight());

        ImageIcon nine = new ImageIcon("src/main/java/resources/PhoneNumberTask/9.png");
        JButton nineButton = new JButton(nine);
        nineButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        nineButton.setBounds(800, 540, nine.getIconWidth(), nine.getIconHeight());

        ImageIcon dial = new ImageIcon("src/main/java/resources/PhoneNumberTask/dial.png");
        JButton dialButton = new JButton(dial);
        dialButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        dialButton.setBounds(800, 640, dial.getIconWidth(), dial.getIconHeight());

        JTextField numberTyped = new JTextField();
        numberTyped.setEditable(false);
        numberTyped.setHorizontalAlignment(JTextField.LEFT);
        numberTyped.setFont(new java.awt.Font("Serif", Font.BOLD, 32));
        numberTyped.setForeground(Color.BLACK);
        numberTyped.setBounds(570, 200, 268, 62);
        numberTyped.setOpaque(false);
        numberTyped.setMargin(new Insets(0, 0, 0, 0));
        numberTyped.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        numberTyped.setText(numberSoFar);

        add(background, Integer.valueOf(0));
        add(zeroButton, Integer.valueOf(1));
        add(oneButton, Integer.valueOf(2));
        add(twoButton, Integer.valueOf(3));
        add(threeButton, Integer.valueOf(4));
        add(fourButton, Integer.valueOf(5));
        add(fiveButton, Integer.valueOf(6));
        add(sixButton, Integer.valueOf(7));
        add(sevenButton, Integer.valueOf(8));
        add(eightButton, Integer.valueOf(9));
        add(nineButton, Integer.valueOf(10));
        add(dialButton, Integer.valueOf(11));
        add(textField, Integer.valueOf(12));
        add(number, Integer.valueOf(13));
        add(numberTyped, Integer.valueOf(14));

        setVisible(true);

        oneButton.addActionListener(new ActionListener() {
            /**
             * Invoked when oneButton is pressed.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                checkIfTimeRanOut();
                numberSoFar += "1";
                numberTyped.setText(numberSoFar);
                return null;
            }
        });

        twoButton.addActionListener(new ActionListener() {
            /**
             * Invoked when twoButton is pressed.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                checkIfTimeRanOut();
                numberSoFar += "2";
                numberTyped.setText(numberSoFar);
                return null;
            }
        });

        threeButton.addActionListener(new ActionListener() {
            /**
             * Invoked when threeButton is pressed.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                checkIfTimeRanOut();
                numberSoFar += "3";
                numberTyped.setText(numberSoFar);
                return null;
            }
        });

        fourButton.addActionListener(new ActionListener() {
            /**
             * Invoked when fourButton is pressed.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                checkIfTimeRanOut();
                numberSoFar += "4";
                numberTyped.setText(numberSoFar);
                return null;
            }
        });

        fiveButton.addActionListener(new ActionListener() {
            /**
             * Invoked when fiveButton is pressed.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                checkIfTimeRanOut();
                numberSoFar += "5";
                numberTyped.setText(numberSoFar);
                return null;
            }
        });

        sixButton.addActionListener(new ActionListener() {
            /**
             * Invoked when sixButton is pressed.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                checkIfTimeRanOut();
                numberSoFar += "6";
                numberTyped.setText(numberSoFar);
                return null;
            }
        });

        sevenButton.addActionListener(new ActionListener() {
            /**
             * Invoked when sevenButton is pressed.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                checkIfTimeRanOut();
                numberSoFar += "7";
                numberTyped.setText(numberSoFar);
                return null;
            }
        });

        eightButton.addActionListener(new ActionListener() {
            /**
             * Invoked when eightButton is pressed.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                checkIfTimeRanOut();
                numberSoFar += "8";
                numberTyped.setText(numberSoFar);
                return null;
            }
        });

        nineButton.addActionListener(new ActionListener() {
            /**
             * Invoked when nineButton is pressed.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                checkIfTimeRanOut();
                numberSoFar += "9";
                numberTyped.setText(numberSoFar);
                return null;
            }
        });

        zeroButton.addActionListener(new ActionListener() {
            /**
             * Invoked when zeroButton is pressed.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                checkIfTimeRanOut();
                numberSoFar += "0";
                numberTyped.setText(numberSoFar);
                return null;
            }
        });

        dialButton.addActionListener(new ActionListener() {
            /**
             * Invoked when dialButton is pressed.
             *
             * @param e the event to be processed
             */

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.passer(actualNumber, numberSoFar);
                String status = presenter.correctnessStatus();
                JOptionPane.showMessageDialog(null, status);
                setVisible(false);
                PhoneNumberTaskController.setActivatedStatus(false);
                GameMasterView.backToMain(GameMasterView.phoneTaskView);
                return status;
            }
        });

    }
    public static void main(String[] args) {
        new PhoneNumberTaskView();
    }

    /**
     * Checks if the time has run out by checking if the task
     * is deactivated and returns to the GameMasterView
     * if it has
     */
    private static void checkIfTimeRanOut() {
        if (!PhoneNumberTaskController.getActivatedStatus()) {
            GameMasterView.backToMain(GameMasterView.phoneTaskView);
        }
    }
}

