package view;

import controller.AssignmentTaskController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignmentTaskView extends JFrame implements ActionListener{
    JLayeredPane layers;
    // IMAGES
    ImageIcon backgroundImage;
    ImageIcon b2;
    ImageIcon b3;
    ImageIcon b4;
    ImageIcon b5;
    ImageIcon b6;
    ImageIcon b7;
    JLabel background;


    JTextField textField;
    private static int countNeeded;
    private int currentCount;
    private int totalCount;
    private int currentProgress;
    public AssignmentTaskView(){
        // use the controller to get the characterCountNeeded
        totalCount = 0;
        currentProgress = 0;
        countNeeded = AssignmentTaskController.getCharacterCountNeeded();
        layers = new JLayeredPane();

        // store images into variables
        backgroundImage = new ImageIcon("src/main/java/resources/AssignmentTask/first.jpg");
        b2 = new ImageIcon("src/main/java/resources/AssignmentTask/second.jpg");
        b3 = new ImageIcon("src/main/java/resources/AssignmentTask/third.jpg");
        b4 = new ImageIcon("src/main/java/resources/AssignmentTask/fourth.jpg");
        b5 = new ImageIcon("src/main/java/resources/AssignmentTask/fifth.jpg");
        b6 = new ImageIcon("src/main/java/resources/AssignmentTask/sixth.jpg");
        b7 = new ImageIcon("src/main/java/resources/AssignmentTask/last.jpg");


        layers.setPreferredSize(new Dimension(1280,720));

        background = new JLabel();
        background.setIcon(backgroundImage);

        // this is for the background picture to cover the whole frame.
        background.setBounds(0,     0, 1280, 720);
        layers.add(background, Integer.valueOf(0));

        // JTextField where there player would type
        textField = new JTextField();
        textField.setBounds(300, 50, 1280, 720);
        textField.addActionListener(this);
        textField.setOpaque(false);
        layers.add(textField);

        add(layers);

        // Display the layered pane
        setSize(1280,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        layers.setVisible(true);

    }
    public static void main(String[] args) {
        new AssignmentTaskView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentCount = textField.getText().length();
        totalCount += Math.min(currentCount, Math.floor((double) countNeeded / 6));

        if (totalCount >= currentProgress * (countNeeded / 6)){
            currentProgress++;
        }

        // changing backgroung pictures to reflect changes
        switch (currentProgress){
            case 6:
                background.setIcon(b7);
                if (AssignmentTaskController.validate(countNeeded)){
                    JOptionPane.showMessageDialog(null, "Congratulations! You Succeeded!");
                    this.setVisible(false);
                }
                break;
            case 5:
                background.setIcon(b6);
                break;
            case 4:
                background.setIcon(b5);
                break;
            case 3:
                background.setIcon(b4);
                break;
            case 2:
                background.setIcon(b3);
                break;
            case 1:
                background.setIcon(b2);
                break;
            default:
                break;
        }

    }
}