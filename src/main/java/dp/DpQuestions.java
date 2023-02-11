package dp;

import java.util.Arrays;
import java.util.HashMap;

public class DpQuestions {

    public static void main(String[] args) {
        helper();

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

    public double knightProbability(int N, int K, int r, int c) {
        double[][] curr = new double[N][N];
        double[][] next = new double[N][N];
        int[][] range= {{-2,1},{-1, 2},{1,2} , {2,1} , {2 -1} , {1,-2}, {-1,-2}, {-2, -1}};
        curr[r][c] = 1;

        for (int move = 0; move < K; move++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (curr[i][j] != 0) {
                        int ni = 0;
                        int nj = 0;

                        for (int[] temp : range){
                            ni = i - temp[0];
                            nj = j - temp[1];

                            if (isInside(ni, nj, N)) {
                                next[ni][nj] += (1 / 8.0) * curr[i][j];
                            }
                        }
                    }
                }
            }
            curr = next;
            next = new double[N][N];
        }
        double sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += curr[i][j];
            }
        }
        return sum;
    }

    public static boolean isInside(int r, int c, int N) {
        if (r >= N || r < 0 || c < 0 || c >= N) return false;
        return true;
    }


    public int maxSubArraySumCircular(int[] nums) {
        int totalSum = nums[0];
        int currMax = nums[0];
        int maxSoFar = nums[0];

        int currMin = nums[0];
        int minSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            totalSum += nums[i];

            currMax = Math.max(nums[i], nums[i] + currMax);
            maxSoFar = Math.max(currMax, maxSoFar);

            currMin = Math.min(nums[i], nums[i] + currMin);
            minSoFar = Math.min(currMin, minSoFar);
        }

        // if maxSoFar is +ve, means all numbers are not -ve in nums
        if (maxSoFar > 0) {
            return Math.max(maxSoFar, totalSum - minSoFar);
        }

        return maxSoFar;

    }

    // max product sub array
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 0; i < nums.length; i++) {
            // if nums[i] is -ve swap currMax and currMin
            if (nums[i] < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(nums[i], nums[i] * currMax);
            currMin = Math.min(nums[i], nums[i] * currMin);

            max = Math.max(max, currMax);
        }
        return max;
    }

    //    Longest Increasing subsequence
    //    Input: nums = [10,9,2,5,3,7,101,18]
    //    Output: 4
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;

    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int size = 0;

        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (dp[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            dp[i] = x;
            if (i == size) size++;
        }

        return size;
    }

    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (m < n) {
            return lcsBottomUp(s2, s1, n, m);
        }

        return lcsBottomUp(s1, s2, m, n);

    }

    private int lcsBottomUp(String s1, String s2, int m, int n) {
        if (n == 0 || m == 0) return 0;

        int[][] arr = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }

            }
        }
        return arr[m][n];

    }

    private int lcsBottomUpRecursive(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) return 0;

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcsBottomUp(s1, s2, m - 1, n - 1);
        }

        return 1 + Math.max((lcsBottomUpRecursive(s1, s2, m - 1, n)),
                lcsBottomUpRecursive(s1, s2, m, n - 1));
    }

    //    Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
//    Output: 4
    public int findMaxForm(String[] strs, int m, int n) {
        int res = 0;
        for (String s : strs) {
            int ones = countOnes(s);
            int zeros = countZeros(s);

            if (zeros <= m && ones <= n) {
                res++;
            }
        }
        return res;

    }

    private int countOnes(String s) {
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }
        return ones;
    }

    private int countZeros(String s) {
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeros++;
            }
        }
        return zeros;
    }

    //Input: coins = [1,2,5], amount = 11
    //Output: 3
    //Explanation: 11 = 5 + 5 + 1
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }

        if (total % 2 != 0) return false;

        return canPartition(nums, 0, 0, total, new HashMap<String, Boolean>());
    }

    private boolean canPartition(int[] nums, int index, int currSum, int total, HashMap<String,
            Boolean> state) {
        String current = index + " " + currSum;
        if (state.containsKey(current)) {
            return state.get(current);
        }

        if (currSum * 2 == total) return true;
        if (currSum > total / 2 || index > nums.length) return false;

        Boolean foundPartition = canPartition(nums, index + 1, currSum, total, state) ||
                canPartition(nums, index + 1, currSum + nums[index], total, state);
        state.put(current, foundPartition);
        return foundPartition;
    }
}
