import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDifferenceOfTwoArrays {

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Añadir todos los elementos de nums1 al conjunto set1
        for (int num : nums1) {
            set1.add(num);
        }

        // Añadir todos los elementos de nums2 al conjunto set2
        for (int num : nums2) {
            set2.add(num);
        }

        // Crear listas para almacenar los elementos distintos
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Encontrar los elementos en set1 que no están en set2
        for (int num : set1) {
            if (!set2.contains(num)) {
                list1.add(num);
            }
        }

        // Encontrar los elementos en set2 que no están en set1
        for (int num : set2) {
            if (!set1.contains(num)) {
                list2.add(num);
            }
        }

        // Crear la lista de respuesta
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(list1);
        answer.add(list2);

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};

        List<List<Integer>> result = findDifference(nums1, nums2);
        System.out.println("Distinct elements in nums1 not in nums2: " + result.get(0));
        System.out.println("Distinct elements in nums2 not in nums1: " + result.get(1));
    }
}


//Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

//answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
//answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
//Note that the integers in the lists may be returned in any order.