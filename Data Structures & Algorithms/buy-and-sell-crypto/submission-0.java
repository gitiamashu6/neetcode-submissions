class Solution {
    public int maxProfit(int[] prices) {
        int p=0;
        int s=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++) {
            if(prices[i] < s) s=prices[i];
            else if(prices[i] >= s) {
                p=Math.max(p, prices[i]-s);
            }
            else continue;
        }
        return p;
    }
}
