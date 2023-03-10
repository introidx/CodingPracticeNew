package dp.striver;

public class dp26_PrintLongestCommonSubsequence {


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

    static void lcsPrint(String s1, String s2) {

        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }

        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }

        int len=dp[n][m];
        int i=n;
        int j=m;

        int index = len-1;
        String str="";
        for(int k=1; k<=len;k++){
            str +="$"; // dummy string
        }
        StringBuilder ss= new StringBuilder(s1);
        StringBuilder str2=new StringBuilder(str);
        while(i>0 && j>0){
            if(ss.charAt(i-1) == s2.charAt(j-1)){
                str2.setCharAt(index,ss.charAt(i-1) );
                index--;
                i--;
                j--;
            }
            else if(ss.charAt(i-1)>s2.charAt(j-1)){
                i--;
            }
            else j--;
        }
        System.out.println(str2);
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "bdgek";

        int n = s1.length();
        int m = s2.length();

        lcs(s1, s2, n,m);
    }
}
