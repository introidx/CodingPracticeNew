package dp.striver;

import java.util.Arrays;

public class dp14_subSetSumEqualToTarget {

    // Time Complexity: O(2^N)
    public boolean f(int[] arr, int index, int target) {
        if (target == 0) return true;
        if (index == 0) return arr[0] == target;

        boolean notTake = f(arr, index - 1, target);
        boolean take = false;
        if (arr[index] <= target) {
            take = f(arr, index - 1, target - arr[index]);
        }
        return take || notTake;
    }

    /**
     * Time Complexity: O(N*K)
     * Reason: There are N*K states therefore at max ‘N*K’ new problems will be solved.
     * Space Complexity: O(N*K) + O(N)
     * Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*K)).
     */
    static boolean subsetSumUtil(int ind, int target, int[] arr, int[][] dp) {
        if (target == 0)
            return true;

        if (ind == 0)
            return arr[0] == target;

        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);

        boolean taken = false;
        if (arr[ind] <= target)
            taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);
        dp[ind][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }

    static boolean subsetSumToK(int n, int k, int[] arr) {

        int dp[][] = new int[n][k + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return subsetSumUtil(n - 1, k, arr, dp);
    }

    // tabulation
    static boolean subsetSumToK11(int n, int k,int[] arr){
        boolean dp[][]= new boolean[n][k+1];

        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }

        if(arr[0]<=k)
            dp[0][arr[0]] = true;

        for(int ind = 1; ind<n; ind++){
            for(int target= 1; target<=k; target++){

                boolean notTaken = dp[ind-1][target];

                boolean taken = false;
                if(arr[ind]<=target)
                    taken = dp[ind-1][target-arr[ind]];

                dp[ind][target]= notTaken||taken;
            }
        }

        return dp[n-1][k];
    }

    public static void main(String args[]) {

        int arr[] = {1, 2, 3, 4};
        int k = 4;
        int n = arr.length;

        if (subsetSumToK(n, k, arr))
            System.out.println("Subset with given target found");
        else
            System.out.println("Subset with given target not found");
    }
}
