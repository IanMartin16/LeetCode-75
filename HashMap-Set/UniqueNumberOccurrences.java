import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOccurrences {

    public static boolean uniqueOccurrences(int[] arr) {
        // Crear un mapa para contar las ocurrencias de cada número
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        for (int num : arr) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // Crear un conjunto para almacenar las frecuencias
        HashSet<Integer> frequencies = new HashSet<>();
        for (int frequency : occurrences.values()) {
            // Si la frecuencia ya está en el conjunto, no es única
            if (!frequencies.add(frequency)) {
                return false;
            }
        }

        // Si todas las frecuencias son únicas, devolver true
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1, 1, 3};
        int[] arr2 = {1, 2};
        int[] arr3 = {3, 3, 3, 3, 3};

        System.out.println(uniqueOccurrences(arr1)); // Output: true
        System.out.println(uniqueOccurrences(arr2)); // Output: false
        System.out.println(uniqueOccurrences(arr3)); // Output: true
    }
}


//Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.