
import java.security.InvalidParameterException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author youngjucho
 */
public class ProfitCalc {

    public int calculateProfit(LinkedList<Purchase> purchases, LinkedList<Sale> sales) {
        if (purchases == null || purchases.isEmpty() || sales == null || sales.isEmpty()) {
            throw new InvalidParameterException("Invalid Parameter");
        }
        int profit = 0;
        while (!purchases.isEmpty() && !sales.isEmpty()) {
            Purchase p = purchases.poll();
            Sale s = sales.poll();
            
            if (p.number > s.number) {
                profit += (s.unitPrice - p.unitPrice) * s.number;
                Purchase newPurchase = new Purchase(p.number - s.number, p.unitPrice * (p.number - s.number));
                purchases.addFirst(newPurchase);

            } else if (p.number < s.number) {
                profit += (s.unitPrice - p.unitPrice) * p.number;
                Sale newSale = new Sale(s.number - p.number, s.totalPrice - (s.unitPrice * (s.number - p.number)));
                sales.addFirst(newSale);
            } else {
                profit += (s.unitPrice - p.unitPrice) * s.number;
            }
            
        }
        return profit;
    }
    
     public static void main(String[] args) {
        LinkedList<Purchase> purchases = new LinkedList<>();
        LinkedList<Sale> sales = new LinkedList<>();

        purchases.offer(new Purchase(5, 20));
        purchases.offer(new Purchase(5, 30));

        sales.offer(new Sale(2, 20));
        sales.offer(new Sale(2, 18));
        sales.offer(new Sale(2, 20));

//    purchases.offer(new Purchase(1, 10));
//   purchases.offer(new Purchase(1, 5));
    
//    sales.offer(new Sale(2, 20));
    

        ProfitCalc p = new ProfitCalc();
        System.out.println(p.calculateProfit(purchases, sales));

    }

}
