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

public class TriviaTaskView extends JLayeredPane {
    /**
     * Constructor for the TriviaTask view.
     * Creates and places all the necessary pieces for the view on the JLayeredPane
     * Has event listener submit button to pass information (the player's answer) back to the controller.
     */

    //public static JLayeredPane triviaTaskPanel;

    TriviaTaskView(){

        TriviaTaskController controller = new TriviaTaskController();
        //TriviaTaskPresenter presenter = new TriviaTaskPresenter();
        // JPanel popup = new JPanel();
        //String q = TriviaTaskPresenter.tellViewQuestion();

        // background art
        ImageIcon backgroundPng = new ImageIcon("src/main/java/resources/triviaart.png");
        JLabel triviaBackground = new JLabel(backgroundPng);
        triviaBackground.setPreferredSize(new Dimension(1280,720));
        triviaBackground.setBounds(0,     0, 1280, 720);

        // adding in the random question
        setPreferredSize(new Dimension(1280, 720));
        // JLabel instruction = new JLabel("You have 10 seconds to answer the question below")
        //question = new JLabel(TriviaTaskPresenter.tellViewQuestion());
        JLabel currentRandomQuestion = new JLabel(TriviaTaskPresenter.tellViewQuestion());
        currentRandomQuestion.setPreferredSize(new Dimension(1280, 80));
        currentRandomQuestion.setHorizontalAlignment(JLabel.LEFT);
        currentRandomQuestion.setFont(new Font("Marker felt", Font.BOLD, 24));
        currentRandomQuestion.setBounds(105, -50, 1280, 720);

        JButton submitButton = new JButton();
        submitButton.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 2));
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

        // adding the layers to the view!
        add(triviaBackground, Integer.valueOf(0));
        add(currentRandomQuestion, Integer.valueOf(1));
        add(playerAnswerInput, Integer.valueOf(2));
        add(submitButton, Integer.valueOf(3));
        setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // when the submit button is pushed
                checkIfTimeRanOut();
                // pass the player's answer back to the view via the controller
                TriviaTaskController.passAnswer(playerAnswerInput);
                String correctnessMessage = TriviaTaskPresenter.tellCorrectness();
                JOptionPane.showMessageDialog(null, correctnessMessage);
                setVisible(false);
                TriviaTaskController.setActivatedStatus(false);
                GameMasterView.backToMain(GameMasterView.triviaTaskView);
            }
        });

    }
    // add the layers!!!
    //add(triviaBackground, Integer.valueOf(0));

    public static void main(String[] args){new TriviaTaskView();}

    private static void checkIfTimeRanOut(){
        if(!TriviaTaskController.getActivatedStatus()){
            GameMasterView.backToMain(GameMasterView.triviaTaskView);
        }
    }

}
