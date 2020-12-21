package com.RocketScience.DSA.Array;

import java.util.ArrayList;

public class StockBuyandSell {
    public static void main(String[] args) {
        stockBuySell(new int[]{100,180,260,310,40,535,695}, 7).forEach(System.out::println);
    }

    //Time Complexity: O(N)
    public static int Profit(int[] a){
        int profit = 0;

        for(int i = 1;i<a.length;i++){
            if(a[i] > a[i-1])
                profit += (a[i] - a[i-1]);
        }
        return profit;
    }

    //Time: O(N)   Space: O(N)
    public static ArrayList<ArrayList<Integer>> stockBuySell(int[] a, int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0;i<n-1;){
            //Finding local minima
            while((i<n-1) && a[i] >= a[i+1])
                i++;

            if(i == n-1)
                break;

            ArrayList<Integer> temp = new ArrayList<>();

            temp.add(i++);

            //Finding local maxima
            while((i<n) && a[i] >= a[i-1])
                i++;
            temp.add(i-1);
            list.add(temp);
        }

        return list;
    }
}
