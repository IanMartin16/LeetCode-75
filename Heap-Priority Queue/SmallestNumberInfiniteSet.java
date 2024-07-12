public class SmallestNumberInfiniteSet {
    private int current;
    private PriorityQueue<Integer> heap;
    private Set<Integer> addedBack;

    public SmallestInfiniteSet() {
        current = 1;
        heap = new PriorityQueue<>();
        addedBack = new HashSet<>();
    }

    public int popSmallest() {
        if(!heap.isEmpty()) {
            int smallest = heap.poll();
            addedBack.remove(smallest);
            return smallest;
        } else {
            return current++;
        }
    }

    public void addBack(int num) {
        if (num < current && addedBack.add(num)) {
            heap.offer(num);
        }
    }
}


//You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].

//Implement the SmallestInfiniteSet class:

//SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
//int popSmallest() Removes and returns the smallest integer contained in the infinite set.
//void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.