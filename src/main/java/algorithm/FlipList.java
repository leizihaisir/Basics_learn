package algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author zihailei
 * @Date 2019/3/10
 * @Description
 */
public class FlipList {

    static final List<Integer> list = new LinkedList();

    static {
        for (int i = 0; i <= 10; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        list.forEach(m -> stack.push(m));
        List<Integer> newList = new LinkedList();
        while (!stack.empty()) {
            newList.add(stack.pop());
        }
        newList.forEach(l -> System.out.println(l));


    }

}


