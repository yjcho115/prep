/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author youngjucho
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        dfs(candidates, target, 0, current, result);
        return result;
    }

    public void dfs(int[] candidates, int target, int j, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(current);
            result.add(temp);
            return;
        }

        for (int i = j; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }
            current.add(candidates[i]);
            dfs(candidates, target - candidates[i], i , current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        int[] candidates = {2,3,6,7};
        System.out.println(c.combinationSum(candidates, 7));
    }
}
