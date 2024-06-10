class Solution {

    public void nextPermutation(int[] A) {

        int index = -1;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i + 1] > A[i]) {
                index = i;
                break;
            }
        }
        int ans = Integer.MAX_VALUE;
        if (index == -1) {
            int start = index + 1;
            int end = A.length - 1;
            while (start < end) {
                int x = A[start];
                A[start] = A[end];
                A[end] = x;
                start++;
                end--;
            }
        } else {
            int ansIndex = -1;
            for (int i = A.length - 1; i >= index; i--) {
                if (A[i] > A[index]) {
                    if(ans > A[i]){
                        ansIndex = i;
                        ans = A[i];
                    }
                }
            }

            int temp = A[ansIndex];
            A[ansIndex] = A[index];
            A[index] = temp;

            int start = index + 1;
            int end = A.length - 1;
            while (start < end) {
                int x = A[start];
                A[start] = A[end];
                A[end] = x;
                start++;
                end--;
            }

        }

    }
}