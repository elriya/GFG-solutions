import java.util.*;

class Solution {
    private long[] tree;
    private int n;

    private long gcd(long a, long b) {
        while (b != 0) {
            a %= b;
            long temp = a;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return (a * b) / gcd(a, b);
    }

    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, 2 * node, start, mid);
        build(arr, 2 * node + 1, mid + 1, end);
        tree[node] = lcm(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) update(2 * node, start, mid, idx, val);
        else update(2 * node + 1, mid + 1, end, idx, val);
        tree[node] = lcm(tree[2 * node], tree[2 * node + 1]);
    }

    private long query(int node, int start, int end, int L, int R) {
        if (R < start || end < L) return 1; 
        if (L <= start && end <= R) return tree[node];
        
        int mid = (start + end) / 2;
        long leftLcm = query(2 * node, start, mid, L, R);
        long rightLcm = query(2 * node + 1, mid + 1, end, L, R);
        return lcm(leftLcm, rightLcm);
    }

    public ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {
        n = arr.length;
        tree = new long[4 * n];
        build(arr, 1, 0, n - 1);

        ArrayList<Long> results = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1) {
                update(1, 0, n - 1, q[1], q[2]);
            } else {
                results.add(query(1, 0, n - 1, q[1], q[2]));
            }
        }
        return results;
    }
}