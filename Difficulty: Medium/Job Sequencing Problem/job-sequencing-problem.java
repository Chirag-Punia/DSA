//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    class JobComparator implements Comparator<Job>{
        public int compare(Job j1,Job j2){
            if(j1.profit > j2.profit) return -1;
            if(j1.profit < j2.profit) return 1;
            return 0;
        }
    }
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        int maxDead = 0;
        for(Job j : arr)maxDead = Math.max(maxDead,j.deadline);
        Boolean[] done = new Boolean[maxDead+1];
        Arrays.fill(done,true);
        Arrays.sort(arr,new JobComparator());
        int ans = 0,k=0;
        for(int i = 0;i<n;i++){
            Job curr = arr[i];
            for(int j = Math.min(n,curr.deadline);j>0;j--){
                if(done[j]){
                    done[j] = false;
                    ans += curr.profit;
                    k++;
                    break;
                }
            }
        }
        return new int[]{k,ans};
        
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/