class MyStack {

    class DoubleDirectionNode {
        int val;
        DoubleDirectionNode prev;
        DoubleDirectionNode next;

        DoubleDirectionNode(int val, DoubleDirectionNode prev, DoubleDirectionNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    DoubleDirectionNode dummyHead;
    DoubleDirectionNode end;
    /** Initialize your data structure here. */
    public MyStack() {
        dummyHead = new DoubleDirectionNode(0, null, null);
        end = dummyHead;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        end.next = new DoubleDirectionNode(x, end, null);
        end = end.next;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()) {
            return -1;
        }
        int val = end.val;
        end = end.prev;
        end.next = null;
        return val;
    }
    
    /** Get the top element. */
    public int top() {
        if (empty()) {
            return -1;
        }
        return end.val;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return end == dummyHead;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
