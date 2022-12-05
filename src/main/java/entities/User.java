package entities;

/**
 * This entity class is used to store the string containing a player's info
 * into a more easily accessible dataclass.
 *
 * @author Ming Hin Joshua Li
 * @inheritDoc Comparable
 */
public class User implements Comparable<User>{
    // keeps track of user data
    private final String name;
    private final String username;
    private final String password;
    private int highscore;

    /**
     * Constructor used to fill the dataclass
     * @param name a string representing the player's display name
     * @param username a string representing the player's username
     * @param password a string representing the player's password
     * @param highscore a string representing the player's high score
     */
    public User(String name, String username, String password, int highscore){
        this.name = name;
        this.username = username;
        this.password = password;
        this.highscore = highscore;
    }

    /**
     * This methods sets the high score
     * @param score an integer representing the new and higher high score
     */
    public void setHighscore(int score){
        this.highscore = score;
    }

    /**
     * This methods returns the player's password
     * @return a string representing the player's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This methods returns the player's username
     * @return a string representing the player's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * This methods returns the player's display name
     * @return a string representing the player's display name
     */
    public String getName() {
        return name;
    }

    /**
     * This methods returns the player's highest score
     * @return a string representing the player's highest score
     */
    public int getHighscore() {
        return highscore;
    }

    /**
     * This method compares two User class instances
     * @param o the object to be compared.
     * @return whether this User class instance is less than the compared one
     */
    @Override
    public int compareTo(User o) {
        return this.highscore - o.highscore;
    }

    /**
     * This method converts the User class instance to a readable string
     * @return a string containing the User class's display name and highest score
     */
    @Override
    public String toString() {
        return name + " " + highscore;
    }
}


