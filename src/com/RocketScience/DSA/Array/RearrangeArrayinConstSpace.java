package com.RocketScience.DSA.Array;

public class RearrangeArrayinConstSpace {
    public static void main(String[] args) {
        long[] a = {4,0,2,1,3};
        arrange(a,a.length);
        for (long x : a) {
            System.out.print(x+" ");
        }
    }

    static void arrange(long[] a, int n){
        long keyElement;
        long max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++)
            if(max < a[i])
                max = a[i];

        keyElement = max+1;

        //Encode the values
        long temp;

        for(int i = 0;i<n;i++){
            temp = a[(int)a[i]];
            if(temp >= keyElement){
                temp = temp%keyElement;
            }

            a[i] += (temp*keyElement);
        }

        for(int i = 0;i<n;i++){
            a[i] = a[i]/keyElement;
        }
    }
}
