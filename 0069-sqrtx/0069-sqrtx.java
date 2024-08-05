class Solution {
    public  int binarySearch(int x,long ans,long left,long right){
        long mid = (right+left) / 2;
        if(left <= right){
            if(mid*mid <= x){
                return binarySearch(x,mid,mid + 1,right);
            }
            else{
                return binarySearch(x,ans,left,mid-1);
            }
        }
        return (int)ans;
    }
    public int mySqrt(int x) {
        if(x == 0)return 0;
        if(x==1 || x == 2)return 1;
        
        return binarySearch(x,1,1,(long)x);
    }
}