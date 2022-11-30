package presentor;

import view.AuthenticatorView;
import view.GameMasterView;

import javax.swing.*;

public class AuthenticatorPresentor {

    // login/sign in error
    public static void loginFail(){
        JOptionPane.showMessageDialog(null, "Error loggin in!");
    }

    public static void signinFail(){
        JOptionPane.showMessageDialog(null, "Sign in failed, please try again.");
    }
    // switch window to gamemaster

    public static void startGame(AuthenticatorView view){
        view.dispose();
        new GameMasterView();
    }
}
