class Solution {
    public double averageWaitingTime(int[][] customers) {
        long startTime = customers[0][0];
        long timeSum = 0;

        for(int i = 0 ; i < customers.length ; i++)
        {
            if(startTime < customers[i][0])
                startTime = customers[i][0];

            long time2cook = startTime + customers[i][1];
            timeSum += time2cook - customers[i][0];
            startTime = time2cook;
        }

        double result = (double)timeSum / customers.length;
        return result;
    }
}