public class Solution {
	private Queue<Integer> minHeap = new PriorityQueue<>();
	private Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer x, Integer y) {
			return y-x;
		}
	});

	// Adds a number into the data structure.
	public void addNum(int num) {
		if ((minHeap.size() + maxHeap.size()) % 2 == 0) {  // 当前为偶数，加入到小根堆
			maxHeap.offer(num);  // 为了保证大根堆的数都比小根堆的数小，需要先加入大根堆再取最大值加入小根堆
			minHeap.offer(maxHeap.poll());
		}
		else {  // 当前为奇数，加入到大根堆
			minHeap.offer(num);
			maxHeap.offer(minHeap.poll());
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if ((minHeap.size() + maxHeap.size()) % 2 == 0) {
			return ((double) (minHeap.peek() + maxHeap.peek())) / 2;
		}
		else  {
			return minHeap.peek();
		}
	}
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
