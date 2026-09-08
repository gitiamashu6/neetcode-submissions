class TimeMap {
    Map<String, List<Object[]>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key))
            map.put(key, new ArrayList<>());
        map.get(key).add(new Object[] {timestamp, value});
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Object[]> list = map.get(key);
        int l = 0, r = list.size() - 1;
        return binarySearch(l, r, list, timestamp);
    }

    private String binarySearch(int l, int r, List<Object[]> list, int timestamp) {
        while (l <= r) {
            int mid = l + (int) Math.floor((r - l) / 2);
            if ((Integer) list.get(mid)[0] == timestamp)
                return (String) list.get(mid)[1];
            if ((Integer) list.get(mid)[0] < timestamp)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return r < 0 ? "" : (String) list.get(r)[1];
    }
}
