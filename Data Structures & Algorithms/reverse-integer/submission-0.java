class Solution {
    public int reverse(int x) {
        long res =0;
        while(x !=0) {
            res = 10 * res + x % 10;
            x = x / 10;
        }
        // System.out.println(res);
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        return (int)res;
    }
}
