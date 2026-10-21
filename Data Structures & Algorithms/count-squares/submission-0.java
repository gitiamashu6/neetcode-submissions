class CountSquares {
    private Map<Integer, Map<Integer, Integer>> points;

    public CountSquares() {
        points = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        points.putIfAbsent(x, new HashMap<>());

        Map<Integer, Integer> ys = points.get(x);
        ys.put(y, ys.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int result = 0;

        Map<Integer, Integer> ys = points.get(x);

        if (ys == null) return 0;

        for (Map.Entry<Integer, Integer> entry : ys.entrySet()) {
            int y2 = entry.getKey();

            if (y2 == y) continue;

            int side = Math.abs(y2 - y);
            int verticalCount = entry.getValue();

            for (int direction : new int[]{-1, 1}) {
                int x2 = x + direction * side;

                int horizontalCount =
                    points.getOrDefault(x2, Collections.emptyMap())
                          .getOrDefault(y, 0);

                int oppositeCount =
                    points.getOrDefault(x2, Collections.emptyMap())
                          .getOrDefault(y2, 0);

                result += verticalCount
                        * horizontalCount
                        * oppositeCount;
            }
        }

        return result;
    }
}
