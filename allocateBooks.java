//https://www.interviewbit.com/problems/allocate-books/

public class Solution {
    public boolean allocationPossible(ArrayList<Integer> A, int B,int barrier){
        int student = 1,pages = 0;
        for(int i = 0;i<A.size();i++){
            if(A.get(i) > barrier)return false;
            if(A.get(i) + pages > barrier){
                student+=1;
                pages = A.get(i);
                if(student > B)return false;
            }
            else
                pages+=A.get(i);
        }
        return true;
    }
    public int tmp(ArrayList<Integer> A, int B,int left,int right,int ans){
        if(left > right)return ans;
        int mid = (left + right) / 2;
        if(allocationPossible(A,B,mid))
            return tmp(A,B,left,mid-1,mid);
        else 
            return tmp(A,B,mid+1,right,ans);
            
    }
    public int books(ArrayList<Integer> A, int B) {
        if (B > A.size()) return -1;
        int left = 0,right=0;
        for(int a : A){
            left = Math.min(left,a);
            right += a;
        }
        return tmp(A,B,left,right,0);
    }
}
