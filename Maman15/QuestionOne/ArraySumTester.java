public class ArraySumTester {
    public static void main(String[] args) {
        // Create an array of integers
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        // Number of threads to use for parallel processing
        int numThreads = 4;
        
        // Create an instance of ArraySum with the array and number of threads
        ArraySum arraySum = new ArraySum(arr, numThreads);
        
        // Calculate the sum of the array
        int sum = arraySum.getSum();
        
        // Print the result
        System.out.println("The sum of the array is: " + sum);
    }
}
