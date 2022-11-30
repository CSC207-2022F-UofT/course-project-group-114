import entities.User;
import org.junit.jupiter.api.Test;

import usecases.Authenticator;

public class AuthenticatorTest {

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
