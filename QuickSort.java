import java.util.Arrays;

public class QuickSort {
    static public void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static public int partition(int[] arr , int low,int high){
        int pivot = arr[low];
        int i = low;
        int j = high;

        while(i < j){
            while(arr[i] <= pivot && i < high){
                i++;
            }
            while(arr[j] > pivot && j > low){
                j--;
            }
            if(i < j) swap(i, j, arr);
        }

        swap(low, j, arr); // place pivot at correct position
        return j;
    }

    static public void quickSort(int[] arr,int low,int high){
        if(low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);   // sort left part
            quickSort(arr, pi+1, high);  // sort right part
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,4,1,2,3};
        int n = arr.length;
        quickSort(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }
}

/*
🔹 Dry Run for arr = {5, 4, 1, 2, 3}

Initial: [5, 4, 1, 2, 3]

Partition 1:
- pivot = 5 (first element)
- i scans right until it stops at last element
- j scans left until it stops before pivot
- swap(low=0, j=4) → [3, 4, 1, 2, 5]
👉 Pivot 5 placed at correct position

Now quickSort left half [3, 4, 1, 2], right half [ ].

Partition 2 (on [3, 4, 1, 2]):
- pivot = 3
- i moves right, j moves left
- After swaps → [2, 1, 3, 4, 5]
👉 Pivot 3 placed correctly

Partition 3 (on [2, 1]):
- pivot = 2
- Swap with j
- Result → [1, 2, 3, 4, 5]
👉 Pivot 2 placed correctly

Remaining subarrays are of size 1 → already sorted.

✅ Final Sorted Array: [1, 2, 3, 4, 5]

🔹 Time Complexity:
- Best Case: O(n log n)
- Average Case: O(n log n)
- Worst Case: O(n^2) (when pivot always picks smallest or largest element, e.g. sorted input)
- Space Complexity: O(log n) (recursion stack)

🔹 Note:
- QuickSort is **not stable** (relative order of equal elements may change).
- In practice, QuickSort is faster than MergeSort due to in-place partitioning.
*/
