package leetcode;

import java.util.HashMap;

/**
 * Leetcode: 138
 */
public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            HashMap<Node, Node> map = new HashMap<>();
            Node curr = head;

            while(curr!=null){
                map.put(curr, new Node(curr.val));
               curr = curr.next;
            }

            Node newCurr = head;
            while(newCurr!=null){
                map.get(newCurr).next = map.get(newCurr.next);
                map.get(newCurr).random = map.get(newCurr.random);
                newCurr = newCurr.next;
            }

            return map.get(head);
        }
    }
}
