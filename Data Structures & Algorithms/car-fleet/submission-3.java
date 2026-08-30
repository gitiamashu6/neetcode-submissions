class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Double> stack = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            list.add(new int[] {position[i], speed[i]});
        }
        list.sort((a, b) -> Integer.compare(a[0], b[0]));

        for (int[] a : list) {
            stack.push((double)(target - a[0]) / a[1]);
        }
        int fleet = 1;
        while (stack.size() > 1) {
            double a = stack.pop();
            if (stack.peek() > a) {
                fleet++;
            } else {
                stack.pop();
                stack.push(a);
            }
        }

        return fleet;
    }
}
