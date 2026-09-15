class Solution {
    public int[] plusOne(int[] digits) {
        int q = 1;
        int len = digits.length - 1;
        while (q != 0 && len >= 0) {
            int r = (digits[len] + q) % 10;
            q = (digits[len] + q) / 10;
            digits[len] = r;
            len--;
        }
        if (q != 0) {
            int[] result = new int[digits.length + 1];
            result[0] = q;
            for (int i = 1; i < digits.length; i++) {
                result[i] = digits[i];
            }
            return result;
        }
        return digits;
    }
}
