class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char str[] = s.toCharArray();
        for(int i =0; i<str.length;i++) {
            if(str[i] == '(' || str[i] == '{' || str[i] == '[') {
                stack.push(str[i]);
            } else if(stack.size() != 0){ 
                if((stack.peek() == '(' && str[i] == ')') || 
                (stack.peek() == '{' && str[i]== '}') ||
                (stack.peek() == '[' && str[i] == ']'))
                    stack.pop();
                else return false;
            } else return false;
        }
        if(stack.size() == 0) return true;
        else return false;
    }
}
