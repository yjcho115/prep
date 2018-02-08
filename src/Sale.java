/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author youngjucho
 */
public class Sale {

    int number;
     int totalPrice;
    int unitPrice;
   

    public Sale(int number, int totalPrice) {
        this.number = number;
        this.totalPrice = totalPrice;
        this.unitPrice = this.totalPrice/this.number;
    }
}
