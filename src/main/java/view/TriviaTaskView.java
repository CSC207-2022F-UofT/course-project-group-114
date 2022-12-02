package view;

import controller.TriviaTaskController;
import presenter.TriviaTaskPresenter;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class TriviaTaskView extends JFrame{

    public static JLayeredPane TriviaTaskPanel;

    TriviaTaskView(TriviaTaskController controller, TriviaTaskPresenter presenter){
        //TriviaTaskController TriviaTaskController = new TriviaTaskController();
        //String currentQuestion = "** temporary string placeholder shit till i figure this out **";
        // figured it out on the line right below :)
        String currentQuestion = presenter.tellViewWhatQuestionToShow();
        //String currentQuestion = TriviaTaskController.passRandomQuestion();
        // ^ that line above would have been half "okay" like wouldve functioned
        // but was using a controller to do what the non-existent at the time presenter should've done
        //String actualAnswer = controller.passActualAnswer();
        String actualAnswer = "placeholder";

        JPanel popup = new JPanel();
        JLabel question = new JLabel("You have 10 seconds to answer the question correctly: " + currentQuestion);
        question.setPreferredSize(new Dimension(1280, 80));
        question.setHorizontalAlignment(JLabel.CENTER);
        question.setFont(new Font("Calibri", Font.BOLD, 18));
        popup.add(question);

        TriviaTaskPanel = new JLayeredPane();
        TriviaTaskPanel.setPreferredSize((new Dimension(1280, 720)));

        // image icons -- be sure to add in the correct ones for the trivia task

        // set up the visuals of the submot button


        // setting up for player to input answer
        JTextField playerAnswer = new JTextField();
        playerAnswer.setEditable(true);
        playerAnswer.setHorizontalAlignment(JTextField.CENTER);
        playerAnswer.setFont(new Font("Calibri", Font.BOLD, 20));
        playerAnswer.setForeground(Color.GRAY);
        playerAnswer.setBounds(150, 500, 250, 100);
        playerAnswer.setOpaque(false);
        playerAnswer.setMargin(new Insets(1, 1, 1, 1));

        // submit button functionality shit here








    }

}