// Vadim Castro
// BabylonianRoot module


import javax.swing.*;

/**
 * Serves as the blueprint for all BabylonianRoot objects which posses the constructor, SquareRoot, and validate methods.
 * Object of class calculates square root of desired number via the Babylonian method of approximation and allows user to guess,
 * as well as define the acceptable percent error for said guess/guesses. If acceptable percent error is not reached,
 * user has unlimited opportunities to keep guessing and getting closer to the answer.
 */
public class BabylonianRoot {

    private double S;
    private double e;
    private double X;


    /**
     * Constructor for BabylonianRoot object
     *  @param a the number to find square of
     * @param b the guess for the square root
     * @param c acceptable percent error
     */

    private BabylonianRoot(double a, double b, double c) {
        S = a;
        e = c;
        X = b;
    }


    /**
     * Calculates square root of a number via the Babylonian method
     *  @param x the number to be taken the sqaure root of
     * @return the square root or the SquareRoot method call if recursion is required
     */

    private double SquareRoot(double x) {
        if (x == Math.sqrt(S)) {
            return x;

        } else {


            double x2 = (S / x);
            double x3 = .5 * (x + x2);
            return this.SquareRoot(x3);
        }
    }

    /**
     * Determines if the guesses' percent error is within acceptable percent error predetermined through input.
     * If not, prints a warning message notifying the user that his guess is too far off and gives more chances to guess.
     * Also redefines percent error for each new guess.
     * @param result the actual square root as calculated by the SquareRoot method
     */

    private void validate(double result) {

        double e2 = Math.abs(((X - result) / X) * 100);
        System.out.println(e2);



        if (e2 > Math.abs(e)) {
            JOptionPane.showMessageDialog(null, "Unacceptable percent error! Please try again" + "\nYour last guess was " + X + " and was off by " + e2 + " percent.");


            while (e2 > Math.abs(e)) {

                double redemption = Double.parseDouble(JOptionPane.showInputDialog("Enter new guess: "));
                e2 = Math.abs(((redemption - result) / redemption)*100);
                if (e2 > e) {
                    JOptionPane.showMessageDialog(null, "Unacceptable percent error! Please try again" + "\nYour last guess was " + redemption + " and was off by " + e2 + " percent.");
                }
                else {
                    JOptionPane.showMessageDialog(null,"You have succesfully guessed within an acceptable percent error range!");
                }

            }


        }
    }
}
