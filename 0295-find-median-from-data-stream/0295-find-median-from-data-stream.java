import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {
    PriorityQueue<Integer> pq;
    PriorityQueue<Integer> q;
    
    public MedianFinder() {
        this.pq = new PriorityQueue<>(Collections.reverseOrder());
        this.q = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (pq.isEmpty() || num <= pq.peek()) {
            pq.offer(num);
        } else {
            q.offer(num);
        }

        if (pq.size() > q.size() + 1) {
            q.offer(pq.poll());
        } else if (q.size() > pq.size()) {
            pq.offer(q.poll());
        }
    }
    
    public double findMedian() {
        if (pq.size() == q.size()) {
            return (pq.peek() + q.peek()) / 2.0;
        } else {
            return pq.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
