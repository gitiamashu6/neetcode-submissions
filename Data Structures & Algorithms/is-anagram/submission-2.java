class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;
        List<Integer> list = new ArrayList<>(Collections.nCopies(26,0));
        for(char i : s.toCharArray()) {
            int index = (int)i -97;
            list.set(index, list.get(index) +1);
        }
        for(char i : t.toCharArray()) {
            int index = (int)i -97;
            if(list.get(index) == 0)
                return false;
            list.set(index, list.get(index) -1);
        }
        for(int i :list) {
            if(i>0) return false;
        }
        return true;

    }
}
