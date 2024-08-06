class Solution {
    int profit;
    Map<String,Integer> memo;
    int[][] dp;
    int tmp(int[] arr,int buy,int i){
        String key = buy+","+i;
        if(i >= arr.length){
            return 0;
        }
        if(memo.containsKey(key))return memo.get(key);
        if(buy == 1){
            profit = Math.max((-arr[i] + tmp(arr,0,i+1)),tmp(arr,1,i+1));
        }
        else{
            profit = Math.max((arr[i] + tmp(arr,1,i+1)) , tmp(arr,0,i+1));
        }
        memo.put(key,profit);
        return profit;
    }

    public int maxProfit(int[] arr) {
        memo = new HashMap<>();
        profit = Integer.MIN_VALUE;
        return tmp(arr,1,0);
    }
}