class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        return binarySearch(l, r, matrix, target);
    }

    private boolean binarySearch(int l, int r, int[][] matrix, int target) {
        if (l > r) {
            return false;
        }
        // while(l<=r) {
        int mid = l + (int) Math.floor((r - l) / 2);
        if (matrix[mid][matrix[mid].length - 1] >= target && matrix[mid][0] <= target) {
            return binarySearch2(0, matrix[mid].length - 1, matrix[mid], target);
        } else if (target > matrix[mid][matrix[mid].length - 1]) {
            return binarySearch(mid + 1, r, matrix, target);
        } else {
            return binarySearch(l, mid - 1, matrix, target);
        }
        // }
        // return false;
    }

    private boolean binarySearch2(int l, int r, int[] a, int t) {
        if (l > r) {
            return false;
        }
        // while(l<=r) {
        int mid = l + (int) Math.floor((r - l) / 2);
        if (a[mid] == t) {
            return true;
        } else if (t > a[mid]) {
            return binarySearch2(mid + 1, r, a, t);
        } else {
            return binarySearch2(l, mid - 1, a, t);
        }
        // }
        // return false;
    }
}
