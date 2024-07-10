import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        
        return leaves1.equals(leaves2);
    }

    private void getLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        }
        getLeaves(node.left, leaves);
        getLeaves(node.right, leaves);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create the first sample binary tree:
        //      1
        //     / \
        //    2   3
        //   / \   \
        //  4   5   6
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(6);

        // Create the second sample binary tree:
        //      7
        //     / \
        //    2   8
        //   / \   \
        //  4   5   6
        TreeNode root2 = new TreeNode(7);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.right = new TreeNode(6);

        // Check if the two trees are leaf-similar
        boolean result = solution.leafSimilar(root1, root2);

        // Print the result
        System.out.println("Are the two trees leaf-similar? " + result); // Output: true
    }
}


//Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.