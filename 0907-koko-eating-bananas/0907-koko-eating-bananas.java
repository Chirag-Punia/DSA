class Solution {

    public static int binarySearch(int[] piles, int h, int left, int right,int ans) {
        int mid = (left + right) / 2;
        int xx = ans;
        if (left <= right) {
            double totalFinishTime = totalFinishTime(mid, piles);
            if (totalFinishTime <= h) {
                return binarySearch(piles, h, left, mid - 1,Math.min(mid,xx));
            } else {
                return binarySearch(piles, h, mid + 1, right,xx);
            }
        }
        return xx;
    }

    public static double totalFinishTime(int mid,int[] piles){
        double totalFinishTime = 0;
        for (int j = 0; j < piles.length; j++) {
                double hours = (double)Math.ceil((double)(piles[j])/ (double)mid);
                totalFinishTime = totalFinishTime + hours;
            }
        return totalFinishTime;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(piles[i], max);
        }

        return binarySearch(piles, h, 1, max,Integer.MAX_VALUE);

        // BRUTE FORCE
        // double totalFinishTime = 0;
        // int n = piles.length;
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < n; i++) {
        // max = Math.max(piles[i], max);
        // }
        // for (int i = 1; i <= max; i++) {
        // for (int j = 0; j < n; j++) {
        // double hours = (double) Math.ceil((double) (piles[j]) / (double) i);
        // totalFinishTime = totalFinishTime + hours;
        // }
        // if (totalFinishTime <= h) {
        // return i;
        // }
        // totalFinishTime = 0;
        // }
        // return -1;
    }
}