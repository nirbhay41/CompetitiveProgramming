package com.RocketScience.DSA.BinarySearch;

import java.util.Arrays;

//https://www.geeksforgeeks.org/weighted-job-scheduling/
//Dynamic Programming Problem
//Time Complexity O(nLogn)
class Job implements Comparable<Job>{
    Integer start,finish,profit;

    public Job(int start, int finish, int profit) {
        this.start = start;
        this.finish = finish;
        this.profit = profit;
    }

    @Override
    public int compareTo(Job job) {
        return this.finish.compareTo(job.finish);
    }
}

public class WeightedJobScheduling {
    public static void main(String[] args) {
        Job[] jobs = {new Job(1, 2, 50), new Job(6, 10, 70),
                new Job(3, 7, 30), new Job(2, 11, 100),
        new Job(5,15,20)};

        System.out.println("Optimal Profit is: "+schedule(jobs));
    }

    private static int schedule(Job[] jobs) {
        Arrays.sort(jobs);

        /* Create an array to store solutions of sub problems.
           table[i] stores the profit for jobs till jobs[i] (including jobs[i])*/
        int n = jobs.length;
        int[] table = new int[n];
        table[0] = jobs[0].profit;

        for(int i = 1;i<n;i++){
            // Find profit including the current job
            int inclProfit = jobs[i].profit;
            int l = binarySearch(jobs,i);
            if(l != -1)
                inclProfit += table[l];
            table[i] = Math.max(inclProfit,table[i-1]);
        }
        return table[n-1];
    }

    private static int binarySearch(Job[] jobs, int index) {
        int low = 0,high = index-1,mid;

        while (low <= high){
            mid = low + (high-low)/2;

            if(jobs[mid].finish <= jobs[index].start){
                if(jobs[mid+1].finish <= jobs[index].start)
                    low = mid+1;
                else return mid;
            }else high = mid-1;
        }
        return -1;
    }
}
