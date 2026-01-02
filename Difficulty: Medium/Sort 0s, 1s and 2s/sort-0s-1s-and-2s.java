class Solution {
    public void sort012(int[] arr) {
        // code here
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // Swap arr[low] and arr[mid]
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                    break;
                    
                case 1:
                    // 1 is in the right place, just move the mid pointer
                    mid++;
                    break;
                    
                case 2:
                    // Swap arr[mid] and arr[high]
                    int temp2 = arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = temp2;
                    // Do not increment mid, as the swapped element needs to be checked
                    high--;
                    break;
            }
        }
    }
}