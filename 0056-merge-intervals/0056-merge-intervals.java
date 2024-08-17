class Solution {
    public class mergeComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] a,int[] b){
            return Integer.compare(a[1],b[1]);
        }
    }
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[][] dp = new int[n][3];
         List<int[]> merged = new ArrayList<>();
        for(int i = 0;i<n;i++){
                dp[i][0] = i;
                dp[i][1] = intervals[i][0];
                dp[i][2] = intervals[i][1];
        }
        Arrays.sort(dp,new mergeComparator());
        int start = dp[0][1],end = dp[0][2];
        
        for(int i = 1;i<n;i++){
            if(dp[i][1] <= end){
                end = Math.max(end, dp[i][2]);
            }
            else{
                merged.add(new int[]{start, end});
                start = dp[i][1];
                end = dp[i][2];
            }
        }
        merged.add(new int[]{start, end});
        return merged.toArray(new int[merged.size()][]);    
    }
}