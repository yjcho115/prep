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

    private double rate;
    private double limit;
    private double tax;

    public TaxBracket(double rate, double limit, double tax) {
        this.rate = rate;
        this.limit = limit;
        this.tax = tax;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getRate() {
        return rate;
    }

    public double getLimit() {
        return limit;
    }

    public double getTax() {
        return tax;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.rate) ^ (Double.doubleToLongBits(this.rate) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.limit) ^ (Double.doubleToLongBits(this.limit) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.tax) ^ (Double.doubleToLongBits(this.tax) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TaxBracket other = (TaxBracket) obj;
        if (Double.doubleToLongBits(this.rate) != Double.doubleToLongBits(other.rate)) {
            return false;
        }
        if (Double.doubleToLongBits(this.limit) != Double.doubleToLongBits(other.limit)) {
            return false;
        }
        if (Double.doubleToLongBits(this.tax) != Double.doubleToLongBits(other.tax)) {
            return false;
        }
        return true;
    }

}
