class Solution {
    public static class Pair implements Comparable<Pair>{
        int ele;
        int cnt;
        Pair(int ele,int cnt){
            this.ele = ele;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Pair other){
            return Integer.compare(this.cnt,other.cnt);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        
       HashMap<Integer,Integer> mpp = new HashMap<>();
       PriorityQueue<Pair> pq = new PriorityQueue<>(k);
       int[] ans = new int[k];int i = k-1;
       for(int num : nums) mpp.put(num,mpp.getOrDefault(num,0) + 1);
       for(Map.Entry<Integer,Integer> entry : mpp.entrySet()){
            Pair temp = new Pair(entry.getKey(),entry.getValue());
            if(pq.size() < k) pq.offer(temp);
            else if(pq.peek().cnt < temp.cnt) {pq.poll();pq.offer(temp);}
       }

       while(!pq.isEmpty()) {ans[i] = pq.poll().ele;i--;}

        
        return ans;
    
    }
}