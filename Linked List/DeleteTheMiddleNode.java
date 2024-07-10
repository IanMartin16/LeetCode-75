class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DeleteTheMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // If the list is empty or has only one node, return null
        }

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Move fast pointer two steps and slow pointer one step at a time
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node
        if (prev != null) {
            prev.next = slow.next;
        }

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

        // Delete the middle node
        ListNode modifiedHead = solution.deleteMiddle(head);

        // Print the modified linked list
        ListNode current = modifiedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}


//You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

//The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ 
//denotes the largest integer less than or equal to x.

//For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.