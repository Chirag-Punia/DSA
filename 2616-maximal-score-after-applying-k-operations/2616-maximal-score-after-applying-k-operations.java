class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxScrQ  = new PriorityQueue<>((a, b)->(b-a));
        for(var num : nums){
            maxScrQ.offer(num);
        }    
        long maxScore = 0l;
        while(k -- >0){
            int maxContri = maxScrQ.poll();
            maxScore += maxContri;
            maxContri = (maxContri + 2) /3;
            if(maxContri > 0){
                maxScrQ.offer(maxContri);
            } 
        }
        return maxScore;
    }
}