class MyCalendar {
    TreeMap<Integer, Integer> mpp;
    public MyCalendar() {
    mpp = new TreeMap();

    }
    
    public boolean book(int start, int end) {
    Integer prevBook = mpp.floorKey(start);
    Integer nextBook = mpp.ceilingKey(start);
    if((prevBook==null || mpp.get(prevBook)<=start) && (nextBook==null || end<=nextBook)) 
    { 
    mpp.put(start, end);
    return true;
    }
    return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */