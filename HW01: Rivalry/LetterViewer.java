/*
* Name: Caroline Begg
* pennkey: cbegg
* Description: this program allows for the user to type in a key on the keyboard
* and have that key appear on the screen. The white screen must be clicked first in
* order to allow the user to input a key.
*/
public class LetterViewer {
    public static void main(String[] args) {

        //set up: pen color/size, canvas size, turning on animation 
        PennDraw.setPenColor(PennDraw.BLACK);
        PennDraw.setPenRadius(0.008);
        PennDraw.enableAnimation(30);
        PennDraw.setFontSize(64);
        PennDraw.clear();
        
        while (true) {
            while (PennDraw.hasNextKeyTyped()) { //check for new key
                String s = "";
                char keyPressed = PennDraw.nextKeyTyped(); //assign key to a char
                String key = s + keyPressed; //conc char key to string s
                PennDraw.text(0.5, 0.5, key); //print them out
                
                PennDraw.advance();
                PennDraw.clear();
            }

        }
    }
}