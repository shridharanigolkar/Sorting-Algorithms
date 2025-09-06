public class SelectionSort {
    static public void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void selection(int[] arr){ 
       int n  = arr.length;
       for(int i=0;i<n-1;i++){
            int mini = i;

            // find the index of the minimum element in the unsorted part
            for(int j=i+1;j<n;j++){
                if(arr[j] < arr[mini]) mini = j;
            }

            // swap the found minimum with the element at index i
            swap(i, mini, arr);
       }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        SelectionSort obj = new SelectionSort();
        obj.selection(arr);

        System.out.println(java.util.Arrays.toString(arr));
    }
}

/*
Dry Run for arr = {5, 4, 3, 2, 1}

Initial: [5, 4, 3, 2, 1]

Pass 1 (i = 0):
- Minimum from index 0..4 is 1 at index 4
- Swap arr[0] and arr[4]
- Array becomes [1, 4, 3, 2, 5]

Pass 2 (i = 1):
- Minimum from index 1..4 is 2 at index 3
- Swap arr[1] and arr[3]
- Array becomes [1, 2, 3, 4, 5]

Pass 3 (i = 2):
- Minimum from index 2..4 is 3 at index 2
- Swap arr[2] with itself (no change)
- Array stays [1, 2, 3, 4, 5]

Pass 4 (i = 3):
- Minimum from index 3..4 is 4 at index 3
- Swap arr[3] with itself (no change)
- Array stays [1, 2, 3, 4, 5]

Final Sorted Array: [1, 2, 3, 4, 5]

 Time Complexity:
- Worst Case: O(n^2)
- Best Case: O(n^2) (always scans entire unsorted part)
- Space Complexity: O(1) (in-place)

 Note:
- Selection sort is NOT stable (equal elements may change relative order).
*/
