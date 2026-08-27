class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l =0, r=0, maxLen=0;
        List<Character> set = new ArrayList<>();
        char a[] = s.toCharArray();
        while(r < s.length()) {
            set.add(a[r]);
            while(set.subList(l,r).contains(a[r])) l++;
            if(set.contains(a[r])) {
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}
