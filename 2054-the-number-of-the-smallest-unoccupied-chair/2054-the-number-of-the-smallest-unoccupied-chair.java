import java.util.*;

class Pair<U, V> {
    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            dp[i][0] = i;
            dp[i][1] = times[i][0];
            dp[i][2] = times[i][1];
        }

        Arrays.sort(dp, Comparator.comparingInt(o -> o[1]));

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        PriorityQueue<Pair<Integer, Integer>> occupiedChairs = new PriorityQueue<>(Comparator.comparing(p -> p.first));

        for (int i = 0; i < n; i++) {
            availableChairs.add(i);
        }

        for (int i = 0; i < n; i++) {
            int friend = dp[i][0];
            int arrivalTime = dp[i][1];
            int leaveTime = dp[i][2];

            while (!occupiedChairs.isEmpty() && occupiedChairs.peek().first <= arrivalTime) {
                availableChairs.add(occupiedChairs.poll().second);
            }

            int chair = availableChairs.poll();

            if (friend == targetFriend) {
                return chair;
            }

            occupiedChairs.add(new Pair<>(leaveTime, chair));
        }

        return -1;
    }
}
