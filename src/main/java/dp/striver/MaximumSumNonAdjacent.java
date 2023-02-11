package dp.striver;

import java.util.Arrays;

/**
 * Created by PRAKASH RANJAN on 10-02-2023
 */
public class MaximumSumNonAdjacent {

    public static void main(String[] args) {

    }

    public static void helper(){
        int[] arr = {1,2,3,4,5,5,6,7};
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        //System.out.println(maximumSumNonAdjacent2(n-1, arr, dp));
        //System.out.println(maximumSumNonAdjacent3(arr));
        System.out.println(Math.max(
                maximumSumNonAdjacent4Circular(arr, 0, n-1),
                maximumSumNonAdjacent4Circular(arr, 1, n)
        ));
    }

    // memoization
    public static int maximumSumNonAdjacent(int index , int[] arr, int[] dp){

        if (index == 0) return arr[index];
        // 1 -2= -1
        if(index < 0) return 0;
        if(dp[index] != -1) return dp[index];

        int pick = arr[index] + maximumSumNonAdjacent(index -2, arr, dp);
        int notPick = 0 + maximumSumNonAdjacent(index -1, arr , dp);

        dp[index] = Math.max(pick, notPick);
        return dp[index];
    }

    // tabulation
    public static int maximumSumNonAdjacent2(int index , int[] arr, int[] dp){
        dp[0] = arr[0];
        //int neg = 0;

        for (int i =1; i < arr.length; i++){
            int pick = arr[i] + ((i > 1) ? dp[i -2] : 0);
            int notPick = 0 + dp[i-1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[dp.length -1];
    }

    // two pointer
    public static int maximumSumNonAdjacent3(int[] arr){
        int prev1 = arr[0];
        int prev2 = 0;

        for (int i =1; i < arr.length; i++){
            int pick = arr[i] + ((i > 1) ? prev2 : 0);
            int notPick = 0 + prev1;

            prev2 = prev1;
            prev1 = Math.max(pick, notPick);
        }

        return prev1;
    }

    // two pointer
    public static int maximumSumNonAdjacent4Circular(int[] arr, int start, int end){
        int prev1 = ((start == 0) ? arr[0] : 0);
        int prev2 = 0;

        for (int i =start; i < end; i++){
            int pick = arr[i] + ((i > 1) ? prev2 : 0);
            int notPick = 0 + prev1;

            prev2 = prev1;
            prev1 = Math.max(pick, notPick);
        }

        return prev1;
    }
}
