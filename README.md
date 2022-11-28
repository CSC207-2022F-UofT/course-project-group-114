# Instructions to run the game

To test out our game, as of now the StartView.java and GameMasterView.java needs to be run separately since we are yet to
link the users and the game together from UI perspective.

StartView.java -> the starting screen of our game, the login/register functionality and the highscores board. 

[NOTE 1: The screen will freeze after the login/registration as the gamemaster is not connected yet, 
so the window must be closed and GameMasterView.java must be run]

[NOTE 2: If registering, the user.txt will be updated with the new register information 
even though the screen will freeze after the registering]

GameMasterView.java -> the main game screen where tasks are generated on random and score updates upon completion of the tasks.