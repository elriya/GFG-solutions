class Solution {
    public boolean isMaxHeap(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i <= (n - 2) / 2; i++) {
            
            int leftChild = 2 * i + 1;
            if (leftChild < n && arr[i] < arr[leftChild]) {
                return false;
            }
            
            int rightChild = 2 * i + 2;
            if (rightChild < n && arr[i] < arr[rightChild]) {
                return false;
            }
        }
        
        return true;
    }
}