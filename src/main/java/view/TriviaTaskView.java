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

        // trivia task panel
        setPreferredSize(new Dimension(1280, 720));
        // JLabel instruction = new JLabel("You have 10 seconds to answer the question below")
        //question = new JLabel(TriviaTaskPresenter.tellViewQuestion());
        JLabel currentRandomQuestion = new JLabel(TriviaTaskPresenter.tellViewQuestion());
        currentRandomQuestion.setPreferredSize(new Dimension(1280, 80));
        currentRandomQuestion.setHorizontalAlignment(JLabel.LEFT);
        currentRandomQuestion.setFont(new Font("Marker felt", Font.BOLD, 20));
        currentRandomQuestion.setBounds(350, -270, 1280, 720);
        //popup.add(question);

//        triviaTaskPanel = new JLayeredPane();
//        triviaTaskPanel.setPreferredSize(new Dimension(1280, 720));

//        setPreferredSize(new Dimension(1280, 720));
//        String currentQuestion = TriviaTaskPresenter.tellViewQuestion();

        // set background
        ImageIcon backgroundPng = new ImageIcon("src/main/java/resources/triviaart.png");
        JLabel triviaBackground = new JLabel(backgroundPng);
        triviaBackground.setPreferredSize(new Dimension(1280,720));
        triviaBackground.setBounds(0,     0, 1280, 720);

        //triviaBackground.setPreferredSize()

        ImageIcon submit = new ImageIcon("src/main/java/resources/submitbutton.png");
        JButton submitButton = new JButton(submit);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        submitButton.setBounds(200, 580, submit.getIconWidth(), submit.getIconHeight());

        // setting up playerAnswer input
        JTextField playerAnswerInput = new JTextField();
        playerAnswerInput.setEditable(true);
        playerAnswerInput.setHorizontalAlignment(JTextField.LEFT);
        playerAnswerInput.setFont(new Font("Serif", Font.BOLD, 25));
        playerAnswerInput.setForeground(Color.GRAY);
        playerAnswerInput.setBounds(120, 476, 268, 62);
        playerAnswerInput.setOpaque(false);
        playerAnswerInput.setMargin(new Insets(1, 1, 1, 1));

        setPreferredSize(new Dimension(1280, 720));
        setVisible(true);

//        add(triviaTaskPanel);
//        triviaTaskPanel.setVisible(true);
//        popup.setVisible(true);

        //add(triviaBackground);
//        add(question);
//        add(playerAnswerInput);
//        add(submitButton);
        add(triviaBackground, Integer.valueOf(0));
        add(currentRandomQuestion, Integer.valueOf(1));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // when the submit button is pushed
                // pass the player's answer back to the view via the controller
                TriviaTaskController.passAnswer(playerAnswerInput);
                String correctnessMessage = TriviaTaskPresenter.tellCorrectness();
                JOptionPane.showMessageDialog(null, correctnessMessage);
                setVisible(false);
                //GameMasterView.backToMain(GameMasterView.triviaTaskView);
            }
        });

    }
    // add the layers!!!
    //add(triviaBackground, Integer.valueOf(0));

    public static void main(String[] args){new TriviaTaskView();}

//    private static void checkIfTimeRanOut(){
//        if(!TriviaTaskController.getActivatedStatus()){
//            GameMasterView.backToMain(GameMasterView.triviaTaskView);
//        }
//    }

}
