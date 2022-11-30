package usecases;
import entities.User;
import presenter.HighscorePresentor;

import java.util.ArrayList;

/**
 * This class contains a method used to get the score for
 * the high score board during the start menu.
 *
 * @author Ming Hin Joshua Li
 */
public class Menu {

    /**
     * This method gets the users from Authenticator and picks the first 7
     * to pass to the presenter for the player to see
     */
    public static void getScores() // should be triggered after highscore screen open is clicked
    {
        ArrayList<User> users = Authenticator.users;
        StringBuilder scores = new StringBuilder();
        int index = 0;
        while(index < 7 && index < users.size()){
            scores.append(users.get(index).toString()).append("\n");
            index += 1;
        }

        HighscorePresentor.showscore(scores.toString());
    }
}
