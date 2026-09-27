class Solution {
    public String multiply(String num1, String num2) {
        int result[] = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int c = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int m = (((num1.charAt(i) - '0') * (num2.charAt(j) - '0')) + result[i+j+1] + c);
                result[i+j+1] = m % 10;
                c = m / 10;
            }
            result[i] = c;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < result.length - 1 && result[i] == 0) i++;
        while (i < result.length) sb.append(result[i++]);
        return sb.toString();
    }
}
