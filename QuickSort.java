package DSA.Arrays;

public class QuickSort {
    public void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivot = pivotIndex(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1,high);
        }
    }

    public int pivotIndex(int[] arr, int low, int high){
        int pivot = arr[high];
        int k = low;
        for(int i = low; i < high; i++){
            if(arr[i] < pivot){
                swap(arr, i, k);
                k++;
            }
        }
        swap(arr, k, high);
        return k;
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
