class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> mpp = new LinkedHashMap<>();
        int cnt = 0;
        for (String s : arr) {
            mpp.put(s, mpp.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : mpp.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value == 1)
                cnt++;
            if (cnt == k)
                return key;
        }
        return "";
    }
}