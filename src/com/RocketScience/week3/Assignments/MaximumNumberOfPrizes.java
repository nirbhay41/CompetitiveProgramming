package com.RocketScience.week3.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumNumberOfPrizes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> res = optimal_summands(n);
        System.out.println(res.size());
        for (Integer i : res) {
            System.out.print(i+ " ");
        }
    }
    public static List<Integer> optimal_summands(int n){
        List<Integer> summands = new ArrayList<>();

        for(int k = n, l = 1;k>0;l++){
            if (k <= 2 * l) {
                summands.add(k);
                k -= k;
            } else {
                summands.add(l);
                k -= l;
            }
        }
        return summands;
    }
}
