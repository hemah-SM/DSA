package DSA.Arrays;

import java.util.Arrays;

public class MergeSort {
    public void mergeSort(int[] nums){
        if(nums == null || nums.length <= 1)return;
        mergeSortHelper(nums,0, nums.length-1);
    }
    public void mergeSortHelper(int[] nums,int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            mergeSortHelper(nums, low, mid);
            mergeSortHelper(nums, mid+1, high);
            merge(nums, low, mid, high);
        }
    }

    public void merge(int[] nums, int low, int mid, int high){
        int[] arr1 = Arrays.copyOfRange(nums,low,mid+1);
        int[] arr2 = Arrays.copyOfRange(nums,mid+1,high+1);
        int i = 0, j = 0, k = low;
        while(i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j]) nums[k++] = arr1[i++];
            else nums[k++] = arr2[j++];
        }
        while(i < arr1.length)nums[k++] = arr1[i++];
        while(j < arr2.length)nums[k++] = arr2[j++];
    }
}
