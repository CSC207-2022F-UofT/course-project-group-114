package controller;
import usecases.Menu;
import usecases.Authenticator;

public class NonGameController {
    public static void getScores(){
        // get the scores
        Menu.getScores();
    }

    public static void login(String username, String password){
        Authenticator.login(username, password);
    }

    public static void signin(String name, String username, String password, String password2){
        Authenticator.signIn(name,username,password,password2);
    }
}
