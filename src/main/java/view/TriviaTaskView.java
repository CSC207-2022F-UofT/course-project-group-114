package view;
import controller.TriviaTaskController;
import presenter.TriviaTaskPresenter;
import javax.swing.*;
import java.awt.*;


/**
 * Class representing the TriviaTask View. Responsible for displaying the trivia background, random question, and
 * submit button.
 * @author talia
 */

public class TriviaTaskView extends JLayeredPane {
    /**
     * Constructor for the TriviaTask view.
     * Creates and places all the necessary pieces for the view on the JLayeredPane
     * Has event listener submit button to pass information (the player's answer) back to the controller.
     * @author talia
     */

    TriviaTaskView(){
        // adding in the background
        ImageIcon backgroundPng = new ImageIcon("src/main/java/resources/triviaart.png");
        JLabel triviaBackground = new JLabel(backgroundPng);
        triviaBackground.setPreferredSize(new Dimension(1280,720));
        triviaBackground.setBounds(0,     0, 1280, 720);

        // adding in the random question
        setPreferredSize(new Dimension(1280, 720));
        JLabel currentRandomQuestion = new JLabel(TriviaTaskPresenter.tellViewQuestion());
        currentRandomQuestion.setPreferredSize(new Dimension(1280, 80));
        currentRandomQuestion.setHorizontalAlignment(JLabel.LEFT);
        currentRandomQuestion.setFont(new Font("Marker felt", Font.BOLD, 24));
        currentRandomQuestion.setBounds(105, -50, 1280, 720);

        JButton submitButton = new JButton();
        submitButton.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 2));
        submitButton.setBorderPainted(false);
        submitButton.setBorder(null);
        submitButton.setMargin(new Insets(0, 0, 0, 0));
        submitButton.setContentAreaFilled(false);
        submitButton.setBounds(805, 637, 130, 50);

        // setting up playerAnswer input
        JTextField playerAnswerInput = new JTextField();
        playerAnswerInput.setEditable(true);
        playerAnswerInput.setHorizontalAlignment(JTextField.CENTER);
        playerAnswerInput.setFont(new Font("Serif", Font.BOLD, 38));
        playerAnswerInput.setForeground(Color.MAGENTA);
        playerAnswerInput.setBounds(220, 387, 620, 135);
        playerAnswerInput.setOpaque(false);
        playerAnswerInput.setMargin(new Insets(1, 1, 1, 1));

        setPreferredSize(new Dimension(1280, 720));

        // adding the layers to the view
        add(triviaBackground, Integer.valueOf(0));
        add(currentRandomQuestion, Integer.valueOf(1));
        add(playerAnswerInput, Integer.valueOf(2));
        add(submitButton, Integer.valueOf(3));
        setVisible(true);

        /*
         * Invoked when the submitButton is clicked
         * @param e the event to be processed
         */
        submitButton.addActionListener(e -> {
            // when the submit button is pushed
            checkIfTimeRanOut();
            // pass the player's answer back to the view via the controller
            TriviaTaskController.passAnswer(playerAnswerInput);
            String correctnessMessage = TriviaTaskPresenter.tellCorrectness();
            JOptionPane.showMessageDialog(null, correctnessMessage);
            setVisible(false);
            TriviaTaskController.setActivatedStatus(false);
            GameMasterView.backToMain(GameMasterView.triviaTaskView);
        });

    }


    private static void checkIfTimeRanOut(){
        if(!TriviaTaskController.getActivatedStatus()){
            GameMasterView.backToMain(GameMasterView.triviaTaskView);
        }
    }

}
