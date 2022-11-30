package entities;

import presentor.AuthenticatorPresentor;
import view.AuthenticatorView;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 *  This class contains the methods that relate to logging in,
 *  signing up, writing the CSV, encrypting the inputted password,
 *  storing/remembering the current player's User class, and updating
 *  the current player's high score after they lose.
 *
 *  @author Ming Hin Joshua Li
 */

public class Authenticator {
    private static User current; // the current user
    public static ArrayList<User> users; // an ArrayList of all the users

    static {
        try {
            users = updateUser();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method logs in the user and decides if the inputted
     * username and password is valid (it isn't when the password
     * is wrong or if the user doesn't exist in the database)
     * @param username a string input representing the user's username
     * @param password a string input representing the user's password
     * @return
     */
    public static void login(String username, String password){
        int index = -1;
        for (int i = 0; i < users.size(); i++){
            if (Objects.equals(users.get(i).getUsername(), username)){
                index = i;
                break;
            }
        }

        if(index == -1){
            AuthenticatorPresentor.loginFail();
        }
        else {
            current = users.get(index);
            if(md5(password).equals(current.getPassword()))
            {
                AuthenticatorPresentor.startGame();
            }
            else
            {
                AuthenticatorPresentor.loginFail();
            }
        }
    }
    // sign up
    public static void signIn(String name, String username, String password, String password2){
        //gives true or false based on sign in attempt (if user already exists)
        if (!password.equals(password2)){
            AuthenticatorPresentor.signinFail();
        }

        for (User user : users) {
            if (Objects.equals(user.getUsername(), username)) {
                AuthenticatorPresentor.signinFail();
            }
        }

        users.add(new User(name, username, md5(password), 0));
        current = users.get(users.size() - 1);
        updateCSV();
        AuthenticatorPresentor.startGame();
    }
    // store highscore (based on the score) (maybe move this to another class later if its easier) (ended up moving lol
    public static void updateScore(int updated){
        if (current.getHighscore() <= updated){
            current.setHighscore(updated);
            updateCSV();
        }
    }

    // rewrite csv accordingly
    private static void updateCSV(){
        // rereads the score up to the player index then update the order
        Collections.sort(users);
        Collections.reverse(users);
        try{
            FileWriter location = new FileWriter("src/main/java/resources/users.txt");

            for (User user : users){
                location.write(user.getName() + "," + user.getUsername() + "," + user.getPassword() +
                        "," + user.getHighscore() + ",");

            }
            location.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private static ArrayList<User> updateUser() throws FileNotFoundException {
        //updates users to all the existing users
        Scanner scan = new Scanner(new File("src/main/java/resources/users.txt")); // goes to the path to find the file
        scan.useDelimiter(",");
//        String line;
        String name;
        String username;
        String password;
        int highscore;
//        String[] temp;
        ArrayList<User> lst = new ArrayList<User>();
        
        while(scan.hasNext()){
            name = scan.next();
            username = scan.next();
            password = scan.next();
            highscore = Integer.parseInt(scan.next());
            lst.add(new User(name, username, password, highscore));
        }

        return lst;
    }

    public static String md5(String input){
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

    public static void setCurrent(User player){
        current = player;
    }
}
