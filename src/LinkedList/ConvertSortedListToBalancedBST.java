package LinkedList;


class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class ConvertSortedListToBalancedBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode secHalf = partition(head);
        ListNode rightPart = secHalf.next;
        secHalf.next = null;
        System.out.println(secHalf.val);

        TreeNode root = new TreeNode(secHalf.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rightPart);
        return root;
    }

    private ListNode partition(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode walker = dummy;
        ListNode runner = dummy;
        ListNode pre = walker;
        while (runner != null && runner.next != null) {
            pre = walker;
            walker = walker.next;
            runner = runner.next.next;
        }

        if (pre == dummy) {
            walker = walker.next;
            pre = pre.next;
        }
        pre.next = null;
        return walker;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        head.next = a;
        a.next = b;
        b.next = c;
        new ConvertSortedListToBalancedBST().sortedListToBST(head);
        System.out.println("Done");
    }
}
