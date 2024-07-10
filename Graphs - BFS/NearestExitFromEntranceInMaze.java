import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        // Marcar la entrada como visitada y agregarla a la cola
        queue.add(new int[]{entrance[0], entrance[1], 0});
        visited[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int steps = current[2];

            // Explorar las celdas adyacentes
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Verificar si la nueva posición es válida
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && maze[newRow][newCol] == '.' && !visited[newRow][newCol]) {
                    // Si estamos en el borde y no es la entrada, hemos encontrado una salida
                    if ((newRow == 0 || newRow == m - 1 || newCol == 0 || newCol == n - 1) && !(newRow == entrance[0] && newCol == entrance[1])) {
                        return steps + 1;
                    }

                    // Marcar la nueva posición como visitada y agregarla a la cola
                    queue.add(new int[]{newRow, newCol, steps + 1});
                    visited[newRow][newCol] = true;
                }
            }
        }

        // Si no encontramos ninguna salida, devolver -1
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] maze = {
            {'+', '+', '.', '+'},
            {'.', '.', '.', '+'},
            {'+', '+', '+', '.'}
        };
        int[] entrance = {1, 2};

        int result = solution.nearestExit(maze, entrance);
        System.out.println("La salida más cercana está a " + result + " pasos de distancia.");
    }
}


//You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). 
//You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] 
//denotes the row and column of the cell you are initially standing at.

//In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. 
//Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. 
//The entrance does not count as an exit.

//Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.