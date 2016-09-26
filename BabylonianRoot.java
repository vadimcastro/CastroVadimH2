// Vadim Castro
// BabylonianRoot module


import javax.swing.*;

public class BabylonianRoot {
    private double S;
    private double e;
    private double X;


    private BabylonianRoot(double a, double b, double c) {
        S = a;
        e = c;
        X = b;
    }

    private double SquareRoot(double x) {
        if (x == Math.sqrt(S)) {
            return x;

        } else {


            double x2 = (S / x);
            double x3 = .5 * (x + x2);
            return this.SquareRoot(x3);
        }
    }

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
