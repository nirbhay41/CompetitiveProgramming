package com.RocketScience.DSA.Array;

//Very Important Problem
public class RearrangeArrayAlternately {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        rearrange(a);
        for (int i : a) {
            System.out.print(i+" ");
        }
    }

    //Time: O(N)   Space: O(1)
    public static void rearrange(int[] a){
        int n = a.length;

        int min_idx = 0,max_idx = n-1;
        int key_element = a[n-1] + 1;

        //Encoding
        for(int i = 0;i<n;i++){
            if((i&1) == 0){
                a[i] += (a[max_idx] % key_element) * key_element;
                max_idx--;
            }else{
                a[i] += (a[min_idx] % key_element) * key_element;
                min_idx++;
            }
        }

        for(int i = 0;i<n;i++)
            a[i] = a[i]/key_element;
    }
}
