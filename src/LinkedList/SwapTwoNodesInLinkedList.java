package LinkedList;

/**
 * Created by shiyanch on 12/2/16.
 */


public class SwapTwoNodesInLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        if (head == null || head.next == null || v1 == v2) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node1 = null;
        ListNode node2 = null;
        ListNode pre1 = null;
        ListNode pre2 = null;

        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null) {
            if (cur.val == v1 || cur.val == v2) {
                if (node1 == null) {
                    pre1 = pre;
                    node1 = cur;
                }
                else {
                    pre2 = pre;
                    node2 = cur;
                    break;
                }
            }
            pre = cur;
            cur = cur.next;
        }

        if (node1 == null || node2 == null) {
            return head;
        }

        if (node1.next == node2) {
            node1.next = node2.next;
            node2.next = node1;
            pre1.next = node2;
        }
        else {
            pre2.next = node2.next;
            node2.next = node1.next;
            pre1.next = node2;
            node1.next = pre2.next;
            pre2.next = node1;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;

        ListNode node = new SwapTwoNodesInLinkedList().swapNodes(head, 2,4);
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
    }

    // A->B
    // A->x->B
    // x->A->x->B
}
