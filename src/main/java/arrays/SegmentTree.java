package arrays;

import java.util.Scanner;

/**
 * Created by PRAKASH RANJAN on 24-06-2022
 */
public class SegmentTree {
    static int[] arr = new int[100005];
    static int[] seg = new int[4 * 100005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        build(0, 0, n - 1);
        int l, r;
        l = sc.nextInt();
        r = sc.nextInt();
        int maxInRange = query(0, 0, n - 1, l, r);
        System.out.println(maxInRange);
    }

    private static void build(int ind, int low, int high) {
        if (low == high) {
            seg[ind] = arr[low];
            return;
        }
        int mid = (low + high) / 2;
        build(2 * ind + 1, low, mid);
        build(2 * ind + 2, mid + 1, high);
        seg[ind] = Math.max(seg[2 * ind + 1], seg[2 * ind + 2]);
    }

    private static int query(int ind, int low, int high, int l, int r) {
        if (low >= l && high <= r) {
            return seg[ind];
        }
        if (low > r || high < l) return Integer.MIN_VALUE;
        int mid = (low + high) / 2;
        int left = query(2 * ind + 1, low, mid, l, r);
        int right = query(2 * ind + 2, mid + 1, high, l, r);
        return Math.max(left, right);
    }
}
