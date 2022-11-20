package view;
import controller.TriviaTaskController;
import javax.swing.*;
import java.awt.*;

public class TriviaTaskView extends JFrame {
    public JPanel chooseCategoryPopup;
    public JButton submitAnswerButton;


    TriviaTaskController controller = new TriviaTaskController();
//    String currentQuestion = "abc";     // this is where the current question will be randomly selected and displayed

    // have the user choose a category
    chooseCategoryPopup = newJPanel();
    Jlabel chooseMessage = new JLabel("Choose a category");
    chooseMessage.setPreferredSize(new Dimension(1200, 100));
    chooseMessage.setHorizontalAlignment(JLabel.CENTER);
    chooseMessage.setFont(new java.awt.Font("Serif", Font.BOLD, 24));
    chooseCategoryPopup.add(chooseMessage);


    // display the question & answer box and give player time to answer

    // the playerAnswer is the answer that the player has submitted. controller will have to relay this to the view





}
