/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.array.medium;

/**
 *
 * @author youngjucho
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
    
    public static void main (String[] args) {
        //int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height = {1, 8, 6, 2};
        ContainerWithMostWater c = new  ContainerWithMostWater();
        System.out.println(c.maxArea(height));
    }
  
    
}
