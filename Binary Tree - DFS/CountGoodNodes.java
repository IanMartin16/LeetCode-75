class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class countGoodNodes {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }
    
    private int countGoodNodes(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }
        
        // Check if the current node is a good node
        int count = node.val >= maxSoFar ? 1 : 0;
        
        // Update maxSoFar for the child nodes
        maxSoFar = Math.max(maxSoFar, node.val);
        
        // Recursively count good nodes in left and right subtrees
        count += countGoodNodes(node.left, maxSoFar);
        count += countGoodNodes(node.right, maxSoFar);
        
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1:
        //      3
        //     / \
        //    1   4
        //   / \   \
        //  3   1   5
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(1);
        root1.right.right = new TreeNode(5);
        System.out.println("Number of good nodes: " + solution.goodNodes(root1)); // Output: 4
        
        // Example 2:
        //      10
        //     / \
        //    5   15
        //   / \    \
        //  3   7    18
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(7);
        root2.right.right = new TreeNode(18);
        System.out.println("Number of good nodes: " + solution.goodNodes(root2)); // Output: 3
    }
}


//Given a binary tree root, a node X in the tree is named good 
//if in the path from root to X there are no nodes with a value greater than X.

//Return the number of good nodes in the binary tree.