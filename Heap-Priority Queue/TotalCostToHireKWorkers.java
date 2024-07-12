import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {

    public static long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        if (n == 0 || k == 0 || candidates == 0) return 0;

        // Min-heap to select the worker with the lowest cost
        PriorityQueue<Worker> pq = new PriorityQueue<>(
            (a, b) -> a.cost != b.cost ? Integer.compare(a.cost, b.cost) : Integer.compare(a.index, b.index)
        );

        // Add the first and last 'candidates' workers to the heap
        int left = 0, right = n - 1;
        for (int i = 0; i < candidates; i++) {
            if (left <= right) {
                pq.offer(new Worker(costs[left], left));
                left++;
            }
            if (left <= right) {
                pq.offer(new Worker(costs[right], right));
                right--;
            }
        }

        long totalCost = 0;

        // Hire k workers
        for (int i = 0; i < k; i++) {
            Worker worker = pq.poll();
            totalCost += worker.cost;

            // Add the next candidate from the respective end
            if (left <= right) {
                if (worker.index < left) {
                    pq.offer(new Worker(costs[left], left));
                    left++;
                } else if (worker.index > right) {
                    pq.offer(new Worker(costs[right], right));
                    right--;
                }
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] costs = {3, 2, 7, 7, 1, 2};
        int k = 3;
        int candidates = 2;
        System.out.println(totalCost(costs, k, candidates)); // Output should be 7
    }

    static class Worker {
        int cost;
        int index;

        Worker(int cost, int index) {
            this.cost = cost;
            this.index = index;
        }
    }
}


//You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.

//You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:

//You will run k sessions and hire exactly one worker in each session.
//In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers. Break the tie by the smallest index.
//For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
//In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
//If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the tie by the smallest index.
//A worker can only be chosen once.