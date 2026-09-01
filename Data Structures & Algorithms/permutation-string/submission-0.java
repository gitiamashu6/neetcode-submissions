class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        int l = 0, r = 0;
        for (int i = 0; i < s1.length(); i++) arr1[(int) s1.charAt(i) - 97] += 1;
        while (r < s2.length()) {
            arr2[(int) s2.charAt(r) - 97] += 1;
            if (r - l == s1.length() - 1) {
                if (Arrays.equals(arr1, arr2))
                    return true;
                else {
                    arr2[(int) s2.charAt(l) - 97] -= 1;
                    l++;
                }
            }
            r++;
        }
        return false;
    }
}
