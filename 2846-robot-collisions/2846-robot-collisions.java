class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int[][] arr = new int[positions.length][4];
        for (int i = 0; i < positions.length; i++) {
            arr[i][0] = healths[i];
            if (directions.charAt(i) == 'R') {
                arr[i][1] = 1;
            } else {
                arr[i][1] = -1;
            }
            arr[i][2]=positions[i];
            arr[i][3]=i;
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a[2],b[2]));
        Stack<int[]> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
                if (st.isEmpty() || arr[i][1] == st.peek()[1] || arr[i][1]>st.peek()[1]) {
                    st.push( arr[i]);
                } else {
                    while(!st.isEmpty() && st.peek()[1] > arr[i][1]) {
                        int[] rightRobot = st.peek();
                    if (rightRobot[0] == arr[i][0]) {
                        rightRobot[0] = 0;
                        arr[i][0] = 0;
                        st.pop();
                        break;
                    } else {
                        if (rightRobot[0] > arr[i][0]) {
                            rightRobot[0]--;
                            arr[i][0] = 0;
                            break;
                        } else {
                            rightRobot[0] = 0;
                            arr[i][0]--;
                            st.pop();
                           
                        }
                    }

                }
                if(arr[i][0]!=0)
                 st.push( arr[i] );
            }
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a[3],b[3]));
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            if(arr[i][0]!=0){
                ans.add(arr[i][0]);
            }
        }
        return ans;
    }
}