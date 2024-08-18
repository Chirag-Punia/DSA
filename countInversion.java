import java.util.* ;
import java.io.*; 
//https://www.naukri.com/code360/problems/count-inversions_615?leftPanelTabValue=PROBLEM
public class Solution {
    
     private static int merge(long[] arr, int low, int mid, int high) {
        ArrayList<Long> temp = new ArrayList<>();
        int left = low;      
        int right = mid + 1; 

       
        int cnt = 0;

       

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1); 
                right++;
            }
        }

       

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt;
    }

    public static int mergeSort(long[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += mergeSort(arr, low, mid);  
        cnt += mergeSort(arr, mid + 1, high); 
        cnt += merge(arr, low, mid, high);  
        return cnt;
    }

    public static int getInversions(long[] a, int n) {
        
        return mergeSort(a, 0, n - 1);
    }

}
