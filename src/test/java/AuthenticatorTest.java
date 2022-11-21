import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Authenticator;

public class AuthenticatorTest {
    @Test
    public void CSVWritingTest(){
        Authenticator.signIn("My name", "test", "password", "password");
        assert Authenticator.login("test", "password");
    }
}
