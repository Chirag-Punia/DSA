class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        // HashMap<Integer,Integer> mpp = new HashMap<>();
        // List<Integer> ans= new ArrayList<>();
        // for(int num:nums){
        //     mpp.put(num,mpp.getOrDefault(num,0)+1);
        // }
        // mpp.forEach((key,value) -> {
        //     if(value > Math.floor(n/3)) ans.add(key);
        // });
        // return ans;
        int cnt1=0,cnt2=0,ele1=-1,ele2=-1;
        for(int i=0;i<nums.length;i++){
            if(cnt1==0 && nums[i] != ele2){
                cnt1++;
                ele1=nums[i];
            }
            else if(cnt2==0 && nums[i]!=ele1){
                cnt2++;
                ele2=nums[i];
            }
            else if(nums[i] == ele1) cnt1++;
            else if(nums[i] == ele2) cnt2++;
            else{cnt1--;cnt2--;}
        }
        cnt1=0;cnt2=0;
        for(int i =0;i<nums.length;i++){
            if(nums[i] == ele1) cnt1++;
            if(nums[i] == ele2) cnt2++;
        }
        List<Integer> ans = new ArrayList<>();
        if(cnt1 > Math.floor(n/3)) ans.add(ele1);
        if(cnt2 > Math.floor(n/3)) ans.add(ele2);
        return ans;
    }
}