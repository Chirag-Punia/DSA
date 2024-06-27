class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0,i=0,j=0;
        
        while(j < s.length && i < g.length){
            if(g[i] > s[j]){j++;continue;}
            if(s[j] >= g[i]) {count++;j++;}
            i++;
        }
        return count;
    }
}