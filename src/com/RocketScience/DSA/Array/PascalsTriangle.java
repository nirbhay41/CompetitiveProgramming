package com.RocketScience.DSA.Array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> list = generate(5);
        list.forEach(System.out::println);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        pascalTriangle.add(new ArrayList<>());
        pascalTriangle.get(0).add(1);

        for(int rowNum = 1;rowNum < numRows;rowNum++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = pascalTriangle.get(rowNum-1);

            row.add(1);

            for(int i = 1;i<rowNum;i++){
                row.add(prevRow.get(i-1) + prevRow.get(i));
            }

            row.add(1);
            pascalTriangle.add(row);
        }
        return pascalTriangle;
    }
}
