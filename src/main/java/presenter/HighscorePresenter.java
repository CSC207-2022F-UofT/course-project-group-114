package presenter;

import usecases.Menu;
import javax.swing.*;
import java.awt.*;

/**
 * This class contains a method that updates a JTextArea with the newest high scores.
 *
 * @author Ming Hin Joshua Li
 */
public class HighscorePresenter {

    /**
     * This method returns the JTextArea created by getScore
     * @return a JTextArea with the scores from the use case
     */
    public static JTextArea getScore(){
        JTextArea base = new JTextArea(Menu.highScores);
        base.setEditable(false);
        base.setFont(new Font("Snell Roundhand", Font.ITALIC | Font.BOLD, 40));
        base.setForeground(Color.BLACK);
        base.setBounds(460, 300, 1280, 720);
        base.setOpaque(false);
        base.setBorder(null);
        base.setMargin(new Insets(0, 0, 0, 0));
        return base;
    }
}
