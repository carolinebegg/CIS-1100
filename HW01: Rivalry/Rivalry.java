/*
* Name: Caroline Begg
* pennkey: cbegg
* Description: created a simulated "race" between two images using the Math.random
* function to move the images at a certain probability
*/
public class Rivalry {    
    public static void main(String[] args) {
        boolean rivalOneWins = false;  // has contestant 1 won the race?
        boolean rivalTwoWins = false;  // has contestant 2 won the race?

        /* the width of 1 pixel in window coordinate
         * use this variable when you get to the movement portion of the program 
         */
        double ONE_PIXEL = 1.0 / 512; //incremental value for one pixel

        double sLocation = 0.1; //initial position of starbucks
        double dLocation = 0.1; //initial position of dunkin

        PennDraw.picture(sLocation, 0.66, "starbucks.png", 100, 100);
        PennDraw.picture(dLocation, 0.33, "dunkin.png", 100, 100);

        PennDraw.enableAnimation(24); //enable Animation

        //race loop
        while (!rivalOneWins && !rivalTwoWins) {
             PennDraw.clear();
             PennDraw.setPenColor(PennDraw.BLACK); //line color
             PennDraw.line(0.2, 0, 0.2, 1); //starting line
             PennDraw.line(0.8, 0, 0.8, 1); //finish line

             double starbucks = Math.random(); //generate random value 0-1
             double dunkin = Math.random(); //generate random value 0-1

             if (starbucks <= 0.56) { //56% change random value 0-1
                 sLocation = sLocation + ONE_PIXEL;
                 PennDraw.picture(sLocation, 0.66, "starbucks.png", 100, 100);
             }

             if (dunkin <= 0.48) { //48% change random value 0-1
                 dLocation = dLocation + ONE_PIXEL;
                 PennDraw.picture(dLocation, 0.33, "dunkin.png", 100, 100);
             }

             if (dLocation >= 0.8) { //check for dunkin victory first
                 rivalTwoWins = true;
             }

             if (sLocation >= 0.8) {
                 rivalOneWins = true;
             }
            
            PennDraw.advance();
        }
        
        PennDraw.disableAnimation(); //turn off animanation because race is over

        //victory messages
        if (rivalOneWins = true) { //starbucks victory message
            PennDraw.clear(PennDraw.GREEN);
            PennDraw.setPenColor(PennDraw.WHITE);
            PennDraw.setFontSize(24);
            PennDraw.text(0.5, 0.5, "Congratulations!! Starbucks Wins!");
        }
        else if (rivalTwoWins = true) //dunkin victory message
        {
            PennDraw.clear(PennDraw.ORANGE);
            PennDraw.setPenColor(PennDraw.RED);
            PennDraw.setFontSize(24);
            PennDraw.text(0.5, 0.5, "Dunkin Wins... they do have great donuts.");
        }  
        
    }
}