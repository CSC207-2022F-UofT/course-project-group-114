package view;
import usecases.TriviaTask;
import controller.TriviaTaskController;
import presenter.TriviaTaskPresenter;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class TriviaTaskView extends JFrame {

    public static JLayeredPane triviaTaskPanel;

    TriviaTaskView(){
        JPanel popup = new JPanel();
        JLabel question = new JLabel("you will have 10 seconds to answer the question");
        question.setPreferredSize(new Dimension(1280, 80));
        question.setHorizontalAlignment(JLabel.CENTER);
        question.setFont(new Font("Cambria", Font.BOLD, 16));
        popup.add(question);

        triviaTaskPanel = new JLayeredPane();
        triviaTaskPanel.setPreferredSize(new Dimension(1280, 720));

        //replace these with trivia art
        ImageIcon backgroundPng = new ImageIcon("src/main/java/resources/Background.png");
        JLabel triviaBackground = new JLabel(backgroundPng);
        //triviaBackground.setPreferredSize()

        // setting up the submit button. replace with trivia submit button
        ImageIcon submit = new ImageIcon();
        JButton submitButton = new JButton(submit);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        submitButton.setBounds(200, 580, submit.getIconWidth(), submit.getIconHeight());

        // setting up playerAnswer input
        JTextField playerAnswer = new JTextField();
        playerAnswer.setEditable(true);
        playerAnswer.setHorizontalAlignment(JTextField.CENTER);
        playerAnswer.setFont(new Font("Cambria", Font.BOLD, 16));
        playerAnswer.setForeground(Color.GRAY);
        playerAnswer.setBounds(120, 476, 268, 62);
        playerAnswer.setOpaque(false);
        playerAnswer.setMargin(new Insets(1, 1, 1, 1));

        setPreferredSize(new Dimension(1280, 720));
        setVisible(true);

        add(triviaTaskPanel);
        triviaTaskPanel.setVisible(true);
        popup.setVisible(true);

        // add the submit button
//        submitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//
//            }
//        };){

    }



}
