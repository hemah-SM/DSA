package DSA.Arrays;

public class BinarySearch {
    public int searchElement(int[] arr, int target){
        int low = 0, high = arr.length;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}
