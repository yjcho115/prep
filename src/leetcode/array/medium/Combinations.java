/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author youngjucho
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || n < k )
            return result;
        List<Integer> current = new ArrayList<>();
        dfs (result, current, n, k, 1) ;
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> current, int n, int k, int start) {
        if (current.size() == k) {
            List<Integer> temp = new ArrayList<>(current);
            result.add(temp);
            return;
        }
            
        for (int i=start; i<=n; i++) {
            current.add(i);
            dfs(result, current, n, k, i+1);
            current.remove(current.size()-1);
        }
    }
    
    public static void main (String[] args) {
        Combinations c = new Combinations();
        System.out.println(c.combine(4, 2));
    }
}
