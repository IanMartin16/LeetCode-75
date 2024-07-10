import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}

public class MaxLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Initialize variables to store the maximum sum and the corresponding level
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;

        // Queue to perform BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int currentLevelSum = 0;

            // Iterate through nodes in the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevelSum += node.val;

                // Add child nodes to the queue for the next level
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            // Check if the current level sum is the maximum sum
            if (currentLevelSum > maxSum) {
                maxSum = currentLevelSum;
                maxLevel = level;
            }

            level++;
        }

        return maxLevel;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        int result = solution.maxLevelSum(root);
        System.out.println("Smallest level with maximum sum: " + result); // Output should be 2
    }
}


//Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

//Return the smallest level x such that the sum of all the values of nodes at level x is maximal.