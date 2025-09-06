package Sorting;
class BubbleSort {
    static public void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void bubble(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){ // n-i-1 because we fill from the last element
                if(arr[j] > arr[j+1])
                    swap(j, j+1, arr);
            }
        }
    }
      static void bubbleSortUsingRecursion(int[] arr, int n) {
        // Base case
        if (n == 1) return;

        // One pass of bubble sort
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(i, i + 1, arr);
            }
        }

        // Recursively call bubbleSort for remaining array
         bubbleSortUsingRecursion(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        BubbleSort obj = new BubbleSort();
        obj.bubble(arr);
  
        System.out.println(java.util.Arrays.toString(arr));
    }
}

/*
🔹 Dry Run for arr = {5, 4, 3, 2, 1}

Initial: [5, 4, 3, 2, 1]

Pass 1 (i = 0):
- Compare 5 and 4 → swap → [4, 5, 3, 2, 1]
- Compare 5 and 3 → swap → [4, 3, 5, 2, 1]
- Compare 5 and 2 → swap → [4, 3, 2, 5, 1]
- Compare 5 and 1 → swap → [4, 3, 2, 1, 5]
👉 Largest element 5 is placed at the end

Pass 2 (i = 1):
- Compare 4 and 3 → swap → [3, 4, 2, 1, 5]
- Compare 4 and 2 → swap → [3, 2, 4, 1, 5]
- Compare 4 and 1 → swap → [3, 2, 1, 4, 5]
👉 Next largest element 4 is placed at second last

Pass 3 (i = 2):
- Compare 3 and 2 → swap → [2, 3, 1, 4, 5]
- Compare 3 and 1 → swap → [2, 1, 3, 4, 5]
👉 Next largest element 3 is placed correctly

Pass 4 (i = 3):
- Compare 2 and 1 → swap → [1, 2, 3, 4, 5]
👉 Next largest element 2 is placed correctly

Pass 5 (i = 4):
- No swaps needed → array already sorted

✅ Final Sorted Array: [1, 2, 3, 4, 5]

🔹 Time Complexity:
- Worst Case: O(n^2)
- Average Case: O(n^2)
- Best Case: O(n) (if optimized with a flag to stop early when no swaps happen)
- Space Complexity: O(1) (in-place)

🔹 Note:
- Bubble sort is **stable** (equal elements keep their order).
*/
