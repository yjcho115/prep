
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
public class TaxCalculator {

    private List<TaxBracket> taxBrackets;
    private double lowestTaxBracket;

    public TaxCalculator(List<TaxBracket> taxBrackets, double lowestTaxBracket) {
        taxBrackets.sort((TaxBracket t1, TaxBracket t2) -> Double.compare(t2.getLimit(), t1.getLimit()));
        this.taxBrackets = taxBrackets;
        this.lowestTaxBracket = lowestTaxBracket;
    }

    public double getTax(double income) {
        return getTax(income, 0);
    }

    public double getTax(double remainingAmount, double tax) {
        for (TaxBracket taxBracket : taxBrackets) {
            if (remainingAmount > taxBracket.getLimit()) {
                double taxableAmount = remainingAmount - taxBracket.getLimit();
                double currentTax = taxableAmount * taxBracket.getRate();
                double accumulatedTax = tax + currentTax;
                return getTax(taxBracket.getLimit(), accumulatedTax);
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
