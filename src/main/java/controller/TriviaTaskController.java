package controller;
import usecases.TriviaTask;
import javax.swing.*;
// controller is responsible for passing info from view to backend & ensuring that the
// dependency rule & clean architecture are not violated
// talk about the difference between controller & presenter
// what is in the controller? presenter? why?
public class TriviaTaskController {
//    private String playerAnswer;
//    private String[] actualAnswer;
public static TriviaTask triviataskusecase = new TriviaTask();

    // passes the random question through the controller from backend to view
//    public static String passRandomQuestion(){
//
//        return triviataskusecase.getRandomQuestion();
//    }
    // got rid of pass random question bc now that the presenter is added i'm just gonna have the
    // presenter call the usecase to tell the view what question to display

   // passActualAnswer is passing the user's answer "in" to the use case
   // this will remain in the controller

//    public String passActualAnswer(){
//        /*
//        this method gets the actual answer from the usecase
//        the view will call it
//        ***** can the view directly call the usecase????? or does this have to be done through
//        the controller?
//        what the fuck do i not know how to read
//         */
//
//        return triviataskusecase.getActualAnswer();
//    }

    // take the player's answer
    // translate it into something the backend can understand
    // relay it to the backend code and call the backend here

    // this bitch under here might need some refactoring???
    public boolean answerChecker(String actualAnswer, JTextField playerAnswer){
        // takes playerAnswer from the view aka the players input
        // calls the usecase - tells the usecase to check it
        return (TriviaTask.checkAnswer(actualAnswer, playerAnswer.getText()));
    }
    public static void setCompletionStatus(boolean status) {
        TriviaTask.setCompletionStatus("TriviaTask", status);
    }
    public static void setActivatedStatus(boolean status) {
        TriviaTask.setActivatedStatus("TriviaTask", status);
    }
    public static boolean getActivatedStatus() {
        return TriviaTask.getActivatedStatus("TriviaTask");
    }

}
