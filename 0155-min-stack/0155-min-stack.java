class MinStack {

    Long min;
    Stack<Long> s;
    public MinStack() {
        s = new Stack<Long>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        Long value = Long.valueOf(val);
        if(s.isEmpty()){
            min = value;
            s.push(min);
        }
        else if(value < min){
            s.push(2*value - min);
            min = value;
        }
        else{
            s.push(value);
        }
        

    }
    
    public void pop() {
        if(s.peek() < min){
            min = 2*min - s.peek();
        }
        s.pop();
    }
    
    public int top() {
        if(s.peek() < min){
            return min.intValue();
        }
        return s.peek().intValue();
    }
    
    public int getMin() {
        return min.intValue();
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