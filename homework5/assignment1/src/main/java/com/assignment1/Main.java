package com.assignment1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static class TreeNode {
        public Integer key;
        public TreeNode left, right;

        public TreeNode(Integer key) {
            this.key = key;
        }
    }

    public static List<Integer> bstSearchTrace(TreeNode root, Integer k) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.key.equals(k)) {
            List<Integer> trace = new ArrayList<>();
            trace.add(root.key);
            return trace;
        }

        List<Integer> childTrace;
        if (k < root.key) {
            childTrace = bstSearchTrace(root.left, k);
        } else {
            childTrace = bstSearchTrace(root.right, k);
        }

        childTrace.add(0, root.key);
        return childTrace;
    }
    public static void main(String[] args) {
    }
}