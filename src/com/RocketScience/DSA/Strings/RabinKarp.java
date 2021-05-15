package com.RocketScience.DSA.Strings;

public class RabinKarp {
    static final int d = 256;
    static final int q = 101;
    public static void main(String[] args) {
        rbSearch("ABCABCDACB", "ABCD");
    }

    public static void rbSearch(String txt,String pat){
        int n = txt.length();
        int m = pat.length();
        int h = 1;

        //Compute (d^m-1)%q
        for(int i = 1;i<m;i++)
            h = (h*d)%q;

        //Compute pattern hash value and text hash value
        int p = 0,t = 0;
        for(int i = 0;i<m;i++){
            p = (p*d + pat.charAt(i))%q;
            t = (t*d + txt.charAt(i))%q;
        }

        //Check for Spurious Hit
        for(int i = 0;i<n-m+1;i++){
            if(p == t){
                boolean flag = true;
                for(int j = 0;j<m;j++){
                    if(txt.charAt(i+j) != pat.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    System.out.print(i+" ");
                }
            }

            //Compute t(i+1) using t(i)
            if(i < n-m){
                t = (d*(t - txt.charAt(i)*h)+txt.charAt(i+m))%q;
                if(t<0) t = t+q;
            }
        }
    }
}
