class Solution {
    public int reverse(int x) {
        int temp = 0;
        int bool = 0;
        int digit = 0;
        if(x<0){
            x = x * (-1);
            bool = 1;
        }
        while(x>0){
            digit = x % 10;
            if(temp > Integer.MAX_VALUE/10){
            return 0;
        }
            temp = temp * 10 + digit;
            x = x /10;
        }
   
        if(bool == 1){
            return temp * -1;
        }
        return temp;
    }
}