class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MaximumTwinSum {
    public int pairSum(ListNode head) {
        if (head == null || head.next == null) {
            return 0;
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        ListNode secondHalf = reverseList(slow);

        // Step 3: Calculate the twin sums and find the maximum
        ListNode firstHalf = head;
        int maxTwinSum = 0;
        while (secondHalf != null) {
            int twinSum = firstHalf.val + secondHalf.val;
            maxTwinSum = Math.max(maxTwinSum, twinSum);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return maxTwinSum;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create a sample linked list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Find the maximum twin sum
        int maxTwinSum = solution.pairSum(head);

        // Print the result
        System.out.println("Maximum Twin Sum: " + maxTwinSum); // Output: 5 (1+4 or 2+3)
    }
}


//In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, 
//if 0 <= i <= (n / 2) - 1.

//For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
//The twin sum is defined as the sum of a node and its twin.

//Given the head of a linked list with even length, return the maximum twin sum of the linked list.