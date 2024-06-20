public class Solution {
    public static boolean isValid(String s) {

        if (s.length() <= 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 0; i < s.length() - 1; i++) {
            if (!stack.isEmpty()) {
                if (stack.peek() == '[' && s.charAt(i + 1) == ']') {
                    stack.pop();
                } else if (stack.peek() == '{' && s.charAt(i + 1) == '}') {
                    stack.pop();
                } else if (stack.peek() == '(' && s.charAt(i + 1) == ')') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i+1));
                }
            }
            else{
                stack.push(s.charAt(i+1));
            }

        }
        return stack.isEmpty();

        //BRUTE FORCE
        // while (true) {
        // if (s.contains("()")) {
        // s = s.replace("()", "");
        // } else if (s.contains("{}")) {
        // s = s.replace("{}", "");
        // } else if (s.contains("[]")) {
        // s = s.replace("[]", "");
        // } else {

        // return s.isEmpty();
        // }
        // }
    }
}