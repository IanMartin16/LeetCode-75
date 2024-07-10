class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class LongestZigzagPath {

    private int longestZigZag = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // Starting from both left and right directions
        findLongest(root.left, true, 1);
        findLongest(root.right, false, 1);
        
        return longestZigZag;
    }

    private void findLongest(TreeNode node, boolean isLeft, int length) {
        if (node == null) {
            // Update longest path found
            longestZigZag = Math.max(longestZigZag, length - 1);
            return;
        }
        
        // If moving left, switch to right direction; vice versa
        if (isLeft) {
            findLongest(node.right, false, length + 1);
        } else {
            findLongest(node.left, true, length + 1);
        }
        
        // Continue in the same direction
        if (isLeft) {
            findLongest(node.left, true, 1);
        } else {
            findLongest(node.right, false, 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1:
        //      1
        //     / \
        //    2   3
        //   / \   \
        //  4   5   6
        //     /
        //    7
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(6);
        root1.left.right.left = new TreeNode(7);
        System.out.println("Longest ZigZag path length: " + solution.longestZigZag(root1)); // Output: 3
        
        // Example 2:
        //      1
        //     /
        //    1
        //     \
        //      1
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(1);
        System.out.println("Longest ZigZag path length: " + solution.longestZigZag(root2)); // Output: 2
    }
}


//You are given the root of a binary tree.

//A ZigZag path for a binary tree is defined as follow:

//Choose any node in the binary tree and a direction (right or left).
//If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
//Change the direction from right to left or from left to right.
//Repeat the second and third steps until you can't move in the tree.
//Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

//Return the longest ZigZag path contained in that tree.