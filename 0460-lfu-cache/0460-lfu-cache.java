class LFUCache {
    class Pair {
        int v; // value
        int freq; // frequency

        Pair(int v, int freq) {
            this.v = v;
            this.freq = freq;
        }
    }

    Map<Integer, Pair> keyToPair;
    Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    int capacity;
    int minFreq;
    int i;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.keyToPair = new HashMap<>();
        this.freqToKeys = new HashMap<>();
        this.minFreq = 0;
        this.i = 0;
    }

    public int get(int key) {
        if (!keyToPair.containsKey(key)) {
            return -1;
        }

        Pair curr = keyToPair.get(key);
        updateFrequency(key, curr);
        return curr.v;
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;

        if (keyToPair.containsKey(key)) {
            Pair curr = keyToPair.get(key);
            curr.v = value;
            updateFrequency(key, curr);
            return;
        }

        if (keyToPair.size() >= capacity) {
            evictLFU();
        }

        minFreq = 1;
        keyToPair.put(key, new Pair(value, 1));
        freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
    }

    private void updateFrequency(int key, Pair curr) {
        int freq = curr.freq;
        freqToKeys.get(freq).remove(key);

        if (freqToKeys.get(freq).isEmpty() && freq == minFreq) {
            minFreq++;
        }

        curr.freq++;
        freqToKeys.computeIfAbsent(curr.freq, k -> new LinkedHashSet<>()).add(key);
    }

    private void evictLFU() {
        int keyToRemove = freqToKeys.get(minFreq).iterator().next();
        freqToKeys.get(minFreq).remove(keyToRemove);
        if (freqToKeys.get(minFreq).isEmpty()) {
            freqToKeys.remove(minFreq);
        }
        keyToPair.remove(keyToRemove);
    }
}
