/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.string.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author youngjucho
 */
public class LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        List<String> result = new ArrayList<>();

        if (digits.equals("")) {
            return result;
        }

        helper(result, new StringBuilder(), digits, 0, map);

        return result;

    }

    public void helper(List<String> result, StringBuilder sb, String digits, int index, Map<Character, char[]> map) {
        if (index >= digits.length()) {
            result.add(sb.toString());
            return;
        }

        char c = digits.charAt(index);
        char[] arr = map.get(c);

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            helper(result, sb, digits, index + 1, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber l = new LetterCombinationsofaPhoneNumber();
        System.out.println(l.letterCombinations("23"));

    }

}
