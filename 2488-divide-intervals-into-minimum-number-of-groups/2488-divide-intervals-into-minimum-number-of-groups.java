class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = intervals.length;
        int overlaps = 0;
        for(int i = 0;i<n;i++){
            int[] curr = intervals[i];
            if(!pq.isEmpty() && pq.peek() < curr[0]){
                pq.poll();
            }
            pq.offer(curr[1]);
        }
        return pq.size();
    }
}