import java.util.*;

public class ReorderRoutes {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Construir el grafo bidireccional
        for (int[] connection : connections) {
            int a = connection[0], b = connection[1];
            graph.get(a).add(new int[]{b, 1}); // Carretera original de a a b
            graph.get(b).add(new int[]{a, 0}); // Carretera "reversa" de b a a
        }

        boolean[] visited = new boolean[n];
        return dfs(graph, visited, 0);
    }

    private int dfs(List<List<int[]>> graph, boolean[] visited, int node) {
        visited[node] = true;
        int changeCount = 0;

        for (int[] neighbor : graph.get(node)) {
            int nextNode = neighbor[0], needsChange = neighbor[1];
            if (!visited[nextNode]) {
                changeCount += needsChange + dfs(graph, visited, nextNode);
            }
        }

        return changeCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 6;
        int[][] connections = {
            {0, 1},
            {1, 3},
            {2, 3},
            {4, 0},
            {4, 5}
        };

        int result = solution.minReorder(n, connections);
        System.out.println("El número mínimo de carreteras que se deben reorientar es: " + result);
    }
}


//There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities 
//(this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

//Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

//This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

//Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

//It's guaranteed that each city can reach city 0 after reorder.