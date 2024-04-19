/**********************************************************************
 *  N-Body Simulation readme.txt template
 **********************************************************************/


Name: Caroline Begg
PennKey: cbegg
Hours to complete assignment (optional): 10 hours



/**********************************************************************
 *  Please list all help, collaboration, and outside resources
 *  you used here. 
 *
 *  If you did not get any help in outside of TA office hours,
 *  and did not use any materials outside of the standard
 *  course materials and piazza, write the following statement below:
 *  "I did not receive any help outside of TA office hours.  I
 *  did not collaborate with anyone, and I did not use any
 *  resources beyond the standard course materials."
 **********************************************************************/

 I did not receive any help outside of TA office hours. I did not collaborate with 
 anyone, and I did not use any resources beyond the standard course materials.



/**********************************************************************
 *  Problem A: 
 *  Compare this approach to the approach in HW2. Why is it better to 
 *  decompose a problem using objects?
 **********************************************************************/

It is better to decompose a problem using objects because it is a much more 
efficient and organized way to code a program. Java is an object-oriented 
programming language, and is most ideally design to use objects. In the main
function, there was only two functions that needed to be called, which made the 
program a lot cleaner and easier to read and understand than the previous NBody.

/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
I had a lot of trouble with my getAffectedBy function, and spent a great deal of
time trying to figure out why it was not working properly. My code was printing
NaN for all values and showed the bodies in the upper left corner of the screen. I 
was able to identify that the getAffectedBy method was the issue due to the fact 
that it was the only function that failed the JUnit test. After going to office 
hours and speaking with a TA, I realized it was the simple mistake of having set my 
velocity variables to vx += vx + timeStep * ax and vy += vy + timeStep * ay, when I 
should not have had both "+=" and the original value of the vx/vy. 

/**********************************************************************
 *  All the questions below are optional, but we value your feedback.                                  
 **********************************************************************/
/**********************************************************************
 *  Difficulty - Very Difficult, Somewhat Difficult, Somewhat Easy, 
 *  Very Easy (you may add comments alongside your rating).                                   
 **********************************************************************/

Somewhat Difficult





/**********************************************************************
 *  Quality of the Write-up - Very Good, Somewhat Good, Somewhat Bad, 
 *  Very Bad (you may add comments alongside your rating).                                 
 **********************************************************************/

Somewhat Good/Somewhat Bad -- a bit confusing




/**********************************************************************
 *  Quality of the Submission Tests: Very Good, Somewhat Good, 
 *  Somewhat Bad, Very Bad (you may add comments alongside your rating).                                
 **********************************************************************/

Very Good




/**********************************************************************
 *  Did this assignment help you understand objects better? Helped 
 *  significantly, helped somewhat, barely helped, did not help at all.                                  
 **********************************************************************/

helped somewhat



