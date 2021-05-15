package com.RocketScience.DSA.SlidingWindow_and_PrefixSum;

public class EquilibriamPoint {
    public static void main(String[] args) {
        int[] a = {20,17 ,42, 25, 32 ,32 ,30 ,32 ,37 ,9 ,2, 33, 31, 17, 14, 40,
                9, 12, 36, 21, 8, 33, 6 ,6, 10, 37, 12, 26, 21, 3};
        System.out.println(method2(a));
    }

    // Method - I: Time: O(N) Space: O(N)
    static int getEquil(int[] a){
        int[] prefix_sum = Prefix_Sum.calculate_prefix_sum(a);
        int n = a.length;
        for(int i = 0;i<n;i++){
            if(i == 0){
                if(getSum(prefix_sum,i+1,n-1) == 0){
                    return i;
                }
            }else if(i == n-1){
                if(getSum(prefix_sum,0,i-1) == 0){
                    return i;
                }
            }else{
                int x = getSum(prefix_sum,0,i-1);
                int y = getSum(prefix_sum,i+1,n-1);
                if(x == y)
                    return i;
            }
        }
        return -1;
    }

    static int getSum(int[] prefix_sum,int l, int r){
        return l != 0 ? prefix_sum[r] - prefix_sum[l-1] : prefix_sum[r];
    }

    // Method - II: Time: O(N) Space: O(1)
    static int method2(int[] a){
        int sum1 = 0,sum2 = 0;
        for (int j : a) sum1 += j;

        for(int i = a.length-1;i>= 0;i--){
            if(sum1-a[i] == sum2){
                return i+1;
            }
            sum1 -= a[i];
            sum2 += a[i];
        }
        return -1;
    }
}
