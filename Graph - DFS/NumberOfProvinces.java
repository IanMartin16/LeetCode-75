public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[city][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        int result = solution.findCircleNum(isConnected);
        System.out.println("El número de provincias es: " + result);
    }
}


//There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, 
//and city b is connected directly with city c, then city a is connected indirectly with city c.

//A province is a group of directly or indirectly connected cities and no other cities outside of the group.

//You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, 
//and isConnected[i][j] = 0 otherwise.

//Return the total number of provinces.