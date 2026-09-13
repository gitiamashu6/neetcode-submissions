class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Map.Entry<String, Double>> maxHeap =
            new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));
        int a[][] = new int[k][2];
        for (int i = 0; i < points.length; i++) {
            double d = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            maxHeap.add(new AbstractMap.SimpleEntry<>(String.valueOf(i), d));
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        int i = 0;
        while (!maxHeap.isEmpty()) {
            Map.Entry<String, Double> e = maxHeap.poll();
            if (i < k) {
                a[i] = points[Integer.parseInt(e.getKey())];
                i++;
            }
        }
        return a;
    }
}
