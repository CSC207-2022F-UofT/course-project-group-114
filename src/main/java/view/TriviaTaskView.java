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

        JPanel popup = new JPanel();
        JLabel question = new JLabel("You have 10 seconds to answer the following question correctly: " + currentQuestion);
        question.setPreferredSize(new Dimension(1280, 80));
        question.setHorizontalAlignment(JLabel.CENTER);
        question.setFont(new Font("Calibri", Font.BOLD, 18));
        popup.add(question);
//        questionMessage.setPreferredSize(500, 500);
//        questionMessage.setHoriziontalAlignment(JLabel.CENTER);

        TriviaTaskPanel = new JLayeredPane();
        TriviaTaskPanel.setPreferredSize(new Dimension(1280, 720));

            // setting up submit button
        ImageIcon submit = new ImageIcon("src\\main\\java\\resources\\MemoryTask\\login.png");
        JButton submitButton = new JButton(submit);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        submitButton.setBounds(200, 580, submit.getIconWidth(), submit.getIconHeight());

        // setting up player input for their answer
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


        setPreferredSize(new Dimension(1280, 720));
        setVisible(true);

//        javax.swing.Timer timer = new Timer(5000, null);
//        timer.setRepeats(false);
//        timer.start();
//        add(popup);
//        while(timer.isRunning()){
//            popup.setVisible(true);
//            // set the triviaTaskPanel visible to True
//        }
//        timer.stop();
        add(TriviaTaskPanel);
        TriviaTaskPanel.setVisible(true);
        popup.setVisible(true);

        // add submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // pass the playerAnswer to the controller
                //boolean correct = controller.passAnswer(playerAnswer);
                // if it is correct
                // show a message that the answer is correct

                // if not, show message that answer is incorrect

            setVisible(false);
            GameMasterView.backToMain(GameMasterView.triviaTaskView);
            }
        });
        {

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
}
