class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r= s.length()-1;
        while(l<r) {
            if(s.charAt(l) != s.charAt(r)) {
                return isPlaindrome(s,l,r-1) || isPlaindrome(s, l+1, r);
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isPlaindrome(String s, int l, int r) {
        while(l<r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}