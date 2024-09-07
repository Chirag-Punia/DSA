class Solution {

    public static void heapify(int i, int[] arr, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(largest, arr, n);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        // int n = nums.length;
        // int temp = -1;

        // for (int i = n / 2 - 1; i >= 0; i--) {
        //     heapify(i, nums, n);
        // }

        // for (int i = n - 1; i >= n - k; i--) {

        //     temp = nums[0];
        //     nums[0] = nums[i];
        //     nums[i] = temp;
        //     heapify(0, nums, i);

        // }

        // return temp;

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int num : nums){
            if(pq.size() < k)pq.offer(num);
            else if(num > pq.peek()){
                pq.poll();
                pq.offer(num);
            }
        }
        return pq.peek();
            
        
    }
}
