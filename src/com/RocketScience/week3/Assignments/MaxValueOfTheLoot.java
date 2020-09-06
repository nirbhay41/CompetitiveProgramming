package com.RocketScience.week3.Assignments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MaxValueOfTheLoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        int[] val = new int[n];
        int[] wt = new int[n];
        for(int i = 0;i<n;i++){
            val[i] = sc.nextInt();
            wt[i] = sc.nextInt();
        }
        double maxValue = getMaxValue(wt,val,W);
        System.out.println(maxValue);
    }

    private static double getMaxValue(int[] wt, int[] val, int W) {
        Items[] items = new Items[wt.length];
        for(int i =0;i< items.length;i++){
            items[i] = new Items(wt[i],val[i],i);
        }
        Comparator<Items> comp = (Items t1, Items t2) -> t1.cost.compareTo(t2.cost);
        Arrays.sort(items, comp.reversed());

        double totalValue = 0;
        for(Items i : items){
            int currentWt = (int)i.w;
            int currentValue = (int)i.v;
            if(W - currentWt >= 0){
                W = W - currentWt;
                totalValue += currentValue;
            }else {
                double fraction = (double)W / (double)currentWt;
                totalValue += currentValue * fraction;
                W = (int) (W - (currentWt*fraction));
                break;
            }
        }
        return totalValue;
    }
}

class Items{
    public Double cost;
    public double w,v;
    public int index;

    public Items(double w, double v, int index) {
        this.w = w;
        this.v = v;
        this.index = index;
        cost = v / w;
    }
}
