class Solution {
    public String multiply(String num1, String num2) {
        int result[] = new int[num1.length() + num2.length()];
        String re = "";
        for(int i = num1.length()-1; i >=0; i--) {
            int r = i + num2.length();
            int c = 0;
            for(int j = num2.length()-1; j >= 0; j--) {
                int m = (((num1.charAt(i) - '0') * (num2.charAt(j) - '0')) + c);
                // System.out.println(m);
                int d = m % 10;
                c = m / 10;
                if((result[r] + d)>9) {
                    int d2 = result[r] + d;
                    d = d2 % 10;
                    c += d2 / 10;
                    // System.out.println(c + " " + d);
                    result[r] = d;
                } else result[r] += d;
                r--;
                if(j==0 && c != 0) result[r] = c;
                // System.out.println(result[0] + "-" +result[1]);
            }
        }
        boolean flag = false;
        for(int i =0; i<result.length;i++) {
            if(result[i] != 0) flag = true;
            if(result[i] == 0 && !flag) continue;
            re += result[i];
        }
        return re == "" ? "0" : re;
    }
}
