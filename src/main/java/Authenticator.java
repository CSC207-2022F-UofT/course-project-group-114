import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Authenticator {
    // holds all the methods useful for login and such
    private static User current;
    private static User[] users;

    // login (figure out hashmap)
    public static boolean login(){
        // gives true or false based on login success
    }
    // sign up
    public static boolean signIn(){
        //gives true or false based on sign in attempt (if user doesnt exist)
    }
    // store highscore (based on the score) (maybe move this to another class later if its easier) (ended up moving lol
    public static void updateScore(int updated){
        current.setHighscore(updated);
        updateCSV();
    }

    // rewrite csv accordingly
    private static void updateCSV(){
        // rereads the score up to the player index then update the order
    }

    private static void updateUser(){
        //updates users to all the existing users
    }

    private static String md5(String input){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);

            String encrypted = no.toString(16);
            while (encrypted.length() < 32){
                encrypted = "0" + encrypted;
            }
            return encrypted;
        }
        catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }
}
