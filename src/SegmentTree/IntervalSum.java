package SegmentTree;

import java.util.ArrayList;

/**
 * Created by shiyanch on 12/8/16.
 */
class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class IntervalSum {
    public ArrayList<Long> intervalSum(int[] A,
                                       ArrayList<Interval> queries) {
        SegmentTreeNode root = build(A, 0, A.length-1);
        ArrayList<Long> list = new ArrayList<Long>();
        for (Interval query : queries) {
            list.add(query(root, query));
        }
        return list;
    }

    static class SegmentTreeNode {
        int start;
        int end;
        long sum;
        SegmentTreeNode left;
        SegmentTreeNode right;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
        }
    }

    private long query(SegmentTreeNode root, Interval query) {
        int start = query.start;
        int end = query.end;

        if (end < root.start || start > root.end) {
            return 0;
        }

        if (start <= root.start && root.end <= end) {
            return root.sum;
        }

        int mid = (root.start + root.end)/2;
        long sum = 0;
        if (start <= mid) {
            sum += query(root.left, query);
        }
        if (end > mid) {
            sum += query(root.right, query);
        }

        return sum;
    }

    private SegmentTreeNode build(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.sum = A[start];
        }
        else {
            int mid = (start + end)/2;
            root.left = build(A, start, mid);
            root.right = build(A, mid+1, end);
            root.sum = ((root.left==null)?0:root.left.sum) + ((root.right==null)?0:root.right.sum);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] A = {1,2,7,8,5};
        Interval a = new Interval(1,2);
        Interval b = new Interval(0,4);
        Interval c = new Interval(2,4);
        ArrayList<Interval> queries = new ArrayList<>();
        queries.add(a);
        queries.add(b);
        queries.add(c);

        System.out.println(new IntervalSum().intervalSum(A, queries));


    }
}
