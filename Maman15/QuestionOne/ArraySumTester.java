public class ArraySumTester {
    public static void main(String[] args) {
        // Create an array to sum
        int[] array = {1, 2, 3, 4, 5, 6};

        // Define the number of concurrent threads
        int numThreads = 4;

        // Create an instance of ArraySum
        ArraySum arraySum = new ArraySum(array,// numThreads);

        // Calculate the sum of the array
        int sum = arraySum.getSum();

        // Print the result
        System.out.println("Sum of the array: " + sum);
    }
}
