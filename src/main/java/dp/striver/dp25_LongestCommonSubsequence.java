package dp.striver;

public class dp25_LongestCommonSubsequence {

    // recursion
    public static int lcs(String s1, String s2, int n, int m) {
        // Time Complexity -> O(2 ^ n * 2 ^ m)
        // base case
        if (n == 0 || m == 0) {
            return 0;
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + lcs(s1, s2, n - 1, m - 1);
        }

        return Math.max(lcs(s1, s2, n - 1, m), lcs(s1, s2, n, m - 1));
    }
    /**
     * ce
     * ec
     * 1 s1 -> c  s2 -> ec
     * 2 s1 -> ce  s2 -> e
     */

    public int lcsBottomUp(String s1, String s2, int n, int m) {
        if(n == 0 || m == 0) {
            return 0;
        }

        int[][] arr = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {

                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
                }

            }
        }

        return arr[n][m];
    }
}
