import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArraySum {
    private boolean endFlag;
    private Lock[] locks;
    private int[] arrNum;
    private LinkedList<Integer> listSum;

    public ArraySum (int[] arr) {
        listSum = new LinkedList<Integer>();
        arrNum = arr;
        locks = new Lock[arr.length];
        for (int i=0; i<arr.length; i++) {
            locks[i] = new ReentrantLock();
        }
    }



    private int sumOfTwo(int i, int j) {
        locks[i].lock();
        locks[j].lock();
        try {
            return arrNum[i] + arrNum[j];
        }
        finally {
            locks[i].unlock();
            locks[j].unlock();
        }
    }
}
