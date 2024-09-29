class AllOne {
    Map<String,Integer> mpp1;
    TreeMap<Integer,Set<String>> mpp2;

    public AllOne() {
        this.mpp1 = new HashMap<>();
        this.mpp2 = new TreeMap<>();
    }
    
    public void inc(String key) {
        int count = mpp1.getOrDefault(key,0);
        if(count > 0){
            mpp2.get(count).remove(key);
            if(mpp2.get(count).isEmpty())mpp2.remove(count);
        }
        mpp1.put(key,count+1);
        mpp2.computeIfAbsent(count + 1,k -> new HashSet<>()).add(key);
    }
    
     public void dec(String key) {
        if (!mpp1.containsKey(key)) {
            return;
        }
        int count = mpp1.get(key);
        mpp2.get(count).remove(key);
        if (mpp2.get(count).isEmpty()) {
            mpp2.remove(count);
        }
        if (count == 1) {
            mpp1.remove(key);
        } else {
            mpp1.put(key, count - 1);
            mpp2.computeIfAbsent(count - 1, k -> new HashSet<>()).add(key);
        }
    }
    
    public String getMaxKey() {
        if(mpp2.isEmpty()){
            return "";
        }
        return mpp2.lastEntry().getValue().iterator().next();
    }
    
    public String getMinKey() {
        if(mpp2.isEmpty()){
            return "";
        }
        return mpp2.firstEntry().getValue().iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */