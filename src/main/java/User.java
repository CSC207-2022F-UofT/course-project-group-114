public class User {
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
}
