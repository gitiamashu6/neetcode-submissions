class Solution {
    public int[] countBits(int n) {
        int result[] = new int[n+1];
        for(int i=0;i<=n;i++) {
            int count =0, n2 = i;
            while(n2 != 0) {
                int r = n2 % 2;
                n2 = n2 / 2;
                if( r == 1) count++;
            }
            result[i] = count;
        }
        return result;
    }
}
