package sorting;

public class bubble {
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            int swaps = 0;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps++;
                }
            }
            if(swaps == 0){
                break;
            }
        }
    }
    public static void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {5,4,1,3,2};
        bubbleSort(arr);
        print(arr);
    }
}
