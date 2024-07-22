class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> mpp = new TreeMap<>(Comparator.reverseOrder());
        for(int i = 0;i<names.length;i++){
            mpp.put(heights[i],names[i]);
        }
        String[] ans = new String[names.length];
        int[] i = {0};
        mpp.forEach((key,value) -> {
            ans[i[0]] = value;
            i[0]++;
        });
        return ans;
    }
}