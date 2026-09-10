import java.util.*;

class Solution {

    int[] count;
    int[] index;
    int[] temp;

    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;

        count = new int[n];
        index = new int[n];
        temp = new int[n];

        // Store original indexes
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        mergeSort(nums, 0, n - 1);

        List<Integer> ans = new ArrayList<>();

        for (int x : count) {
            ans.add(x);
        }

        return ans;
    }

    void mergeSort(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    void merge(int[] nums, int left, int mid, int right) {

        int i = left;
        int j = mid + 1;
        int k = left;

        int rightCount = 0;

        while (i <= mid && j <= right) {

            if (nums[index[j]] < nums[index[i]]) {

                // Right element is smaller
                temp[k] = index[j];

                rightCount++;
                j++;

            } else {

                // All previously taken right elements
                // are smaller than this left element
                temp[k] = index[i];

                count[index[i]] += rightCount;

                i++;
            }

            k++;
        }

        // Remaining left elements
        while (i <= mid) {

            temp[k] = index[i];

            count[index[i]] += rightCount;

            i++;
            k++;
        }

        // Remaining right elements
        while (j <= right) {

            temp[k] = index[j];

            j++;
            k++;
        }

        // Copy sorted indexes back
        for (int x = left; x <= right; x++) {
            index[x] = temp[x];
        }
    }
}