/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author youngjucho
 */
public class Purchase {

    int number;
    int totalPrice;
    int unitPrice;

    public Purchase(int number, int unitPrice) {
        this.number = number;
        this.totalPrice = unitPrice;
        this.unitPrice = this.totalPrice/this.number;
    }
}
