public class Solution {
//https://www.interviewbit.com/problems/subarray-with-given-xor/ 
    public int solve(ArrayList<Integer> A, int B) {
    int cnt = 0;
    Map<Integer,Integer> mpp = new HashMap<>();
    int xor = 0;
    for(int i = 0;i<A.size();i++){
        xor ^= A.get(i);
        if(xor == B)cnt++;
        int reqXor = xor ^ B;
        if(mpp.containsKey(reqXor))cnt+=mpp.get(reqXor);
        mpp.put(xor,mpp.getOrDefault(xor,0)+1);
    }        
    return cnt;
        
    }
}
