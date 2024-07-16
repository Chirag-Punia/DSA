class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l = 0,r = 0,n = cardPoints.length,leftSum = 0,maxSum = 0,rightSum=0;
        for(int i = 0;i<k;i++){
            leftSum += cardPoints[i];
        }
        maxSum = leftSum;
        int j = n-1;
        for(int i = k-1;i>=0;i--){
            leftSum -= cardPoints[i];
            rightSum += cardPoints[j];
            j--;
            maxSum = Math.max(maxSum,leftSum+rightSum);
        }
        return maxSum;
    }
}