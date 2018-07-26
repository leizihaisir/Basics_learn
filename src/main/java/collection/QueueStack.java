package collection;

import java.util.Stack;

/**
 * @Author zihailei
 * @Date 2018/7/7
 * @Description
 */
public class QueueStack {

    Stack<Integer> stackLeft = new Stack<Integer>();
    Stack<Integer> stackRight = new Stack<Integer>();

    private void push(Integer node) {
        stackLeft.push(node);
    }

    public int pop() {
        if (stackRight.empty()) {
            while (!stackLeft.empty())
                stackRight.push(stackLeft.pop());
        }
        return stackRight.pop();
    }


    public static void main(String[] args) {

        QueueStack queueStack = new QueueStack();
        for (int i = 0; i < 10; i++) {
            queueStack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(queueStack.pop());
        }
    }
}
