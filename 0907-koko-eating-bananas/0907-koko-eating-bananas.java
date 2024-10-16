class Solution {
    int temp;
    public int temp(int[] piles,int j){
            int n = piles.length;

            for(int i = 0;i<n;i++){
                double t = (double)piles[i]/j;
                int time = (int) Math.ceil(t);
                if(temp - time >= 0)
                    temp -= time;
                else{
                    return -1;
                }
            }
        return j;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length; 
        int max = Integer.MIN_VALUE;
        int low = 1;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++)
            max = Math.max(max,piles[i]);
        int high = max;
        while(low <= high){
            int mid = (low + high) / 2;
            temp = h;
            int ans = temp(piles,mid);
            if(ans != -1){
                min = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return min;
    }
}