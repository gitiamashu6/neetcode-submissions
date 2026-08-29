class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+" -> {
                    int a = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(Integer.parseInt(stack.pop()) + a));
                }
                case "-" -> {
                    int a = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(Integer.parseInt(stack.pop()) - a));
                }

                case "*" -> {
                    int a = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(Integer.parseInt(stack.pop()) * a));
                }
                case "/" -> {
                    int a = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf((int)Math.floor(Integer.parseInt(stack.pop())) / a));
                }
                default -> stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
