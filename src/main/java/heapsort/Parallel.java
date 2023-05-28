package heapsort;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Parallel {
    private int[] arr;
    private final int NUMBER_OF_PARTS;

    public Parallel(int[] arr, int parts) {
        this.arr = arr;
        this.NUMBER_OF_PARTS = parts;
    }

    public int[] sort() {
        int[][] parts = ArrayHelper.splitArray(arr, NUMBER_OF_PARTS);

        int NUMBER_OF_THREADS = Math.min(NUMBER_OF_PARTS, 8);
        ExecutorService pool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (var part : parts) {
            pool.submit(new SortTask(part));
        }

        pool.shutdown();
        try {
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow();
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }

        int[] mergedArray = ArrayHelper.mergeSortArrays(parts);

        return mergedArray;
    }
}
