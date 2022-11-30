package presenter;

import view.AuthenticatorView;
import view.GameMasterView;
import view.StartView;

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

    public static void startGame(){
        AuthenticatorView view = StartView.view;
        view.dispose();
        new GameMasterView();
    }
}
