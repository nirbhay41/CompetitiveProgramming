package com.RocketScience.DSA.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class ROTI_SPOJ {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();

        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int p = sc.nextInt();
        int n = sc.nextInt();
        int[] cooks = new int[n];
        for (int i = 0; i < n; i++)
            cooks[i] = sc.nextInt();
        Arrays.sort(cooks);

        int low = 0;
        int high = cooks[n-1] * p * (p + 1) / 2;
        int mid, ans = -1;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (check(cooks, n, p, mid)) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        System.out.println(ans);
    }

    private static boolean check(int[] cooks, int n, int p, int time) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            int t = 0;
            int next_time = cooks[i];
            while(t + next_time<=time)
            {
                num += 1;
                t += next_time;
                next_time += cooks[i];
                if(num >= p)
                    return true;
            }
        }
        return false;
    }
}
