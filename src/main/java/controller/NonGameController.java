package controller;
import entities.Menu;
import entities.Authenticator;
import view.AuthenticatorView;

import javax.swing.*;

public class NonGameController {
    public static void getScores(JTextArea scores, JLayeredPane highscorePanel){
        // get the scores
        Menu.getScores(scores, highscorePanel);
    }

    public static void login(String username, String password, AuthenticatorView view){
        Authenticator.login(username, password, view);
    }

    public static void signin(String name, String username, String password, String password2,
                                 AuthenticatorView view){
        Authenticator.signIn(name,username,password,password2, view);
    }
}
