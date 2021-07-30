package com.mrxu;
import java.util.Objects;

/**
 * @author jlxu@telenav.cn
 * @date 2021/7/13 17:53
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9))));
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode result = new ListNode();
        ListNode result_temp = result;
        boolean carryBit = false;
        while (true) {
            int sum = carryBit ? (temp1 == null ? 0 : temp1.val) + (temp2 == null ? 0 : temp2.val) + 1 : (temp1 == null ? 0 : temp1.val) + (temp2 == null ? 0 : temp2.val);
            int lastBit = (carryBit = sum >= 10) ? sum - 10 : sum;
            if (Objects.nonNull(temp1) || Objects.nonNull(temp2)) {
                result_temp.val = lastBit;
                result_temp.next = new ListNode();
                ListNode isDeleteNode = result_temp;
                result_temp = result_temp.next;
                temp1 = temp1 == null ? null : temp1.next;
                temp2 = temp2 == null ? null : temp2.next;
                if (temp1 == null && temp2 == null){
                    if (carryBit){
                        result_temp.val = 1;
                    } else {
                        isDeleteNode.next = null;
                    }
                    break;
                }
            }
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
