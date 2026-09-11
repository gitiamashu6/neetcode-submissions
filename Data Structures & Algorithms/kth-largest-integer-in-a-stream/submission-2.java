class KthLargest {
    Queue<Integer> maxHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) maxHeap.add(nums[i]);
        this.k = k;
    }

    public int add(int val) {
        maxHeap.add(val);
        int value =0;
        int a[] = new int[k];
        for (int i = 0; i < k; i++) {
            if(!maxHeap.isEmpty())
                a[i] = maxHeap.poll();
            if (i == k - 1) {
                value= a[k - 1];
            }
        }
        for (int i = 0; i < a.length; i++) {
            maxHeap.add(a[i]);
        }
        return value;
       
    }
}
