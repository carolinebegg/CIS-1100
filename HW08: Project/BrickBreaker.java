/* Name: Caroline Begg
* PennKey: cbegg
* Recitation: 205
* 
* Execution: java BrickBreaker [filename]
* 
* Description: this file contains the main function for the BrickBreaker game. this
*              file controls the canvas size and the animation frame speed, and 
*              takes in a single command line arguement, which is a txt file that 
*              provides the data for setting up the game stage (provided in this 
*              example is the file level.txt). additionally, this file controls the 
*              timestep, calls the update() and draw() functions from the Arena
*              class, and draws the final game screen after the player has finished
*              the game. 
*/

public class BrickBreaker {
    public static void main(String[] args) {
        PennDraw.setCanvasSize(1000, 500);
        PennDraw.enableAnimation(30);
        Stage stage = new Stage(args[0]);
        final double TIME_STEP = 0.2;

        boolean gameLoop = true;
        while (gameLoop) {
            while (!stage.gameOver()) {
                stage.update(TIME_STEP);
                if (stage.getSetStartScreen()) {
                    stage.drawStartScreen();
                }
                else {
                    stage.draw();
                }
            }
            stage.gameOver();
            stage.drawEndScreen();
            stage.restartGame();
            
            if (stage.restartGame()) {
                stage.resetGame();
            }
        }
    }
}