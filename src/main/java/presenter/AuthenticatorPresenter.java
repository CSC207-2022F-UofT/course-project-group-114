package presenter;

import usecases.Authenticator;

import javax.swing.*;

/**
 * This class contains methods that update the view or create popups based
 * on data from the Authenticator use case.
 *
 * @author Ming Hin Joshua Li
 */

public class AuthenticatorPresenter {

    /**
     * This method creates a popup that tells the user the
     * login has failed.
     */
    public static void loginFail(){

        JOptionPane.showMessageDialog(null, "Error loggin in!");
    }

    /**
     * This method creates a popup that tells the user the
     * sign in has failed.
     */
    public static void signinFail(){
        JOptionPane.showMessageDialog(null, "Sign in failed, please try again.");
    }

    /**
     * This method returns whether they passed the log in attempt
     * @return a boolean from the Authenticator use case
     */
    public static boolean setLogin() {
        return Authenticator.login;
    }

    /**
     * This method returns whether they passed the sign in attempt
     * @return a boolean from the Authenticator use case
     */
    public static boolean setSignin() {
        return Authenticator.signin;
    }
}
