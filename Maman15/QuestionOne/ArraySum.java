import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
}
