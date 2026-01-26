import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(0, arr, result);
        return result;
    }

    private static void backtrack(int start, int[] arr, ArrayList<ArrayList<Integer>> result) {
        if (start == arr.length) {
            ArrayList<Integer> permutation = new ArrayList<>();
            for (int num : arr) permutation.add(num);
            result.add(permutation);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            
            backtrack(start + 1, arr, result);
            
            swap(arr, start, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}