class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0; i<nums.length;i++){
            if(map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            } else map.put(nums[i],1);
        }
        Map<Integer, Integer> sorted = map.entrySet()
        .stream()
        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
        .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (a, b) -> a,
                LinkedHashMap::new
        ));
        List<Integer> list = new ArrayList(sorted.keySet());
        int result[] = new int[k];
        for(int i =0; i<k;i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
