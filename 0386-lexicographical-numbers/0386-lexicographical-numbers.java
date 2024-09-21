class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> arr = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            arr.add(String.valueOf(i));
        }
        Collections.sort(arr);
        for(String s : arr){
            ans.add(Integer.parseInt(s));
        }
        return ans;
    }
}