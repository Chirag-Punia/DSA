class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> mpp = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(char a : tasks){
            mpp.put(a,mpp.getOrDefault(a,0)+1);
        }
        mpp.forEach((key,value) -> {
            pq.offer(value);
        });
        int ans = 0;
        int cnt = n;
        while(!pq.isEmpty()){
            List<Integer> arr = new ArrayList<>();
            while(cnt >= 0 && !pq.isEmpty()){
                int curr = pq.poll();
                arr.add(curr - 1);
                cnt--;
            }
            for(int a : arr){
                if(a > 0)pq.offer(a);
            }
            if(pq.isEmpty()){
                ans += arr.size();
            }
            else{
                ans += n + 1;
            }
            cnt = n;

        }
        return ans;

    }
}