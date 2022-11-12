public class Menu {
    // this class controls the backend of the menu
    /* should have functions that do:
        shows scores
        start a game master..?
     */

    // we need to agree to a path to store the file for saving
    String path;

    public static int[] getScores() // should be triggered after highscore screen open is clicked
    {
        int[] scores = new int[7];
        for (int i = 0; i <= 7; i++)
        {
            // goes to the path to find the file
        }

        return scores;
    }

    // store highscore (based on the score) (maybe move this to another class later if its easier
    public static void updateScore(User player){
        
    }
}
