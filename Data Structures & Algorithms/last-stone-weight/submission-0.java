class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) maxHeap.add(stones[i]);
        while (maxHeap.size() > 1) maxHeap.add(maxHeap.poll() - maxHeap.poll());
        return maxHeap.peek();
    }
}
