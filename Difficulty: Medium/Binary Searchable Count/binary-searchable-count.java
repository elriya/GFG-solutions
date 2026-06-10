class Solution {
    int count;

    public int binarySearchable(int[] arr) {
        count = 0;
        dfs(arr, 0, arr.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return count;
    }

    private void dfs(int[] arr, int l, int r, int low, int high) {
        if (l > r) return;

        int mid = (l + r) / 2;

        if (arr[mid] > low && arr[mid] < high) {
            count++;
        }

        // Left subtree: values must be < arr[mid]
        dfs(arr, l, mid - 1, low, Math.min(high, arr[mid]));

        // Right subtree: values must be > arr[mid]
        dfs(arr, mid + 1, r, Math.max(low, arr[mid]), high);
    }
}