class Solution {
    public String multiply(String num1, String num2) {
        int result[] = new int[num1.length() + num2.length()];
        StringBuilder re = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int r = i + num2.length();
            int c = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int m = (((num1.charAt(i) - '0') * (num2.charAt(j) - '0')) + c);
                int d = m % 10;
                c = m / 10;
                c += (result[r] + d) / 10;
                result[r] = (result[r] + d) % 10;
                r--;
                if (j == 0 && c != 0)
                    result[r] = c;
            }
        }
        boolean flag = false;
        for (int i = 0; i < result.length; i++) {
            if(result[i] != 0) flag = true;
            if(result[i] == 0 && !flag) continue;
            re.append(result[i]);
        }
        return re.length() == 0 ? "0" : re.toString();
    }
}
