package com.RocketScience.week3.Assignments;

import java.util.Arrays;
import java.util.Scanner;

public class MaxAdvertisementRevenue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            b[i] = sc.nextInt();
        int res = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            res += a[i] * b[i];
        }
        System.out.println(res);
    }
}
