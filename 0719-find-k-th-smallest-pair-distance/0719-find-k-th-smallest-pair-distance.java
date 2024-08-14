// class Solution {
//     PriorityQueue<Integer> pq;
//     List<Integer> arr;
//     public void tmp(int[] nums , int i,int k){
//         if(arr.size() == 2){
//             pq.offer(Math.abs(arr.get(1) - arr.get(0)));
//             while(pq.size() > k){
//                 pq.poll();
//             }
//             return;
//         }
//         if(i >= nums.length)return;
//         arr.add(nums[i]);
//         tmp(nums,i+1,k);
//         arr.remove(arr.size() - 1);
//         tmp(nums,i+1,k);
//     }
//     public int smallestDistancePair(int[] nums, int k) {
//         pq = new PriorityQueue<>(Comparator.reverseOrder());
//         arr = new ArrayList<>();
//         tmp(nums,0,k);
//         return pq.poll();
//     }
// }



public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (issmallpairs(nums, k, mid))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
    
    private boolean issmallpairs(int[] nums, int k, int mid) {
        int count = 0, left = 0;
        for (int right = 1; right < nums.length; right++) {
            while (nums[right] - nums[left] > mid) left++;
            count += right - left;
        }
        return (count >= k);
    }
}