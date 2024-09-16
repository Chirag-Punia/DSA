import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int minDiff = Integer.MAX_VALUE;

        String[] firstTime = timePoints.get(0).split(":");
        int firstMinutes = Integer.parseInt(firstTime[0]) * 60 + Integer.parseInt(firstTime[1]);

        int prevMinutes = firstMinutes;

        for (int i = 1; i < timePoints.size(); i++) {
            String[] currentTime = timePoints.get(i).split(":");
            int currentMinutes = Integer.parseInt(currentTime[0]) * 60 + Integer.parseInt(currentTime[1]);
            minDiff = Math.min(minDiff, currentMinutes - prevMinutes);
            prevMinutes = currentMinutes;
        }

        int lastMinutes = prevMinutes;
        int wrapAroundDiff = (firstMinutes + 1440) - lastMinutes;
        minDiff = Math.min(minDiff, wrapAroundDiff);

        return minDiff;
    }
}
