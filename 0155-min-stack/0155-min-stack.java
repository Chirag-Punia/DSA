class MinStack {

    int min;
    Stack<Integer> s;
    List<Integer> arr;
    int top;
    public MinStack() {
        s = new Stack<>();
        top = -1;
        arr = new ArrayList<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(top == -1 || val <= arr.get(top)){
            arr.add(val);
            top++;
        }
    }
    
    public void pop() {
        if(s.peek().equals(arr.get(top))){
            arr.remove(top);
            top--;
        }
        s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        if(top == -1){
            return -1;
        }
        return arr.get(top);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */