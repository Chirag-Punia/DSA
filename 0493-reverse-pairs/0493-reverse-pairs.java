class Solution {
    private static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;      
        int right = mid + 1; 
        int j = mid+1;
       
        int cnt = 0;

        for (int i = low; i <= mid; i++) {
            while (j <= high && arr[i] > 2L * arr[j]) {
                j++;
            }
            cnt += (j - (mid + 1));
        }

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
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

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += mergeSort(arr, low, mid);  
        cnt += mergeSort(arr, mid + 1, high); 
        cnt += merge(arr, low, mid, high);  
        return cnt;
    }
    public int reversePairs(int[] nums) {
        int ans = mergeSort(nums, 0, nums.length- 1);
        return ans;
    }
}