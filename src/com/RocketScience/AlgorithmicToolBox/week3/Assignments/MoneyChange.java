package com.RocketScience.week3.Assignments;

import java.util.Scanner;

public class MoneyChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        int temp = n,count = 0;
        while(res < n) {
            if (temp >= 10) {
                res += 10;
                temp -= 10;
            } else if (temp >= 5) {
                res += 5;
                temp -= 5;
            } else {
                res += 1;
                temp -= 1;
            }
            count++;
        }
        System.out.println(count);
    }
}
