package controller;
import use_cases.Menu;
import use_cases.Authenticator;

/**
 * This controller class contains methods that handles
 * all the use case callings of AuthenticatorView and StartView
 *
 * @author Ming Hin Joshua Li
 */
public class NonGameController {
    /**
     * This method tells the Menu to set the view to the
     * current most updated high scores
     */
    public static void getScores(){
        Menu.getScores();
    }

    /**
     * This method passes the strings from the player's inputs to login use case
     * @param username a string representing the user's username
     * @param password a string representing the user's password
     */
    public static void login(String username, String password){
        Authenticator.login(username, password);
    }

    /**
     * This method passes the strings from the player's inputs to the sign in use case
     * @param name a string representing the user's display name
     * @param username a string representing the user's username
     * @param password a string representing the user's password
     * @param password2 a string representing the user's repeated password
     */
    public static void signin(String name, String username, String password, String password2){
        Authenticator.signIn(name,username,password,password2);
    }
}
