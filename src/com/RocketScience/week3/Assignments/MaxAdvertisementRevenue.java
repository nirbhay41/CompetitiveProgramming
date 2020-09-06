package com.RocketScience.week3.Assignments;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaxAdvertisementRevenue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            b[i] = sc.nextInt();
        int res = 0;
        if (n == 1) {
            System.out.println(a[0] * b[0]);
        } else {
            res = 0;
            Arrays.sort(a, Collections.reverseOrder());
            Arrays.sort(b, Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                res += a[i] * b[i];
            }
        }
        System.out.println(res);
    }
}
