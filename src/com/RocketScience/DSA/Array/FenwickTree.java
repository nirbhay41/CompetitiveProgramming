package com.RocketScience.DSA.Array;

public class FenwickTree {
    private int[] tree;

    public FenwickTree(int n){
        tree = new int[n+1];
    }

    public int sum(int idx){
        idx++;
        int sum = 0;
        while (idx > 0){
            sum += tree[idx];
            idx -= (idx & -idx);  // idx = idx & (idx-1);  Remove the last set bit from idx
        }

        return sum;
    }

    public void update(int idx,int val){
        idx++;
        while(idx < tree.length){
            tree[idx] += val;
            idx += (idx & -idx);  // add the last set bit to idx
        }
    }

    public int rangeSum(int l,int r){
        return sum(r) - sum(l-1);
    }

    public void rangeUpdate(int l,int r,int val){
        update(l,val);
        update(r+1,-val);
    }
}
