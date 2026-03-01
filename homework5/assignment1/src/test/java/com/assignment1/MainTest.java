package com.assignment1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.List;

public class MainTest {
    private Main.TreeNode buildGivenExampleBST() {
        Main.TreeNode n15 = new Main.TreeNode(15);
        Main.TreeNode n6  = new Main.TreeNode(6);
        Main.TreeNode n18 = new Main.TreeNode(18);
        Main.TreeNode n3  = new Main.TreeNode(3);
        Main.TreeNode n7  = new Main.TreeNode(7);
        Main.TreeNode n17 = new Main.TreeNode(17);
        Main.TreeNode n20 = new Main.TreeNode(20);
        Main.TreeNode n2  = new Main.TreeNode(2);
        Main.TreeNode n4  = new Main.TreeNode(4);
        Main.TreeNode n13 = new Main.TreeNode(13);
        Main.TreeNode n9  = new Main.TreeNode(9);

        n15.left = n6;   n15.right = n18;
        n6.left  = n3;   n6.right  = n7;
        n18.left = n17;  n18.right = n20;
        n3.left  = n2;   n3.right  = n4;
        n7.right = n13;
        n13.left = n9;

        return n15;
    }

    @Test
    public void search_found_13() {
        Main.TreeNode root = buildGivenExampleBST();
        assertEquals(List.of(15, 6, 7, 13), Main.bstSearchTrace(root, 13));
    }

    @Test
    public void search_not_found_14() {
        Main.TreeNode root = buildGivenExampleBST();
        assertEquals(List.of(15, 6, 7, 13), Main.bstSearchTrace(root, 14));
    }

    @Test
    public void search_found_root_15() {
        Main.TreeNode root = buildGivenExampleBST();
        assertEquals(List.of(15), Main.bstSearchTrace(root, 15));
    }

    @Test
    public void search_not_found_less_than() {
        Main.TreeNode root = buildGivenExampleBST();
        assertEquals(List.of(15, 6, 3, 2), Main.bstSearchTrace(root, 1));
    }
}
