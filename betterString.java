//https://www.geeksforgeeks.org/problems/better-string/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=better-string
class Solution {
    
    public static HashSet<String> set;
    
    public static void tmp(int i,String s,String str){
        if(i >= str.length()){set.add(s);return;}
        tmp(i+1,s+str.charAt(i),str);
        tmp(i+1,s,str);
    }
    public static String betterString(String str1, String str2) {
        // Code here
        set = new HashSet<>();
        tmp(0,"",str1);
        int str1Count = set.size();
        set = new HashSet<>();
        tmp(0,"",str2);
        if(set.size() > str1Count) return str2;
        else return str1;
        
    }
}
