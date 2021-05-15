package com.RocketScience.DSA.Array;

import java.util.ArrayList;

public class StockBuyandSell {
    public static void main(String[] args) {
        System.out.println(Profit(new int[]{7, 1, 5, 3, 6, 4}));
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

    //You want to maximize your profit by choosing a single day to buy one stock and choosing
    //a different day in the future to sell that stock.
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int max_profit = 0;

        for(int x : prices){
            if(x < minPrice){
                minPrice = x;
            }else if(x - minPrice > max_profit)
                max_profit = x - minPrice;
        }

        return max_profit;
    }
}
