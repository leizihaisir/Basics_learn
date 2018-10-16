package num;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author zihailei
 * @Date 2018/8/25
 * @Description
 */
public class Solution {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode nextListNode = listNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            nextListNode.next = new ListNode(sum % 10);
            nextListNode = nextListNode.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            nextListNode.next = new ListNode(carry);
        }
        return listNode.next;

    }

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        Set<String> set = new HashSet<>();
        int maxLength = 0, i = 0, j = 0;
        while (i < length && j < length) {
            String one = String.valueOf(s.charAt(j));
            if (!set.contains(one)) {
                set.add(one);
                j++;
                maxLength = Math.max(maxLength, j - i);
            } else {
                set.remove(String.valueOf(s.charAt(i++)));
            }
        }
        return maxLength;

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median;
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(nums1[i]);
        }
        for (int i : nums2) {
            set.add(nums2[i]);
        }
        int size = set.size();
        Integer[] objects = (Integer[]) set.toArray();
        if (size / 2 == 0) {
            median = (objects[(int) (size / 2 - 0.5)] + objects[(int) (size / 2 - 0.5)]) / 2;
        } else {
            median = objects[size / 2];
        }

        return median;
    }

    public static void main(String[] args) {
        String regex = "^(?![^a-zA-Z]+$)(?!\\D+$).{6,25}$";
        System.out.println("111122a".matches(regex));

    }


}
