class CustomStack {
    List<Integer> s;
    int i,maxSize;
    public CustomStack(int maxSize) {
        this.s = new ArrayList<>();
        this.i = -1;
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if(i < maxSize-1){
            s.add(x);
            i++;
        }
        return;
    }
    
    public int pop() {
        if(s.size() == 0)return -1;
        else{
            int x = s.get(i);
            s.remove(i);
            i--;
            return x;
        }
    }
    
    public void increment(int k, int val) {
        for(int j = 0;j < k && j <= i;j++){
            s.set(j,s.get(j) + val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */