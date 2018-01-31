/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.dp.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author youngjucho
 */
public class WordBreak {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length()+1];
        f[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            for(String str: wordDict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[s.length()];
    }
    
    public static void main (String[] args) {
        WordBreak w = new WordBreak();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("I");
        wordDict.add("am");
        wordDict.add("Young");
        
        //System.out.println("IamYounguju".substring(0,2));
        System.out.println(w.wordBreak("IamYoung", wordDict));
     }
    
}
