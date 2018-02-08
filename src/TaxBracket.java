/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author youngjucho
 */
public class TaxBracket {
    
    private double limit;
    private double rate;
    

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getRate() {
        return rate;
    }

    public double getLimit() {
        return limit;
    }

    public TaxBracket(double limit, double rate) {
        this.limit = limit;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "TaxBracket{" + "limit=" + limit + ", rate=" + rate + '}';
    }
    
    

}
