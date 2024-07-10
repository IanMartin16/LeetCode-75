import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        
        // Comenzamos desde la habitación 0
        visited[0] = true;
        stack.push(0);
        
        while (!stack.isEmpty()) {
            int currentRoom = stack.pop();
            
            // Obtener todas las llaves en la habitación actual
            for (int key : rooms.get(currentRoom)) {
                if (!visited[key]) {
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }
        
        // Verificar si todas las habitaciones han sido visitadas
        for (boolean roomVisited : visited) {
            if (!roomVisited) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Ejemplo de prueba
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<>(List.of(1)));
        rooms.add(new ArrayList<>(List.of(2)));
        rooms.add(new ArrayList<>(List.of(3)));
        rooms.add(new ArrayList<>());

        boolean result = solution.canVisitAllRooms(rooms);
        System.out.println("Se pueden visitar todas las habitaciones: " + result);
    }
}


//There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. 
//However, you cannot enter a locked room without having its key.

//When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, 
//and you can take all of them with you to unlock the other rooms.

//Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, 
//return true if you can visit all the rooms, or false otherwise.