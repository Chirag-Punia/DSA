class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack();
        st.push(s.charAt(0));
        for(int i = 1;i<s.length();i++){
            char c = s.charAt(i);
            if(st.isEmpty())st.push(c);
            else{
            if(c == 'B' && st.peek() == 'A'){
                st.pop();
            }
            else if(c == 'D' && st.peek() == 'C')st.pop();
            else st.push(c);
            }
        }
        return st.size();
    }
}