class Solution {
    public static int binarySearch(int[] weights,int days,int left,int right,int ans,int ansIndex){
        int mid = (right + left) / 2;
        int xx = ans;
        int x = ansIndex;
        int currDays = countDays(weights,mid);
        if(left <= right){
            if(currDays <= days){
                return binarySearch(weights,days,left,mid-1,currDays,mid);
            }
            else if(currDays > days){
                return binarySearch(weights,days,mid + 1,right,xx,x);
            }
           
        }
        return x;
    }

    public static int countDays(int[] weights, int i) {
        int tempSum = 0;
        int count = 1;
        for (int j = 0; j < weights.length; j++) {
            if (tempSum + weights[j] > i) {
                count++;
                tempSum = weights[j];
            } else {
                tempSum = tempSum + weights[j];
            }
        }
        return count;
    }

    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum = sum + weights[i];
            max = Math.max(max, weights[i]);
        }

        return binarySearch(weights,days,max,sum,0,0);
    }
}