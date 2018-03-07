
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author youngjucho
 */
public class TaxCalc {
    
    private List<TaxBracket> taxBrackets;
    private double lowestTaxBracket;
    
    public TaxCalc (List<TaxBracket> taxBrackets, double lowestTaxBracket) {
        taxBrackets.sort((TaxBracket t1, TaxBracket t2)-> Double.compare(t2.getLimit(), t1.getLimit()));
        this.taxBrackets = taxBrackets;
        this.lowestTaxBracket = lowestTaxBracket;
    }
    
    public double getTax(double income) {
        return getTax(income, 0);
    }
    
    public double getTax(double remainingAmount, double tax) {
        for (TaxBracket taxBracket : taxBrackets) {
            if (remainingAmount > taxBracket.getLimit()) {
                return getTax(taxBracket.getLimit(), tax + (remainingAmount - taxBracket.getLimit()) * taxBracket.getRate());
            } 
        }
        return remainingAmount * lowestTaxBracket + tax;
    }
    
    public static void main(String[] args) {
        List<TaxBracket> taxBrackets = new ArrayList<>();
        taxBrackets.add(new TaxBracket(10000, 0.15));
        taxBrackets.add(new TaxBracket(20000, 0.17));
        taxBrackets.add(new TaxBracket(40000, 0.2));

        TaxCalculator t = new TaxCalculator(taxBrackets, 0.1);
        System.out.println(t.getTax(70000));
    }

}
