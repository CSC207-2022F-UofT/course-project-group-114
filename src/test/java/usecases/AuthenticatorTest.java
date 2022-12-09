package usecases;

import entities.User;
import org.junit.jupiter.api.Test;


/**
 * This class contains unit tests meant for the Authenticator class, testing the
 * data saving, string encryption, and score updating.
 * @author Ming Hin Joshua Li
 */
public class AuthenticatorTest {

    @Test void logIn(){
        // showcases that the player is stored and login works properly
        Authenticator.signIn("My name", "username", "password", "password");
        Authenticator.login("username", "password");
        assert Authenticator.login;
    }

    @Test
    public void passwordEncryption(){
        //showcases the Md5 method encrypts properly
        String unencrypted = "password";
        String stored = Authenticator.md5(unencrypted);
        String input = Authenticator.md5(unencrypted);
        assert stored.equals(input);
    }

    @Test
    public void testUpdateScore(){
        //showcases that the current user's score is updated
        User current = new User("My name", "test", "password", 0);
        int newScore = 10;
        Authenticator.setCurrent(current);
        Authenticator.updateScore(newScore);
        assert current.getHighscore() == newScore;
    }
}
