class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        return binarySearch(l, r, matrix, target);
    }

    private boolean binarySearch(int l, int r, int[][] matrix, int target) {
        while (l <= r) {
            int mid = l + (int) Math.floor((r - l) / 2);
            if (matrix[mid][matrix[mid].length - 1] >= target && matrix[mid][0] <= target) {
                return binarySearch2(0, matrix[mid].length - 1, matrix[mid], target);
            } else if (target > matrix[mid][matrix[mid].length - 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    private boolean binarySearch2(int l, int r, int[] a, int t) {
        while (l <= r) {
            int mid = l + (int) Math.floor((r - l) / 2);
            if (a[mid] == t) {
                return true;
            } else if (t > a[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
