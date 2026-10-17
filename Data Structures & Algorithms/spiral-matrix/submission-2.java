class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int t = 0, r = matrix[0].length - 1, l = 0, b = matrix.length - 1;
        List<Integer> result = new ArrayList<>();
        while (t <= b && l <= r) {
            for (int i = l; i <= r; i++) {
                result.add(matrix[t][i]);
            }
            t++;
            for (int i = t; i <= b; i++) {
                result.add(matrix[i][r]);
            }
            r--;
            if (t <= b && l <= r) {
                for (int i = r; i >= l; i--) {
                    result.add(matrix[b][i]);
                }
                b--;
            }
            if (t <= b && l <= r) {
                for (int i = b; i >= t; i--) {
                    result.add(matrix[i][l]);
                }
                l++;
            }
        }
        return result;
    }
}
