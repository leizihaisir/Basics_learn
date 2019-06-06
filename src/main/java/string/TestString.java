package string;

import num.ListNode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Author zihailei
 * @Date 2018/10/29
 * @Description
 */
public class TestString {

    public static void main(String[] args) {
        String str = "babad";
        String s = longestPalindrome(str);
        System.out.println(s);
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        Stack<ListNode> stack = new Stack<>();
        if (curr != null) {
            stack.push(head);
            while (curr.getNext() != null) {
                stack.push(curr.getNext());
                curr = curr.getNext();
            }
        }
        ListNode node = new ListNode(-1);
        curr.setNext(node);
        ListNode pop;
        while (stack.size() > 0)
            while ((pop = stack.pop()) != null) {
                node = pop;
                node = node.getNext();
            }
        return curr.getNext();


    }

    public static String longestPalindrome(String s) {
        int start = 0, max = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int temp1, temp2;
                for (temp1 = i, temp2 = j; temp1 < temp2; temp1++, temp2--) {
                    if (s.charAt(temp1) != s.charAt(temp2))
                        break;
                }
                if (temp1 >= temp2 && j - i + 1 > max) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, max);
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        if (nums.length != set.size()) {
            return true;
        } else {
            return false;
        }


    }
}