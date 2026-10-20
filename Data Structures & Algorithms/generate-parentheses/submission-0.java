class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int leftCount = 0, rightCount = 0;
        return generate("",leftCount, rightCount,n);
    }

    private List<String> generate(String s, int leftCount, int rightCount, int n) {
        if(leftCount == n && rightCount == n) {
            result.add(s);
            return result;
        }

        if(leftCount < n) {
            s += '(';
            generate(s,leftCount+1,rightCount,n);
            s = s.substring(0,s.length()-1);
        }

        if(leftCount > rightCount && rightCount < n) {
            s += ')';
            generate(s,leftCount,rightCount+1,n);
            s = s.substring(0,s.length()-1);
        }

        return result;
    }
}
