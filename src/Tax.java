
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author youngjucho
 */
public class Tax {
    
    

    public double calculateTax(double income) {
        double balance = income;

        double[][] tax_bracket = {{0.10, 10000}, {0.15, 20000}, {0.17, 40000}, {0.20, Double.MAX_VALUE}};

        double tax = 0;

        for (int index = 0; index < tax_bracket.length; index++) {
            if (balance > 0) {
                if (tax_bracket[index][1] < balance) {
                    tax += tax_bracket[index][0] * tax_bracket[index][1];
                    balance -= tax_bracket[index][1];
                    System.out.println("tax : " + tax + "balance :" + balance);
                } else {
                    tax += tax_bracket[index][0] * balance;
                    balance = 0;
                    System.out.println("tax : " + tax + "balance :" + balance);
                }
            }
        }
        return tax;
    }
    
    public double calculateTax2(double income) { 
        if (income <= 0.0 || income > Double.MAX_VALUE) {
            System.out.println("false");
            return 0;
        }
        return helper(income, 0);
    }
    
    public double helper (double income, double tax) {
        if (income <= 10000) {
            return income * 0.1; 
        } 
        
        if (income > 40000) {
            helper (income - 40000, tax + (income - 40000) * 0.2);
        } else if (income > 20000) {
            helper (income - 20000, tax + (income - 20000) * 0.17);
        } else if (income > 10000) {
            helper (income - 10000, tax + (income - 10000) * 0.15);
        }
        return tax;
    }
    
    

    public static void main(String[] args) {
        Tax t = new Tax();
        
        System.out.println(t.calculateTax(35000));
        System.out.println(t.calculateTax2(70000));
    }

}
