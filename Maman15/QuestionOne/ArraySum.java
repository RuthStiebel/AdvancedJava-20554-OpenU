import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//arrayList
public class ArraySum {
    private Lock[] locks;
    private int[] givenArr;
    private int[] arrSum;

    public ArraySum(int[] arr) {
        givenArr = arr;
        arrSum = new int[givenArr.length / 2];
        locks = new Lock[arr.length];
        for (int i = 0; i < arr.length; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    public int getSum(int[] arr) {
        if (arr.length == 1)
            return arrSum[0];
        return getSum(addArray());
    }

    private int[] addArray() {
        int[] arr = new int[arrSum.length / 2];
        int i = 0;
        while (i < givenArr.length - 2) {
            arr[i] = sumOfTwo(i, i + i);
            i += 2;
        }
        arrSum = arr;
        return arrSum;
    }

    private int sumOfTwo(int i, int j) {
        locks[i].lock();
        locks[j].lock();
        try {
            return givenArr[i] + givenArr[j];
        } finally {
            locks[i].unlock();
            locks[j].unlock();
        }
    }

    /*
     * import java.util.concurrent.*;

public class ArraySum {
    private int[] givenArr;
    private int[] arrSum;
    private int numThreads;

    public ArraySum(int[] arr, int numThreads) {
        givenArr = arr;
        this.numThreads = numThreads;
    }

    public int getSum() {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        arrSum = new int[givenArr.length / 2];
        int chunkSize = givenArr.length / numThreads;
        int remainder = givenArr.length % numThreads;

        int startIndex = 0;
        for (int i = 0; i < numThreads; i++) {
            int endIndex = startIndex + chunkSize + (i < remainder ? 1 : 0);
            executor.submit(new SumTask(startIndex, endIndex));
            startIndex = endIndex;
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalSum = 0;
        for (int sum : arrSum) {
            totalSum += sum;
        }
        return totalSum;
    }

    private class SumTask implements Runnable {
        private int startIndex;
        private int endIndex;

        SumTask(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public void run() {
            int sum = 0;
            for (int i = startIndex; i < endIndex; i++) {
                sum += givenArr[i];
            }
            int index = startIndex / 2;
            synchronized (ArraySum.this) {
                arrSum[index] = sum;
            }
        }
    }
}

     */
}
