package entities;

public class User implements Comparable<User>{
    // keeps track of user data
    private String name;
    private String username;
    private String password;
    private int highscore;

    public User(String name, String username, String password, int highscore){
        this.name = name;
        this.username = username;
        this.password = password;
        this.highscore = highscore;
    }

    public void setHighscore(int score){
        this.highscore = score;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public int getHighscore() {
        return highscore;
    }

    @Override
    public int compareTo(User o) {
        return this.highscore - o.highscore;
    }

    @Override
    public String toString() {
        return name + " " + highscore;
    }
}

