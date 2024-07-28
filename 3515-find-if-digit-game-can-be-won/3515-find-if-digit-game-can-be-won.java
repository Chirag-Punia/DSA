class Solution {
    public boolean canAliceWin(int[] nums) {
        int s = 0;
        int d = 0;
        int totalSum = 0;

        for (int num : nums) {
            if (num >= 1 && num <= 9) {
                s += num;
            } else if (num >= 10 && num <= 99) {
                d += num;
            }
            totalSum += num;
        }

        int alice = totalSum - s;
        int aliced = totalSum - d;
        if (s > alice || d > aliced)return true;
        return false;
    }
}