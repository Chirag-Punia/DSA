class Solution {
    public long dividePlayers(int[] skill) {
        int sum = 0;
        int n = skill.length;
        boolean[] mpp = new boolean[n];
        for(int s : skill)
            sum+=s;
        if(sum % (n/2) != 0)return -1;
        sum = sum / (n/2);
        long ans = 0;
        for(int i = 0;i<n;i++){
            if(!mpp[i]){
                int curr = skill[i];
                for(int j = i + 1;j<n;j++){
                    if(curr + skill[j] == sum && !mpp[j]){
                        mpp[j] = true;
                        ans = ans + (long)curr * skill[j];
                        mpp[i] = true;
                        break;
                    }
                }
            }   
            else continue;
        }
        for(boolean a : mpp)if(!a)return -1;
        
        return ans!=(long)0?ans:-1;

    }
}