class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxLen = 0, maxFre = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            if (!map.containsKey(s.charAt(r)))
                map.put(s.charAt(r), 1);
            else
                map.put(s.charAt(r), map.get(s.charAt(r)) + 1);
            maxFre = Math.max(maxFre, map.get(s.charAt(r)));
            if ((r - l + 1) - maxFre <= k)
                maxLen = Math.max(maxLen, r - l + 1);
            if ((r - l + 1) - maxFre > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            r++;
        }
        return maxLen;
    }
}
