class Solution {
    public static boolean possible(int[] arr, int day, int m, int k) {
        int n = arr.length;
        int cnt = 0;
        int noOfB = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }

    public static int binarySearch(int[] bloomDay, int m, int k, int left, int right, int ans) {
        int mid = (left + right) / 2;
        int xx = ans;
        if (left <= right) {
            if (possible(bloomDay, mid, m, k)) {
                return binarySearch(bloomDay, m, k, left, mid - 1, mid);
            } else {
                return binarySearch(bloomDay, m, k, mid + 1, right, xx);
            }

        }
        return xx;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < bloomDay.length; i++) {
            max = Math.max(max, bloomDay[i]);
        }
        for (int i = 0; i < bloomDay.length; i++) {
            min = Math.min(min, bloomDay[i]);
        }
        if (m * k > bloomDay.length) {
            return -1;
        } else if (m * k == bloomDay.length) {
            return max;
        } else {

            return binarySearch(bloomDay, m, k, min, max, -1);

            //BRUTE FORCE
            // for (int i = min; i <= max; i++) {
            // int bqeCount = 0;
            // int count = 0;
            // for (int j = 0; j < bloomDay.length; j++) {
            // if (bloomDay[j] <= i) {
            // count++;
            // } else {
            // count = 0;
            // }
            // }

            // bqeCount = bqeCount + count / k;
            // if (bqeCount >= m) {
            // return i;
            // }
            // }

        }

    }
}