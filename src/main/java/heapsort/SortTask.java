package heapsort;

public class SortTask implements Runnable{
    int[] arr;
    public SortTask(int[] arr) {
        this.arr = arr;
    }
    @Override
    public void run() {
        HeapSort.heapSort(arr);
    }
}
