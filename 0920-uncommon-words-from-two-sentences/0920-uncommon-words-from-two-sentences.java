class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        Map<String,Integer> mpp = new HashMap<>();
        for(String a : arr1){
            mpp.put(a,mpp.getOrDefault(a,0) + 1);
        }
        for(String a : arr2){
            mpp.put(a,mpp.getOrDefault(a,0) + 1);
        }
        List<String> ans = new ArrayList<>();
        mpp.forEach((key,value) -> {
            if(value == 1)ans.add(key);
        });
        return ans.toArray(new String[0]);
    }
}