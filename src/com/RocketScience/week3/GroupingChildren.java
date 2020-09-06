package com.RocketScience.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupingChildren {
    public static void main(String[] args) {
        var list = pointsCoverdSorted(new double[]{5,5.2,5.5,5.8,6,8,7.7,6.5});
        for (List<Double> doubles : list) {
            System.out.println(doubles);
        }
    }
    private static List<List<Double>> pointsCoverdSorted(double[] points){
        Arrays.sort(points);
        List<List<Double>> R = new ArrayList<>();
        List<Double> temp = new ArrayList<>(2);
        int i = 0;
        while(i < points.length){
            temp.add(points[i]);
            temp.add(points[i]+1);
            R.add(temp);
            i++;
            while (i < points.length && points[i] <= temp.get(1))
                i++;
            temp.clear();
        }
        return R;
    }
}
