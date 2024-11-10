class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int minLen=Integer.MAX_VALUE;
        int n=nums.length;


        int[] bit32=new int[32];
        bitFunc(nums[0], bit32, '+');

        
        int num=0, cnt=0;
        int i=0, j=0;
        
        //Used sliding window
        while(i<=j && i<n && j<n){
            num=bitToDec( bit32 );
            if( num >= k ){
                cnt=j-i+1;
                minLen=Math.min(minLen, cnt);
                bitFunc(nums[i], bit32, '-'); //Removed the i index value
                i++;                
            }
            else{
                j++;
                if(j<n){
                    bitFunc(nums[j], bit32, '+'); //Added the j index value
                }
            }            
        }

        return minLen==Integer.MAX_VALUE?-1:minLen;
    }



    void bitFunc(int num, int[] bit32, char op){
        int m=31;
        String bitStr=Integer.toBinaryString(num);  
        
        if(op=='+'){      
            for(int i=bitStr.length()-1; i>=0; i--){
                bit32[m--] += (bitStr.charAt(i)-'0');                
            }
        }
        else if(op=='-'){
            for(int i=bitStr.length()-1; i>=0; i--){
                bit32[m--] -= (bitStr.charAt(i)-'0');                
            }
        }
    }


    int bitToDec(int[] bit32){
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<32; i++){
            sb.append( (bit32[i]>0)?1:0 );
        }
        return Integer.parseInt(sb.toString(), 2);
    }

}