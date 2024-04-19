/*
* Name: Caroline Begg
* pennkey: cbegg
* Description: this program allows the user to draw lines on screen by clicking. The
* first line will be drawn from the center of the page, while the following lines
* will be drawn from where the user last clicked to where their new click was. If
* the user clicks in the top half of the screen, the line will be red. If they click
* in the bottom, it will be black.
*/
public class LineDrawingTool {
    public static void main(String[] args) {

        // set the pen radius to 0.01
        PennDraw.setPenRadius(0.01);

        // turn on animation
        PennDraw.enableAnimation(30);

        //declare doubles to hold the coordinate of where the cursor is clicked
        double x1 = 0.5;
        double y1 = 0.5;


        while (true) {
            if (PennDraw.mousePressed()) { //boolean to check if cursor was clicked
                
                //determine whether pen color should be black or red
                if (y1 > 0.5) {
                    PennDraw.setPenColor(PennDraw.RED);
                }
                else {
                    PennDraw.setPenColor(PennDraw.BLACK);
                }

                //draw line from previous point to point clicked
                PennDraw.line(x1, y1, PennDraw.mouseX(), PennDraw.mouseY());

                //reassign the value of the new point to the old point
                x1 = PennDraw.mouseX();
                y1 = PennDraw.mouseY();

            }

            // advance the frame after everything is drawn
            PennDraw.advance();
        }
    }
}
