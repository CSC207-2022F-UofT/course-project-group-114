package view;
import controller.TriviaTaskController;
import javax.swing.*;
import java.awt.*;

public class TriviaTaskView extends JFrame {
    TriviaTaskController controller = new TriviaTaskController();
//    String currentQuestion = "abc";     // this is where the current question will be randomly selected and displayed
    JPanel chooseCategoryPopup = newJPanel();
    Jlabel chooseMessage = new JLabel("Choose a category");
    chooseMessage.setPreferredSize(new Dimension(1200, 100));
    chooseMessage.setHorizontalAlignment(JLabel.CENTER);
    chooseMessage.setFont(new java.awt.Font("Serif", Font.BOLD, 24));
    chooseCategoryPopup.add(chooseMessage);





}
