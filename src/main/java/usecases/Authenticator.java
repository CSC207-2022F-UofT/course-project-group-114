package usecases;

import entities.User;
import presenter.AuthenticatorPresenter;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 *  This use case class contains the methods that relate to logging in,
 *  signing up, writing the CSV, encrypting the inputted password,
 *  storing/remembering the current player's User class, and updating
 *  the current player's high score after they lose.
 *
 *  @author Ming Hin Joshua Li
 */

public class Authenticator {
    private static User current; // the current user
    public static ArrayList<User> users; // an ArrayList of all the users

    public static boolean signin = false;

    public static boolean login = false;

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
     * @param username a string input representing the player's username
     * @param password a string input representing the player's password
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
            login = false;
        }
        else {
            current = users.get(index);
            login = md5(password).equals(current.getPassword());
        }
    }

    /**
     * This method signs the user up and decides if the inputted strings
     * are valid (it fails if the user already exists or the repeated password
     * is wrong)
     * @param name a string input representing the player's display name
     * @param username a string input representing the player's username
     * @param password a string input representing the player's password
     * @param password2 a string input from the player that should be the repeated password
     */
    public static void signIn(String name, String username, String password, String password2){
        if (!password.equals(password2)){
            signin = false;
        }

        for (User user : users) {
            if (Objects.equals(user.getUsername(), username)) {
                signin = false;
                return;
            }
        }

        users.add(new User(name, username, md5(password), 0));
        current = users.get(users.size() - 1);
        updateCSV();
        signin = true;
    }

    /**
     * This method takes in an integer high score and updates the CSV
     * with it if it is higher than the original one for the current player.
     * @param updated an integer representing a possible new high score
     */
    public static void updateScore(int updated){
        if (current.getHighscore() <= updated){
            current.setHighscore(updated);
            updateCSV();
        }
    }

    /**
     * This method sorts (from highest to lowest), converts the user
     * classes to string, and writes them into the txt file.
     */
    private static void updateCSV(){
        Collections.sort(users); // sorts the users since they're comparable
        Collections.reverse(users); // reverses the list
        try{
            FileWriter location = new FileWriter("src/main/java/resources/users.txt");

            for (User user : users){
                location.write(user.getName() + "," + user.getUsername() + "," + user.getPassword() +
                        "," + user.getHighscore() + ","); // converts to a string

            }
            location.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method reads from the txt file and updates the  static
     * ArrayList users so it can be used by other methods later
     * @return the ArrayList of User classes converted from the txt
     * @throws FileNotFoundException if the file doesn't exist
     */
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

    /**
     * This method converts the string password into a 128-bit hash value.
     * which is identical as long as the string is identical.
     * This is mainly so that the passwords of the users
     * can't be read by anyone who accesses the txt file.
     * @param input a string from any method
     * @return a 128-bit hash value
     */
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

    /**
     * This method sets the current user which is used for
     * the unit test
     * @param player a User class that you want to set as the current player
     */
    public static void setCurrent(User player){
        current = player;
    }
}
