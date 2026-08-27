class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            if (map.containsKey(s.charAt(r))) {
                if (l <= map.get(s.charAt(r)))
                    l = map.get(s.charAt(r)) + 1;
            }
            map.put(s.charAt(r), r);
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
