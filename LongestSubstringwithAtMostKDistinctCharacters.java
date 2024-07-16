import java.util.*;
//https://www.naukri.com/code360/problems/distinct-characters_2221410?leftPanelTabValue=PROBLEM
public class Solution {

	public static int kDistinctChars(int k, String str) {
		// Write your code here
		int right=0,left=0,n=str.length(),maxLen=0;
		HashMap<Character,Integer> mpp = new HashMap<>();
		while(right<n){
			char curr = str.charAt(right);
			mpp.put(curr,mpp.getOrDefault(curr,0)+1);

			while(mpp.size() > k){
				mpp.put(str.charAt(left),mpp.getOrDefault(str.charAt(left),0)-1);
				if(mpp.get(str.charAt(left)) == 0)mpp.remove(str.charAt(left));
				left++;
			}


			if(mpp.size() <= k){
				maxLen = Math.max(maxLen,right - left + 1);
			}
			
			right++;
		}
		return maxLen;
	}

}
