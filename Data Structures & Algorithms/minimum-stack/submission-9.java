class MinStack {
    Deque<Integer> stack;
    List<Integer> list;
    public MinStack() {
        stack = new ArrayDeque<>();
        list = new ArrayList<>();
    }

    public void push(int val) {
        stack.push(val);
        if (list.size() != 0)
            list.add(Math.min(val, list.get(list.size() - 1)));
        else
            list.add(val);
    }

    public void pop() {
        list.remove(list.size() - 1);
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return list.get(list.size() - 1);
    }
}
