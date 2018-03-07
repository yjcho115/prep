/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.string.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author youngjucho
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs (result, "", n, n) ;
        return result;
    }
    
    public void dfs(List<String> result, String s, int left, int right) {
        if (left > right)
            return ;
        
        if (left == 0 && right ==0) 
            result.add(s);
        
        if (left > 0)
            dfs(result, s+"(", left-1, right);
        
        if (right > 0)
            dfs(result, s+")", left, right-1);
    }
    
    public static void main (String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        System.out.print(g.generateParenthesis(2));
    }
    
}
