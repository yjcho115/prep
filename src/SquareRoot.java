/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author youngjucho
 */
public class SquareRoot {

    public double square_root(double a, double epsilon) {
        if (Math.abs(a) < epsilon) {
            return 0;
        }

        double x = 1.5;

        while (true) {
            if (Math.abs(x * x - a) < epsilon) {
                return x;
            }
            double y = a / x;
            x = (x + y) / 2;
        }

    }

    public static void main(String[] args) {
        SquareRoot s = new SquareRoot();
        System.out.println(s.square_root(2, 1e-6));
    }

}
