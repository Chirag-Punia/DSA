class RandomizedSet {
    Map<Integer,Integer> mpp;
    List<Integer> arr;
    int i;
    Random random;
    public RandomizedSet() {
        
        this.mpp = new HashMap<>();
        this.arr = new ArrayList<>();
        this.random = new Random();
        this.i = 0;
    }
    
    public boolean insert(int val) {
        if(mpp.containsKey(val))return false;
        mpp.put(val,i);
        arr.add(val);
        i++;
        return true;
    }
    
    public boolean remove(int val) {
        if(mpp.containsKey(val)){
            int idx = mpp.get(val);
            int lastEle = arr.get(arr.size() - 1);
            
            arr.set(idx,lastEle);
            mpp.put(lastEle,idx);

            arr.remove(arr.size() - 1);
            mpp.remove(val);
            i--;
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int randIdx = random.nextInt(arr.size());
        return arr.get(randIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */