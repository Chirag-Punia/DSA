class RandomizedSet {
    Map<Integer,Boolean> mpp;
    public RandomizedSet() {
        
        this.mpp = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(mpp.containsKey(val))return false;
        mpp.put(val,true);
        return true;
    }
    
    public boolean remove(int val) {
        if(mpp.containsKey(val)){
            mpp.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int[] arr = new int[mpp.size()];
        int[] i = {0};
        mpp.forEach((key,value) -> {
            arr[i[0]++] = key;
        });
        Random random = new Random();
        int randIdx = random.nextInt(mpp.size());
        return arr[randIdx];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */