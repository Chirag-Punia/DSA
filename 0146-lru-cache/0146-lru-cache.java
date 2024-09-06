class LRUCache {
    class Pair {
        int cnt;
        int v;
        int shadow;

        Pair(int v, int cnt,int shadow) {
            this.v = v;
            this.cnt = cnt;
            this.shadow = shadow;
        }
    }

    Map<Integer, Pair> mpp;
    int cap;
    int i;
    public LRUCache(int capacity) {
        this.mpp = new HashMap<>();
        this.cap = capacity;
        this.i = 0;
    }

    public int get(int key) {
        if (mpp.containsKey(key)) {
            Pair curr = mpp.get(key);
            i = i + 1;
            mpp.put(key,new Pair(curr.v,++curr.cnt,i));
            return curr.v;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (mpp.containsKey(key)) {
            i = i + 1;
            mpp.put(key, new Pair(value, 1,i));
            return;
        }
        if (mpp.size() >= cap) {
            int[] minCnt = { Integer.MAX_VALUE };
            int[] minKey = { 0 };
            mpp.forEach((k, val) -> {
                if (val.shadow < minCnt[0]) {
                    minKey[0] = k;
                    minCnt[0] = val.shadow;
                }
            });
            mpp.remove(minKey[0]);
        }
        i = i + 1;
        mpp.put(key, new Pair(value, 1,i));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */