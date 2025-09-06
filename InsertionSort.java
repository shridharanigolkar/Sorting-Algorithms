public class InsertionSort {
    static public void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void insertion(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            int j = i;
            // keep swapping backwards until element is in correct place
            while(j > 0 && arr[j-1] > arr[j]){
                swap(j, j-1, arr);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        InsertionSort obj = new InsertionSort();
        obj.insertion(arr);

        System.out.println(java.util.Arrays.toString(arr));
    }
}

/*
🔹 Dry Run for arr = {5, 4, 3, 2, 1}

Initial: [5, 4, 3, 2, 1]

i = 0 → nothing happens (single element is always sorted)

i = 1:
- Compare 5 and 4 → swap → [4, 5, 3, 2, 1]

i = 2:
- Compare 5 and 3 → swap → [4, 3, 5, 2, 1]
- Compare 4 and 3 → swap → [3, 4, 5, 2, 1]

i = 3:
- Compare 5 and 2 → swap → [3, 4, 2, 5, 1]
- Compare 4 and 2 → swap → [3, 2, 4, 5, 1]
- Compare 3 and 2 → swap → [2, 3, 4, 5, 1]

i = 4:
- Compare 5 and 1 → swap → [2, 3, 4, 1, 5]
- Compare 4 and 1 → swap → [2, 3, 1, 4, 5]
- Compare 3 and 1 → swap → [2, 1, 3, 4, 5]
- Compare 2 and 1 → swap → [1, 2, 3, 4, 5]

✅ Final Sorted Array: [1, 2, 3, 4, 5]

🔹 Time Complexity:
- Best Case: O(n) (already sorted)
- Worst Case: O(n^2) (reverse sorted)
- Average Case: O(n^2)
- Space Complexity: O(1) (in-place)

🔹 Note:
- Insertion Sort is **stable** (keeps the order of equal elements).
- Good for **small arrays** or **nearly sorted arrays**.
*/
