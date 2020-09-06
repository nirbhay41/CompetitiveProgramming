package com.RocketScience.week3.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> a = new ArrayList<>(n);
        for(int i = 0;i<n;i++){
            a.add(sc.next());
        }
        printLargestNumber(a);
    }

    private static void printLargestNumber(List<String> a) {
        a.sort((X, Y) -> {
            String XY = X + Y;
            String YX = Y + X;
            return (XY.compareTo(YX) > 0) ? -1 : 1;
        });
        for (String s : a) {
            System.out.print(s);
        }
    }
}
