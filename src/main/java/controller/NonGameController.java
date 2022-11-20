package controller;
import entities.Menu;
import entities.Authenticator;

public class NonGameController {
    public static String getScores(){
        // get the scores
        return Menu.getScores();
    }

    public static boolean login(String username, String password){
        return Authenticator.login(username, password);
    }
}
