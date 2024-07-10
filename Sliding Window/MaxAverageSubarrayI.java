public class MaxAverageSubarrayI {
    public static double findMaxAverage(int[] nums, int k) {
        // Inicializar la suma de los primeros k elementos
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        // Inicializar el máximo promedio con el promedio de los primeros k elementos
        double maxAverage = sum / k;
        
        // Usar la técnica de la ventana deslizante para encontrar el máximo promedio
        for (int i = k; i < nums.length; i++) {
            // Actualizar la suma quitando el elemento de la izquierda y añadiendo el nuevo elemento
            sum = sum - nums[i - k] + nums[i];
            // Calcular el nuevo promedio y actualizar el máximo promedio si es mayor
            maxAverage = Math.max(maxAverage, sum / k);
        }
        
        return maxAverage;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 12, -5, -6, 50, 3};
        int k1 = 4;
        System.out.println(findMaxAverage(nums1, k1)); // Output: 12.75

        int[] nums2 = {5};
        int k2 = 1;
        System.out.println(findMaxAverage(nums2, k2)); // Output: 5.0
    }
}


//You are given an integer array nums consisting of n elements, and an integer k.

//Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. 
//Any answer with a calculation error less than 10-5 will be accepted.