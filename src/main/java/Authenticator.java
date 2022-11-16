import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.ArrayList;

public class Authenticator {
    // holds all the methods useful for login and such
    private static User current;
    private static ArrayList<User> users;

    static {
        try {
            users = updateUser();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // login (figure out hashmap)
    public static boolean login(String username, String password){
        // gives true or false based on login success (false: user doesnt exist or wrong password)
        int index = -1;
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).username == username){
                index = i;
                break;
            }
        }

        if(index == -1){
            return false;
        }
        else {
            return md5(password) == users.get(index).password;
        }
    }
    // sign up
    public static boolean signIn(String name, String username, String password){
        //gives true or false based on sign in attempt (if user already exists)
        for (User user : users) {
            if (user.username == username) {
                return false;
            }
        }

        users.add(User(name, username, md5(password), 0));
        updateCSV();
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

    private static ArrayList<User> updateUser() throws FileNotFoundException {
        //updates users to all the existing users
        Scanner scan = new Scanner(new File("users")); // goes to the path to find the file
        scan.useDelimiter(",");
        String line;
        String name;
        String username;
        String password;
        int highscore;
        String[] temp;
        ArrayList<User> lst = new ArrayList<User>();
        
        while(scan.hasNext()){
            line = scan.next();  // reads the line
            temp = line.split(",");
            name = temp[0];
            username = temp[1];
            password = md5(temp[2]);
            highscore = Integer.parseInt(temp[3]);
            lst.add(User(name, username, password, highscore));
        }

        return lst;
    }

    private static String md5(String input){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);

            StringBuilder encrypted = new StringBuilder(no.toString(16));
            while (encrypted.length() < 32){
                encrypted.insert(0, "0");
            }
            return encrypted.toString();
        }
        catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }
}
