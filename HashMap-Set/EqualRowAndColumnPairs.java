import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualRowAndColumnPairs {
    public static int equalPairs(int[][] grid) {
        int n = grid.length;
        List<List<Integer>> rows = new ArrayList<>();
        List<List<Integer>> cols = new ArrayList<>();

        // Almacenar filas
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }
            rows.add(row);
        }

        // Almacenar columnas
        for (int j = 0; j < n; j++) {
            List<Integer> col = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                col.add(grid[i][j]);
            }
            cols.add(col);
        }

        // Contar las filas iguales a las columnas
        int count = 0;
        Map<List<Integer>, Integer> rowMap = new HashMap<>();
        
        for (List<Integer> row : rows) {
            rowMap.put(row, rowMap.getOrDefault(row, 0) + 1);
        }

        for (List<Integer> col : cols) {
            if (rowMap.containsKey(col)) {
                count += rowMap.get(col);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {3, 2, 1},
            {1, 7, 6},
            {2, 7, 7}
        };

        System.out.println(equalPairs(grid)); // Output: 1

        int[][] grid2 = {
            {3, 1, 2, 2},
            {2, 3, 2, 2},
            {1, 2, 2, 2},
            {2, 2, 2, 2}
        };

        System.out.println(equalPairs(grid2)); // Output: 4
    }
}


//Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

//A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).