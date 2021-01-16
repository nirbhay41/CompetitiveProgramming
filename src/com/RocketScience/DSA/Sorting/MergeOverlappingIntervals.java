package com.RocketScience.DSA.Sorting;

import java.util.Arrays;

class Interval implements Comparable<Interval>{
    int start,end;

    Interval(int s,int e){
        start = s;
        end = e;
    }
    @Override
    public int compareTo(Interval interval) {
        return (this.start - interval.start);
    }
}

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        Interval[] a = {new Interval(5,10),new Interval(3,15),new Interval(18,30),
                        new Interval(2,7)};
    }

    public static void merge(Interval[] a){
        Arrays.sort(a); // sort by increasing start time
        int res = 0;

        for(int i = 1;i<a.length;i++){
            if(a[res].end >= a[i].start){   // check if current interval overlaps with previous merged interval
                a[res].start = Math.min(a[res].start,a[i].start); // if do then merge them
                a[res].end = Math.max(a[res].end,a[i].end);
            }else{
                res++; // if doesn't overlap then put that interval in the res list
                a[res] = a[i];
            }
        }

        for(int i = 0;i<=res;i++){
            System.out.printf("%d  ----->  %d\n",a[i].start,a[i].end);
        }
    }
}
