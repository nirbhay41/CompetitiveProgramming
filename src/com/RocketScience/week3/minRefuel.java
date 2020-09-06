package com.RocketScience.week3;

import java.util.Scanner;

public class minRefuel {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int dist = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] pos = new int[n+2];
        pos[0] = 0;
        for(int i = 1;i<pos.length-1;i++){
            pos[i] = sc.nextInt();
        }
        pos[pos.length-1] = dist;
        System.out.println(minRefill(pos,n,m));
    }
    private static int minRefill(int[] arr,int n,int m){
        int noOfRefills = 0,currentRefill = 0,lastRefill;
        while(currentRefill <= n){
            lastRefill = currentRefill;
            while (currentRefill <= n && arr[currentRefill + 1] - arr[lastRefill] <= m){
                currentRefill++;
            }
            if(lastRefill == currentRefill) return -1;
            if (currentRefill <= n) noOfRefills++;
        }
        return noOfRefills;
    }
}
