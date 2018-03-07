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
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String str : wordDict) {
                if (str.length() <= i) {
                    if (f[i - str.length()]) {
                        if (s.substring(i - str.length(), i).equals(str)) {
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[s.length()];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }

    public static void main(String[] args) {
        WordBreak w = new WordBreak();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("net");
        wordDict.add("suite");
        System.out.println(w.wordBreak("netsuite", wordDict));
    }

}
