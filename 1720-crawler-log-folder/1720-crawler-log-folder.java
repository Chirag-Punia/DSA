class Solution {
    public int minOperations(String[] logs) {
        Stack<String> s = new Stack<>();
        for(String tmp : logs){
            if(!s.isEmpty() && tmp.equals("../"))s.pop();
            else if(tmp.equals("./"))continue;
            else if (!tmp.equals("../"))s.push(tmp);
        }
        return s.size();
    }
}