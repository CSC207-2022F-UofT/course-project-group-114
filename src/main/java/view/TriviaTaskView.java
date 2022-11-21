package view;

import controller.TriviaTaskController;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class TriviaTaskView extends JFrame {
    TriviaTaskView(){

        TriviaTaskController controller = new TriviaTaskController();
        String currentQuestion = controller.passRandomQuestion();

        JPanel questionPopup = new JPanel();
        JLabel questionMessage = new JLabel("You have 10 seconds to answer the following question correctly: " + currentQuestion);
//        questionMessage.setPreferredSize(500, 500);
//        questionMessage.setHoriziontalAlignment(JLabel.CENTER);

    }

    // ignore this for now. can be added later once trivia is up and running
//    public JPanel chooseCategoryPopup;
//    public JButton submitAnswerButton;
//
//    TriviaTaskController controller = new TriviaTaskController();
////    String currentQuestion = "abc";     // this is where the current question will be randomly selected and displayed
//
//    // have the user choose a category
//    chooseCategoryPopup = newJPanel();
//    Jlabel chooseMessage = new JLabel("Choose a category");
//    chooseMessage.setPreferredSize(new Dimension(1200, 100));
//    chooseMessage.setHorizontalAlignment(JLabel.CENTER);
//    chooseMessage.setFont(new java.awt.Font("Serif", Font.BOLD, 24));
//    chooseCategoryPopup.add(chooseMessage);


    // display the question & answer box and give player time to answer

    // the playerAnswer is the answer that the player has submitted. controller will have to relay this to the view

}
