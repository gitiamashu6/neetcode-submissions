class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return digitSum(n, set);
    }

    private boolean digitSum(int n, Set set) {
        int sum = 0;
        while(n != 0) {
            int r = n % 10;
            n = n / 10;
            sum += r*r;
        }
        // System.out.println(sum);
        if(sum == 1) return true;
        else if(!set.add(sum)) return false;
        else {
            return digitSum(sum, set);
        }
        // return false;
    }
}
