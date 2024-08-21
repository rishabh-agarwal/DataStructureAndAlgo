package leetcode;

/**
 * Leetcode: 23
 */

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodeList = new ArrayList<>();

        // Traverse each linked list and collect all node values
        for (ListNode node : lists) {
            while (node != null) {
                nodeList.add(node.val);
                node = node.next;
            }
        }

        // Sort all collected values
        Collections.sort(nodeList);

        // Create a new linked list from the sorted values
        ListNode head = new ListNode(0); // Dummy node
        ListNode curr = head;
        for (int val : nodeList) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return head.next; // Return the head of the merged linked list
    }
}
