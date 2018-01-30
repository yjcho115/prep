/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.string.medium;

/**
 *
 * @author youngjucho
 * https://leetcode.com/problems/integer-to-roman/discuss/6274
 */
public class IntegertoRoman {

    public String intToRoman(int num) {

        String[][] s
                = {
                    {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                    {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                    {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                    {"", "M", "MM", "MMM"},};
        return s[3][num/1000]+ s[2][num/100] + s[1][num/10] + s[0][num];
    }
}
