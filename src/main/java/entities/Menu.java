package entities;
import presentor.HighscorePresentor;

import javax.swing.*;
import java.util.ArrayList;
public class Menu {
    // this class controls the backend of the menu
    /* should have functions that do:
        shows scores
     */

    // we need to agree to a path to store the file for saving

    public static void getScores(JTextArea base, JLayeredPane highscorePanel) // should be triggered after highscore screen open is clicked
    {
        ArrayList<User> users = Authenticator.users;
        StringBuilder scores = new StringBuilder();
        int index = 0;
        while(index < 7 && index < users.size()){
            scores.append(users.get(index).toString()).append("\n");
            index += 1;
        }

        HighscorePresentor.showscore(base, scores.toString(), highscorePanel);
    }
}
