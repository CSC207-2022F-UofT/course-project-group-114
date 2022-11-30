package presentor;

import controller.NonGameController;

import javax.swing.*;
import java.awt.*;

public class HighscorePresentor {
    public static void showscore(JTextArea base, String scores, JLayeredPane highscorePanel){
        base = new JTextArea(scores);
        base.setEditable(false);
        base.setFont(new Font("Snell Roundhand", Font.ITALIC | Font.BOLD, 40));
        base.setForeground(Color.BLACK);
        base.setBounds(460, 300, 1280, 720); // FIX THIS LATER
        base.setOpaque(false);
        base.setBorder(null);
        base.setMargin(new Insets(0, 0, 0, 0));

        highscorePanel.add(base, Integer.valueOf(1));
    }
}
