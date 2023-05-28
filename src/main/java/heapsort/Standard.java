package heapsort;

public class Standard {
    private int[] arr;
    private final int NUMBER_OF_PARTS;
    public Standard(int[] arr, int parts) {
        this.arr = arr;
        this.NUMBER_OF_PARTS = parts;
    }

    public int[] sort() {
        int[][] parts = ArrayHelper.splitArray(arr, NUMBER_OF_PARTS);
        System.out.println("Number of parts " + NUMBER_OF_PARTS );
        for (var part : parts) {
            var time1 = System.currentTimeMillis();
            HeapSort.heapSort(part);
            var time2 = System.currentTimeMillis();
            System.out.print("Time for part ");
            System.out.println(time2 - time1);

        }
        var time1 = System.currentTimeMillis();

        int[] mergedArray = ArrayHelper.mergeSortArrays(parts);

        var time2 = System.currentTimeMillis();

        System.out.print("Merge ");
        System.out.println(time2 - time1);


        return mergedArray;
    }
}
