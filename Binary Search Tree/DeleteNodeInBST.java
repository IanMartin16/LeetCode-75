class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            // Buscar en el subárbol izquierdo
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // Buscar en el subárbol derecho
            root.right = deleteNode(root.right, key);
        } else {
            // Nodo encontrado
            if (root.left == null) {
                // Caso 1: Nodo con un solo hijo (derecho) o sin hijos
                return root.right;
            } else if (root.right == null) {
                // Caso 2: Nodo con un solo hijo (izquierdo)
                return root.left;
            } else {
                // Caso 3: Nodo con dos hijos
                // Encontrar el sucesor (el valor mínimo en el subárbol derecho)
                TreeNode minNode = findMin(root.right);
                // Reemplazar el valor del nodo a eliminar con el valor del sucesor
                root.val = minNode.val;
                // Eliminar el sucesor en el subárbol derecho
                root.right = deleteNode(root.right, minNode.val);
            }
        }

        return root;
    }

    // Método para encontrar el nodo con el valor mínimo en un árbol
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Crear un ejemplo de BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int key = 3;
        TreeNode result = solution.deleteNode(root, key);
        System.out.println("BST después de eliminar el nodo con valor " + key + ":");
        printTree(result);
    }

    // Método auxiliar para imprimir el árbol (en orden)
    public static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }
}


//Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
//Return the root node reference (possibly updated) of the BST.

//Basically, the deletion can be divided into two stages:

//Search for a node to remove.
//If the node is found, delete the node.