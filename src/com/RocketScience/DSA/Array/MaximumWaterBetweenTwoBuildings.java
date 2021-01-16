package com.RocketScience.DSA.Array;

public class MaximumWaterBetweenTwoBuildings {
    public static void main(String[] args) {
        System.out.println(maxWater(new int[]{2,7,1,6,5,3}, 6));
    }

    //Two Pointer Approach
    static int maxWater(int[] height, int n) {
        int i = 0,j = n-1,max = -1;

        while(i < j){
            max = Math.max(max,Math.min(height[i],height[j])*(j-i-1));

            if(height[i] < height[j]) i++;
            else if(height[i] > height[j]) j--;
            else{
                i++;
                j--;
            }
        }

        return max;
    }
}
