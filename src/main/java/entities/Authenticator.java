package entities;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Authenticator {
    // holds all the methods useful for login and such
    private static User current;
    public static ArrayList<User> users;

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
            if (Objects.equals(users.get(i).getUsername(), username)){
                index = i;
                break;
            }
        }

        if(index == -1){
            return false;
        }
        else {
            current = users.get(index);
            return md5(password).equals(current.getPassword());
        }
    }
    // sign up
    public static boolean signIn(String name, String username, String password, String password2){
        //gives true or false based on sign in attempt (if user already exists)
        if (!password.equals(password2)){
            return false;
        }

        for (User user : users) {
            if (Objects.equals(user.getUsername(), username)) {
                return false;
            }
        }

        users.add(new User(name, username, md5(password), 0));
        current = users.get(users.size() - 1);
        updateCSV();
        return true;
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
        try{
            FileWriter location = new FileWriter("src\\main\\java\\resources\\users.txt");

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
        Scanner scan = new Scanner(new File("src\\main\\java\\resources\\users.txt")); // goes to the path to find the file
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
