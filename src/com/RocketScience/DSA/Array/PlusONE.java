package com.RocketScience.DSA.Array;

import java.util.Arrays;

public class PlusONE {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9})));
    }
    public static int[] plusOne(int[] digits) {
        for(int i = digits.length-1;i>=0;i--){
            digits[i]++;
            if(digits[i] == 10){
                digits[i] = 0;
            }else{
                return digits;
            }
        }

        int[] R = new int[digits.length+1];
        R[0] = 1;
        System.arraycopy(digits, 0, R, 1, digits.length);

        return R;
    }

}
