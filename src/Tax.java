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
    
    public double calculateTax(double taxable_amount) {
        double balance = taxable_amount;
        
        double[][] tax_bracket = {{0.10, 20000}, {0.15, 20000}, {0.17, 40000}, {0.20, Double.MAX_VALUE}};
        
        double tax = 0;
        
        for (int index = 0; index< tax_bracket.length; index++) {
            if (balance > 0) {
                if (tax_bracket[index][1] < balance) {
                    tax += tax_bracket[index][0] *  tax_bracket[index][1];
                    balance -= tax_bracket[index][1];
                } else {
                    tax += tax_bracket[index][0] * balance;
                    balance = 0;
                }
            }
        }
        return tax;
    }
    
    public static void main (String[] args) {
        Tax t = new Tax();
        System.out.println(t.calculateTax(70000));
    }
    
}
