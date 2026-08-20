class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else
                map.put(nums[i], 1);
        }
        // Map<Integer, Integer> sorted =
        //     map.entrySet()
        //         .stream()
        //         .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
        //         .collect(Collectors.toMap(
        //             Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        // List<Integer> list = new ArrayList(sorted.keySet());
        int result[] = new int[k];
        // for (int i = 0; i < k; i++) {
        //     result[i] = list.get(i);
        // }
        // return result;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=nums.length;i++) list.add(new ArrayList<>());
        for(Map.Entry m : map.entrySet()) {
            List<Integer> list1 = list.get((int)m.getValue());
            list1.add((int)m.getKey());
            list.set((int)m.getValue(),list1);
        }
        List<Integer> r = new ArrayList<>();
        for(int i= list.size()-1; i>=0; i--) {
            if(list.get(i).size() > 0 && r.size() < k) {
                r.addAll(list.get(i));
            }
        }
        return r.subList(0,k).stream().mapToInt(Integer::intValue).toArray();
    }
}
