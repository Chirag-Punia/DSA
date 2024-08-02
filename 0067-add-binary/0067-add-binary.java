class Solution {
    public String addBinary(String a, String b) {
        int carry=0;
        int i=a.length()-1;
        int j=b.length()-1;
        StringBuilder c=new StringBuilder();
        while(i>=0||j>=0||carry==1)
        {
            if(i>=0)
            {
                carry+=a.charAt(i)-'0';
                i--;
            }
            if(j>=0)
            {
                carry+=b.charAt(j)-'0';
                j--;
            }
            c.append(carry%2);
            carry/=2;
            
            
            

        }
        c.reverse();
       String ans= c.toString();
        return ans;
        
    }
}