class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        Map<String,Integer> mpp1 = new HashMap<>();
        Map<String,Integer> mpp2 = new HashMap<>();
        for(String a : arr1){
            mpp1.put(a,mpp1.getOrDefault(a,0) + 1);
        }
        for(String a : arr2){
            mpp2.put(a,mpp2.getOrDefault(a,0) + 1);
        }
        List<String> ans = new ArrayList<>();
        mpp1.forEach((key,value) -> {
            if(value == 1 && !mpp2.containsKey(key))ans.add(key);
        });
        mpp2.forEach((key,value) -> {
            if(value == 1 && !mpp1.containsKey(key))ans.add(key);
        });
        String[] realAns = new String[ans.size()];
        for(int i = 0;i<ans.size();i++){
            realAns[i] = ans.get(i);
        }
        return realAns;
    }
}