class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}

public class SearchInBinaryTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        // If the value of the current node is equal to val, return the current node
        if (root.val == val) {
            return root;
        }

        // If the value is less than the current node's value, search in the left subtree
        if (val < root.val) {
            return searchBST(root.left, val);
        }

        // If the value is greater than the current node's value, search in the right subtree
        return searchBST(root.right, val);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int val = 2;
        TreeNode result = solution.searchBST(root, val);
        if (result != null) {
            System.out.println("Subtree rooted with node of value " + val + " found.");
        } else {
            System.out.println("Node with value " + val + " not found.");
        }
    }
}


//You are given the root of a binary search tree (BST) and an integer val.

//Find the node in the BST that the node's value equals val and return the subtree rooted with that node. 
//If such a node does not exist, return null.