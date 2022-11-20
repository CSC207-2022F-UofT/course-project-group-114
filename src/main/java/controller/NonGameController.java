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

    public static boolean signin(String name, String username, String password, String password2){
        return Authenticator.signIn(name,username,password,password2);
    }
}
