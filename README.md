# Instructions to run the game and how it works

To test out our game, you need to run StartView.java. 
You enter room 114 and either log in/register. This is where you can check out the highscores and 
play with the motivation to be the best!

The main game screen appears and tasks pop up on the screen randomly. You must complete a task correctly 
in order to get a point withing the allotted time limit which is 10s per game!

If you fail to do, you lose a "grace credit". Once you lose all of your 5 grace credits, you lose the game :(

# Changes since Milestone 4 and addressing feedback

Since Milestone 4 submission, we have made quite some changes to make out code function as intended and
to address the TAs feedback. 

Our screens which were not connected before are connected now and only StartView.java needs to be run.

The incomplete "tasks" from Milestone 4 are now completed and added to the game as well (WireTask and TriviaTask)

The game screen has been made compatible with any OS and now can be run on MacOS (which it was not 
at Milestone 4)

Presenters have been added to the features to ensure clean architecture as suggested by the TA. 

Entities and use cases are now distinctly separated.

Naming conventions have been checked and IntelliJ warnings addressed, unused variable and imports removed.

The lack of a proper design patten is addressed and was explained during the presentation

Test files have been created for the program and javadocs have been added for all files.