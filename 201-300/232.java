class MyQueue {
    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();
    
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!input.empty())
        {
            output.push(input.pop());
        }
        output.push(x);
        while(!output.empty())
        {
            input.push(output.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return input.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return input.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.empty();
    }
}
Explanation:
利用两个栈，一个栈当缓冲栈，一个栈当输出栈。

--------------update------------------
Stack<Integer> input =new Stack<Integer>();
    Stack<Integer> output=new Stack<Integer>();
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!output.empty())
        {
            return output.pop();
        }
        while(!input.empty())
        {
            output.push(input.pop());
        }
        return output.pop();
    }
    
    /** Get the front element. */
    public int peek() {
            if(!output.empty())
        {
            return output.peek();
        }
        while(!input.empty())
        {
            output.push(input.pop());
        }
        return output.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.empty()&&output.empty();
    }
}
Explanation:
同样需要两个栈，但与上面不同的是，上面每一次输出都需要把栈数据倒到另一个栈输出后，再将栈元素倒回来。
这里是若要出列，若output不为空，便直接在output出列，若为空，便从input把元素倒进来再输出。减少连续输出的时候的资源
消耗。
