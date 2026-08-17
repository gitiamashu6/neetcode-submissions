class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String sortStrs[] = new String[strs.length];
        for(int i= 0; i<strs.length; i++) {
            char s[] = strs[i].toCharArray();
            Arrays.sort(s);
            sortStrs[i] = new String(s);
        }
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<sortStrs.length;i++) {
            List<String> list = new ArrayList<>();
            if(!map.containsKey(sortStrs[i])) {
                list.add(strs[i]);
                map.put(sortStrs[i], list);
            } else {
                list = map.get(sortStrs[i]);
                list.add(strs[i]);
                map.put(sortStrs[i], list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String,List<String>> m: map.entrySet()) {
            result.add(m.getValue());
        }
        return result;
    }
}
