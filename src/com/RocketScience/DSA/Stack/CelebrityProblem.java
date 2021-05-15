package com.RocketScience.DSA.Stack;

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] a = {{0,1,0},{0,0,0},{0,1,0}};
        System.out.println(celebrity(a, a.length));
        System.out.println(findCelebrity(a,a.length));
    }

    //Time: O(N)  Space : O(N)   By using the elimination approach
    public static int celebrity(int[][] a, int n){
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i<n;i++){
            stack.push(i);  // push all rows
        }

        while(stack.size() > 1){
            //pop top 2 persons
            int i = stack.pop();
            int j = stack.pop();

            if(a[i][j] == 1){ // if i knows j then i cannot be a celebrity
                stack.push(j);
            }else{ // if i do not know j then j cannot be a celebrity
                stack.push(i);
            }
        }

        int cand = stack.pop(); // it can be a potential candidate

        //check if it is a celebrity
        for(int i = 0;i<n;i++){
            if(i != cand){
                if(a[i][cand] == 0 || a[cand][i] == 1){
                    return -1;
                }
            }
        }

        return cand;
    }

    //Time : O(N)  Space : O(1)   Two Pointer Approach and elimination
    static int findCelebrity(int[][] a,int n){
        int i = 0;
        int j = n - 1;

        while (i < j){
            if (a[i][j] == 1)
                i++;
            else
                j--;
        }

        for (int k = 0; k < n; k++){
            if (k != i && (a[i][k] == 1 || a[k][i] == 0))
                return -1;
        }

        return i;
    }
}
