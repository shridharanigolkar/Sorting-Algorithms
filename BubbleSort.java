class BubbleSort{
    static public void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void bubble(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j] > arr[j+1])
                swap(j,j+1,arr);
            }
        }
    }
    public static void main(String[] args) {
        
    int[] arr = {5, 4, 3, 2, 1};

        BubbleSort obj = new BubbleSort();
        obj.bubble(arr);

        System.out.println(java.util.Arrays.toString(arr));
    }
}