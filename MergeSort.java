import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    static public void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> tmp = new ArrayList<>();
        int l = low;
        int r = mid + 1;

        // Merge two sorted halves
        while (l <= mid && r <= high) {
            if (arr[l] <= arr[r]) {
                tmp.add(arr[l]);
                l++;
            } else {
                tmp.add(arr[r]);
                r++;
            }
        }

        // Copy remaining left half
        while (l <= mid) {
            tmp.add(arr[l]);
            l++;
        }

        // Copy remaining right half
        while (r <= high) {
            tmp.add(arr[r]);
            r++;
        }

        // Copy back into original array
        for (int i = low; i <= high; i++) {
            arr[i] = tmp.get(i - low);
        }
    }

    static public void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        int arr[] = {5, 4, 1, 2, 3};
        int n = arr.length;
        mergeSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }
}

/*
🔹 Dry Run for arr = {5, 4, 1, 2, 3}

Initial: [5, 4, 1, 2, 3]

Step 1: Split into two halves
- Left: [5, 4, 1]
- Right: [2, 3]

Step 2: Recursively sort left half [5, 4, 1]
- Split → [5, 4] and [1]
- Sort [5, 4] → [4, 5]
- Merge [4, 5] and [1] → [1, 4, 5]

Step 3: Recursively sort right half [2, 3]
- Split → [2] and [3]
- Merge → [2, 3]

Step 4: Merge [1, 4, 5] and [2, 3]
- Compare 1 & 2 → pick 1 → [1]
- Compare 4 & 2 → pick 2 → [1, 2]
- Compare 4 & 3 → pick 3 → [1, 2, 3]
- Append remaining → [1, 2, 3, 4, 5]

✅ Final Sorted Array: [1, 2, 3, 4, 5]

🔹 Time Complexity:
- Best Case: O(n log n)
- Average Case: O(n log n)
- Worst Case: O(n log n)

🔹 Space Complexity:
- O(n) (extra space for temporary array)

🔹 Note:
- Merge Sort is **stable** (keeps order of equal elements).
- Works efficiently for large datasets, unlike O(n^2) algorithms.
*/
