import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicInteger;

public class ArraySum {
    private Lock[] locks;
    private int[] givenArr;
    private ArrayList<Integer> arrSum;
    private int numThreads;

    // Constructor to initialize the ArraySum object
    public ArraySum(int[] arr, int numThreads) {
        givenArr = arr;
        this.numThreads = numThreads;
        // Initialize ArrayList with the same size as input array
        arrSum = new ArrayList<>(arr.length);
        locks = new Lock[arr.length];
        // Initializing locks for each element in the array
        for (int i = 0; i < arr.length; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    // Method to calculate the sum of the array using multiple threads
    public int getSum() {
        // Adding a placeholder value to the result ArrayList
        arrSum.add(0);
        // Calling the recursive method to calculate the sum
        return getSumRecursive(givenArr, givenArr.length, numThreads);
    }

    // Recursive method to divide the array and calculate the sum using multiple
    // threads
    private int getSumRecursive(int[] arr, int n, int threads) {
        // Base case: If only one element remains, return it
        if (n == 1)
            return arr[0];

        // Array to store the sums of consecutive pairs of elements
        int[] temp = new int[n / 2];
        Thread[] threadArr = new Thread[threads];

        // Calculating the sums and acquiring locks for each pair of elements
        for (int i = 0; i < n / 2; i++) {
            temp[i] = arr[i * 2] + arr[i * 2 + 1];
            locks[i * 2].lock();
            locks[i * 2 + 1].lock();
        }

        // Accumulator for the sum calculated by each thread
        int sum = 0;

        // Loop through the subarray and calculate the sum
        for (int i = 0; i < n / 2; i++) {
            sum += temp[i];
            arrSum.add(temp[i]); // Add each sum to the ArrayList
            locks[i * 2].unlock();
            locks[i * 2 + 1].unlock();
        }

        // AtomicInteger to track the number of active threads
        AtomicInteger activeThreads = new AtomicInteger(threads);
        for (int i = 0; i < threads; i++) {
            int startIndex = i * (n / threads);
            int endIndex = (i + 1) * (n / threads);
            if (i == threads - 1)
                endIndex = n / 2;
            final int finalEndIndex = endIndex; // Copying endIndex to a final variable
            threadArr[i] = new Thread(() -> {
                // Recursive call to calculate the sum
                int result = getSumRecursive(temp, finalEndIndex - startIndex, threads); // Using finalEndIndex
                synchronized (this) {
                    // Decrementing the number of active threads atomically
                    activeThreads.decrementAndGet();
                    // If all threads have completed, notify the main thread
                    if (activeThreads.get() == 0) {
                        notify();
                    }
                }
            });
            threadArr[i].start();
        }

        // Main thread waits until all threads have completed
        synchronized (this) {
            while (activeThreads.get() > 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // Returning the accumulated sum
        return sum;
    }
}
