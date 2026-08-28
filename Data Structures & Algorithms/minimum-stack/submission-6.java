class MinStack {
    Deque<Integer> stack;
    List<Integer> list;
    int minV ;
    public MinStack() {
        stack = new ArrayDeque<>();
        list = new ArrayList<>();
        minV = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.push(val);
        if(list.size() != 0)
            minV = Math.min(val,list.get(list.size()-1));
        if(list.size() == 0)
            minV = val;
        list.add(minV);
    }
    
    public void pop() {
        // if(list.get(list.size()-1) == stack.peek()) 
            list.remove(list.size()-1);
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return list.get(list.size()-1);
    }
}
