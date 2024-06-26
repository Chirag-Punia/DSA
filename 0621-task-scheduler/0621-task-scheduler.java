class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> mpp = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> a;
        List<Integer> b;
        for(char i : tasks) mpp.put(i,mpp.getOrDefault(i,0)+1);
        for(Map.Entry<Character,Integer> entry : mpp.entrySet()) pq.offer(entry.getValue());
        int ans = 0;
        while(!pq.isEmpty()){
            a = new ArrayList<>();
            b = new ArrayList<>();
            for(int i = 0;i<=n;i++) if(!pq.isEmpty()) a.add(pq.poll());
            for(int i = 0;i<a.size();i++){
                int t = a.get(i) - 1;
                b.add(t);
                if(b.get(i) != 0) pq.offer(b.get(i));
            }
            if(pq.isEmpty()) ans = ans + b.size();
            else ans = ans + n + 1;            
        }
        return ans;
    }
}