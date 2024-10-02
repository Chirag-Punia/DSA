class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer,Integer> mpp = new HashMap<>();
        int k = 1;
        for(int i = 0;i<n;i++){
            int curr = sorted[i];
            if(!mpp.containsKey(curr)){
                mpp.put(curr,k++);
            }
        }
        for(int i = 0;i<n;i++){
            arr[i] = mpp.get(arr[i]);
        }
        return arr;
    }
}