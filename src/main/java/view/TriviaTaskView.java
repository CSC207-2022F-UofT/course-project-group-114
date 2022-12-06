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

public class TriviaTaskView extends JPanel {
    /**
     * Constructor for the TriviaTask view.
     * Creates and places all the necessary pieces for the view on the JLayeredPane
     * Has event listener submit button to pass information (the player's answer) back to the controller.
     */

    public static JLayeredPane triviaTaskPanel;

    TriviaTaskView(){
        TriviaTaskController controller = new TriviaTaskController();
        TriviaTaskPresenter presenter = new TriviaTaskPresenter();
        //String actualAnswer = presenter.tellViewActualAnswer();
        JPanel popup = new JPanel();
        JLabel question = new JLabel("you will have 10 seconds to answer the question");
        question.setPreferredSize(new Dimension(1280, 80));
        question.setHorizontalAlignment(JLabel.CENTER);
        question.setFont(new Font("Serif", Font.BOLD, 16));
        popup.add(question);

        triviaTaskPanel = new JLayeredPane();
        triviaTaskPanel.setPreferredSize(new Dimension(1280, 720));

        //replace these with trivia art
        ImageIcon backgroundPng = new ImageIcon("src/main/java/resources/Background.png");
        JLabel triviaBackground = new JLabel(backgroundPng);
        //triviaBackground.setPreferredSize()

        ImageIcon submit = new ImageIcon("src/main/java/resources/submitbutton.png");
        JButton submitButton = new JButton(submit);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        submitButton.setBounds(200, 580, submit.getIconWidth(), submit.getIconHeight());

        // setting up playerAnswer input
        JTextField playerAnswerInput = new JTextField();
        playerAnswerInput.setEditable(true);
        playerAnswerInput.setHorizontalAlignment(JTextField.CENTER);
        playerAnswerInput.setFont(new Font("Serif", Font.BOLD, 16));
        playerAnswerInput.setForeground(Color.GRAY);
        playerAnswerInput.setBounds(120, 476, 268, 62);
        playerAnswerInput.setOpaque(false);
        playerAnswerInput.setMargin(new Insets(1, 1, 1, 1));

        setPreferredSize(new Dimension(1280, 720));
        setVisible(true);

        add(triviaTaskPanel);
        triviaTaskPanel.setVisible(true);
        popup.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // when the submit button is pushed
                // pass the player's answer back to the view via the controller
                TriviaTaskController.passAnswer(playerAnswerInput);
                String correctnessMessage = TriviaTaskPresenter.tellCorrectness();
                JOptionPane.showMessageDialog(null, correctnessMessage);
                setVisible(false);
               GameMasterView.backToMain(GameMasterView.triviaTaskView);
            }
        });

    }

    public static void main(String[] args){new TriviaTaskView();}

}
