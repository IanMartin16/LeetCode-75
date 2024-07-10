class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        // Initialize pointers for odd and even nodes
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        // Iterate through the linked list
        while (even != null && even.next != null) {
            odd.next = even.next; // Link current odd node to the next odd node
            odd = odd.next; // Move odd pointer to the next odd node
            even.next = odd.next; // Link current even node to the next even node
            even = even.next; // Move even pointer to the next even node
        }

        // Connect the end of odd nodes to the head of even nodes
        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reorder the linked list
        ListNode reorderedHead = solution.oddEvenList(head);

        // Print the reordered linked list
        ListNode current = reorderedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}


//Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

//The first node is considered odd, and the second node is even, and so on.

//Note that the relative order inside both the even and odd groups should remain as it was in the input.

//You must solve the problem in O(1) extra space complexity and O(n) time complexity.