/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.array.medium;

import java.util.Arrays;

/**
 *
 * @author youngjucho https://leetcode.com/problems/3sum-closest/discuss/7872
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int sum = nums[0] + nums[1] + nums[nums.length - 1];
        int closestSum = sum;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    sum = nums[i] + nums[left] + nums[right];
                    if (sum < target) {
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    } else if (sum > target) {
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else {
                        return sum;
                    }
                    if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                        closestSum = sum;
                    }
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        ThreeSumClosest t = new ThreeSumClosest();
        int[] nums = {-1, 2, 1, -4};
        System.out.println(t.threeSumClosest(nums, 1));
    }
}
