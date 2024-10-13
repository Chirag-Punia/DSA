class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        int max = Integer.MIN_VALUE;
        int rangeLeft = 0, rangeRight = Integer.MAX_VALUE;
        
        
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new Element(val, i, 0));
            max = Math.max(max, val);
        }
        
        while (minHeap.size() == nums.size()) {
            Element curr = minHeap.poll();
            
            if (max - curr.val < rangeRight - rangeLeft) {
                rangeLeft = curr.val;
                rangeRight = max;
            }
            
            if (curr.idx + 1 < nums.get(curr.list).size()) {
                int nextVal = nums.get(curr.list).get(curr.idx + 1);
                minHeap.offer(new Element(nextVal, curr.list, curr.idx + 1));
                max = Math.max(max, nextVal);
            }
        }
        
        return new int[]{rangeLeft, rangeRight};
    }
    
    private class Element {
        int val;
        int list;
        int idx;
        
        Element(int val, int list, int idx) {
            this.val = val;
            this.list = list;
            this.idx = idx;
        }
    }
}