package view;

import controller.PhoneNumberTaskController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PhoneNumberTaskView extends JLayeredPane{

    Random rand = new Random();
    private final int actual_number = rand.nextInt((999999999-100000000) + 1) + 100000000;

    private String number_so_far = "";

    PhoneNumberTaskView(){
        PhoneNumberTaskController controller = new PhoneNumberTaskController();

        //private JPanel main;
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

        JTextField number = new JTextField(String.valueOf(actual_number));
        number.setEditable(false);
        number.setHorizontalAlignment(JTextField.CENTER);
        number.setFont(new java.awt.Font("Serif", Font.ITALIC | Font.BOLD, 28));
        number.setForeground(Color.BLACK);
        number.setBounds(880, 130, 150, 80);
        number.setOpaque(false);
        number.setBorder(null);
        number.setMargin(new Insets(0, 0, 0, 0));

        ImageIcon bg = new ImageIcon("src\\main\\java\\resources\\PhoneNumberTask\\bg.jpg");
        JLabel background = new JLabel(bg);
        background.setPreferredSize(new Dimension(1280,720));
        background.setBounds(0,     0, 1280, 720);

        ImageIcon zero = new ImageIcon("src\\main\\java\\resources\\PhoneNumberTask\\0.png");
        JButton zero_button = new JButton(zero);
        zero_button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        zero_button.setBounds(700, 625, zero.getIconWidth(), zero.getIconHeight());

        ImageIcon one = new ImageIcon("src\\main\\java\\resources\\PhoneNumberTask\\1.png");
        JButton one_button = new JButton(one);
        one_button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        one_button.setBounds(600, 380, one.getIconWidth(), one.getIconHeight());

        ImageIcon two = new ImageIcon("src\\main\\java\\resources\\PhoneNumberTask\\2.png");
        JButton two_button = new JButton(two);
        two_button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        two_button.setBounds(700, 380, two.getIconWidth(), two.getIconHeight());

        ImageIcon three = new ImageIcon("src\\main\\java\\resources\\PhoneNumberTask\\3.png");
        JButton three_button = new JButton(three);
        three_button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        three_button.setBounds(800, 380, three.getIconWidth(), three.getIconHeight());

        ImageIcon four = new ImageIcon("src\\main\\java\\resources\\PhoneNumberTask\\4.png");
        JButton four_button = new JButton(four);
        four_button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        four_button.setBounds(600, 460, four.getIconWidth(), four.getIconHeight());

        ImageIcon five = new ImageIcon("src\\main\\java\\resources\\PhoneNumberTask\\5.png");
        JButton five_button = new JButton(five);
        five_button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        five_button.setBounds(700, 460, five.getIconWidth(), five.getIconHeight());

        ImageIcon six = new ImageIcon("src\\main\\java\\resources\\PhoneNumberTask\\6.png");
        JButton six_button = new JButton(six);
        six_button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        six_button.setBounds(800, 460, six.getIconWidth(), six.getIconHeight());

        ImageIcon seven = new ImageIcon("src\\main\\java\\resources\\PhoneNumberTask\\7.png");
        JButton seven_button = new JButton(seven);
        seven_button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        seven_button.setBounds(600, 540, seven.getIconWidth(), seven.getIconHeight());

        ImageIcon eight = new ImageIcon("src\\main\\java\\resources\\PhoneNumberTask\\8.png");
        JButton eight_button = new JButton(eight);
        eight_button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        eight_button.setBounds(700, 540, eight.getIconWidth(), eight.getIconHeight());

        ImageIcon nine = new ImageIcon("src\\main\\java\\resources\\PhoneNumberTask\\9.png");
        JButton nine_button = new JButton(nine);
        nine_button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        nine_button.setBounds(800, 540, nine.getIconWidth(), nine.getIconHeight());

        ImageIcon dial = new ImageIcon("src\\main\\java\\resources\\PhoneNumberTask\\dial.png");
        JButton dial_button = new JButton(dial);
        dial_button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        dial_button.setBounds(800, 640, dial.getIconWidth(), dial.getIconHeight());

        add(background, Integer.valueOf(0));
        add(zero_button, Integer.valueOf(1));
        add(one_button, Integer.valueOf(2));
        add(two_button, Integer.valueOf(3));
        add(three_button, Integer.valueOf(4));
        add(four_button, Integer.valueOf(5));
        add(five_button, Integer.valueOf(6));
        add(six_button, Integer.valueOf(7));
        add(seven_button, Integer.valueOf(8));
        add(eight_button, Integer.valueOf(9));
        add(nine_button, Integer.valueOf(10));
        add(dial_button, Integer.valueOf(11));
        add(textField, Integer.valueOf(12));
        add(number, Integer.valueOf(13));

        setVisible(true);

        one_button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // write what you want to do once the button is pressed
                number_so_far += "1";
            }
        });

        two_button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                number_so_far += "2";
            }
        });

        three_button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                number_so_far += "3";
            }
        });

        four_button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                number_so_far += "4";
            }
        });

        five_button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                number_so_far += "5";
            }
        });

        six_button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                number_so_far += "6";
            }
        });

        seven_button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                number_so_far += "7";
            }
        });

        eight_button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                number_so_far += "8";
            }
        });

        nine_button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                number_so_far += "9";
            }
        });

        zero_button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                number_so_far += "0";
            }
        });

        dial_button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean success = controller.passer(actual_number, number_so_far);
                if(success){
                    JOptionPane.showMessageDialog(null, "Correct");

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect");
                }
                setVisible(false);
                GameMasterView.backToMain(GameMasterView.phoneTaskView);
            }
        });

    }
    public static void main(String[] args) {
        new PhoneNumberTaskView();
    }
}
