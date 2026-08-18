class Solution {

    public String encode(List<String> strs) {
        String s = "";
        for(int i = 0; i<strs.size();i++) {
            s += strs.get(i).length()+ "#";
            s += strs.get(i);
        }
        return s;
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        if(str == "") {
            return list;
        }
        char d[] = str.toCharArray();
        for(int i = 0; i<d.length;i++) {
            int j = i;
            while(d[i] != '#') i++;
            int len = Integer.parseInt(str.substring(j,i));
            list.add(str.substring(i+1,i+1+len));
            i = i+len;
        }
        return list;
    }
}
