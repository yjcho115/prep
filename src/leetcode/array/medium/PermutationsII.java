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
public class PermutationsII {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteUnique(nums, 0, result);
        return result;
    }
    
    public void permuteUnique(int[] nums, int start, List<List<Integer>> result) {
        if (start >= nums.length) {
            List<Integer> list = convertToList(nums);
            result.add(list);
        }
        
        for (int i=start; i<nums.length; i++) {
            if (containDuplicate(nums, start, i)) {
                swap(nums, start, i);
                permuteUnique(nums, start+1, result);
                swap(nums, start, i);
            }
        }
    }
    
    public void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public List<Integer> convertToList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            list.add(nums[i]);
        }
        return list;
    }
    
    public boolean containDuplicate(int[] nums, int start, int end) {
        for (int i=start; i<end; i++) {
            if (nums[i] == nums[end])
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        PermutationsII p = new PermutationsII();
        int[] nums = {1, 1, 2};
        System.out.println(p.permuteUnique(nums));
    }
    
}
