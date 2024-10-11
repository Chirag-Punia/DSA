class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetFriendArrivalTime = times[targetFriend][0];
        int[] chair = new int[times.length];
        Arrays.sort(times,Comparator.comparingInt(o -> o[0]));

        for(int i = 0;i < times.length;i++){
            int arrival = times[i][0];
            int dep = times[i][1];
            for(int j = 0;j<times.length;j++){
                if(chair[j] <= arrival){
                    chair[j] = dep;
                    if(arrival == targetFriendArrivalTime)return j;
                    break;
                }
            }
        }
        return -1;
    }
}