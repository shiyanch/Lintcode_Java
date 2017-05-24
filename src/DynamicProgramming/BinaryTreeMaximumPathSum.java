package DynamicProgramming;

/**
 * Created by shiyanch on 11/19/16.
 */


class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BinaryTreeMaximumPathSum {
    /*
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        TreeNode a = new TreeNode(-20);
        TreeNode b = new TreeNode(-31);
        TreeNode c = new TreeNode(-24);
        TreeNode d = new TreeNode(-5);
        TreeNode e = new TreeNode(-6);
        TreeNode f = new TreeNode(-7);
        TreeNode g = new TreeNode(-8);
        TreeNode h = new TreeNode(-9);

        root.left = a;
        a.right = b;
        b.left = c;
        b.right = d;
        d.left = e;
        d.right = f;
        e.left = g;
        e.right = h;

        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
    }
}
