import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class MinStack {
    Stack<Integer> s;
    List<Integer> minList;
    int minTop;

    public MinStack() {
        s = new Stack<>();
        minTop = -1;
        minList = new ArrayList<>();
    }

    public void push(int val) {
        s.push(val);
        if (minTop == -1 || val <= minList.get(minTop)) {
            minList.add(val);
            minTop++;
        }
    }

    public void pop() {
        if (s.peek().equals(minList.get(minTop))) {
            minList.remove(minTop);
            minTop--;
        }
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        if (minTop == -1) {
            throw new RuntimeException("Stack is empty");
        }
        return minList.get(minTop);
    }

    public boolean isEmpty() {
        return s.isEmpty();
    }
}

/**
 * Example usage:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
