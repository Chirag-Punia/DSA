class Solution {
    public boolean isNStraightHand(int[] h, int g) {
        if(h.length % g != 0) return false;
        TreeMap<Integer,Integer> mpp = new TreeMap<>();
        for(int t : h) mpp.put(t,mpp.getOrDefault(t,0) + 1);
        while(!mpp.isEmpty()){
            int x = mpp.firstKey();
            for(int i = 0;i<g;i++){
                int c = x + i;
                if(!mpp.containsKey(c)) return false;
                if(mpp.get(c) == 1) mpp.remove(c);
                else mpp.put(c,mpp.get(c)-1);
            }
        }
        return true;
    }
}