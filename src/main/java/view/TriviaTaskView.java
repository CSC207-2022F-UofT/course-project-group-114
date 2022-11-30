package view;

import controller.TriviaTaskController;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class TriviaTaskView extends JFrame {

    public static JLayeredPane TriviaTaskPanel;

    TriviaTaskView() {

        TriviaTaskController controller = new TriviaTaskController();
        String currentQuestion = controller.passRandomQuestion();
        String actualAnswer = controller.passActualAnswer();

        JPanel popup = new JPanel();
       // JLabel question = new JLabel("You have 10 seconds to answer the following question correctly: " + currentQuestion);
//        question.setPreferredSize(new Dimension(1280, 80));
//        question.setHorizontalAlignment(JLabel.CENTER);
//        question.setFont(new Font("Calibri", Font.BOLD, 18));
//        popup.add(question);

        TriviaTaskPanel = new JLayeredPane();
        TriviaTaskPanel.setPreferredSize(new Dimension(1280, 720));

        //replace these next two ImageIcons with TriviaTask art
//        ImageIcon backgroundImage = new ImageIcon("src\\main\\java\\resources\\MemoryTask\\bg.jpg");
//        JLabel triviaBackground = new JLabel(backgroundImage);
//        triviaBackground.setPreferredSize(new Dimension(1280, 720));
//        triviaBackground.setBounds(0, 0, 1280, 720);

        // setting up submit button
        ImageIcon submit = new ImageIcon("src\\main\\java\\resources\\MemoryTask\\login.png");
        JButton submitButton = new JButton(submit);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        submitButton.setBounds(200, 580, submit.getIconWidth(), submit.getIconHeight());

        // setting up player input for their answer.
        // will be sent into the controller to be sent to backend to be checked
        // mvc model
        JTextField playerAnswer = new JTextField();
        playerAnswer.setEditable(true);
        playerAnswer.setHorizontalAlignment(JTextField.CENTER);
        playerAnswer.setFont(new Font("Calibri", Font.BOLD, 20));
        playerAnswer.setForeground(Color.GRAY);
        playerAnswer.setBounds(150, 500, 250, 100);
        playerAnswer.setOpaque(false);
        playerAnswer.setMargin(new Insets(1, 1, 1, 1));


//        TriviaTaskPanel.add(triviaBackground, Integer.valueOf(0));
//        TriviaTaskPanel.add(submitButton, Integer.valueOf(1));
//        TriviaTaskPanel.add(question, Integer.valueOf(2));

        setPreferredSize(new Dimension(1280, 720));
        setVisible(true);

        add(TriviaTaskPanel);
        TriviaTaskPanel.setVisible(true);
        popup.setVisible(true);

        // add submit button here
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean correct = controller.passAnswer(actualAnswer, playerAnswer);
                if(correct){
                    JOptionPane.showMessageDialog(null, "Correct");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect");
                }
                setVisible(false);
                GameMasterView.backToMain(GameMasterView.triviaTaskView);
            }
        });
        {

        }
    }
}
