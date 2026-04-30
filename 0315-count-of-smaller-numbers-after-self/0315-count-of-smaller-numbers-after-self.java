import java.util.*;

class Solution {
    private int[] counts;
    private int[] indexes;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        counts = new int[n];
        indexes = new int[n];

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, 0, n - 1);

        List<Integer> result = new ArrayList<>();
        for (int count : counts) {
            result.add(count);
        }

        return result;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] newIndexes = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (nums[indexes[j]] < nums[indexes[i]]) {
                newIndexes[k++] = indexes[j++];
                rightCount++;
            } else {
                counts[indexes[i]] += rightCount;
                newIndexes[k++] = indexes[i++];
            }
        }

        while (i <= mid) {
            counts[indexes[i]] += rightCount;
            newIndexes[k++] = indexes[i++];
        }

        while (j <= right) {
            newIndexes[k++] = indexes[j++];
        }

        // Copy back
        System.arraycopy(newIndexes, 0, indexes, left, newIndexes.length);
    }
}