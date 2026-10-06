class Solution {
    public void setZeroes(int[][] matrix) {
        boolean flag = true;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    map.put("" + j + i, matrix[i][j]);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0 && flag && map.containsKey(""+j+i)) {
                    flag = false;
                    j = 0;
                }
                if (!flag) {
                    matrix[i][j] = 0;
                }
            }
            flag = true;
        }
        // System.out.println(map);
        // System.out.println(flag);

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 0 && flag && map.containsKey("" + i + j)) {
                    flag = false;
                    j = 0;
                }
                if (!flag) {
                    matrix[j][i] = 0;
                }
            }
            flag = true;
        }
        // System.out.println(matrix.toString());
    }
}
