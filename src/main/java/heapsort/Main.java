package heapsort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
         * 1. Get data from console (length of array, number of splits)
         * 2. Generate array
         * 3. Split array into parts
         * 4. Use heap sort for each of them
         * 5. Merge result arrays into one using merge sort
         * 6. Create parallel algorithm
         *  - Every heap sort for part should work for a part
         *  - If number of parts <= 8 run "1 thread - 1 task"
         *  - Else run "1 thread - at least one task" 8 threads is maximum
         * */
        ConsoleInput input = new ConsoleInput();
        var LENGTH = input.getUserInput("Enter length of array (default is 10000): ", 10000);
        var NUMBER_OF_PARTS = input.getUserInput("Enter number of parts (default is 5): ", 5);


        var array = ArrayHelper.generateIntArray(LENGTH, 0, 1000);
        var arrayCopy = ArrayHelper.getArrayCopy(array);
        var arrayCopy2 = ArrayHelper.getArrayCopy(array);

        var time1 = System.currentTimeMillis();
        var sequential = new Standard(arrayCopy, NUMBER_OF_PARTS);
        var result = sequential.sort();
        var time2 = System.currentTimeMillis();
        var sequentialTime = time2 - time1;

        var time3 = System.currentTimeMillis();
        var parallel = new Parallel(arrayCopy2, NUMBER_OF_PARTS);
        var result2 = parallel.sort();
        var time4 = System.currentTimeMillis();
        var parallelTime = time4 - time3;
        if (ArrayHelper.compareArrays(result, array) && ArrayHelper.compareArrays(result, result2)) {
            System.out.println("Sorting is correct");
        } else {
            System.out.println("Sorted arrays are different");
        }

        System.out.println("heapsort.Sequential took " + sequentialTime + "ms");
        System.out.println("heapsort.Parallel took " + parallelTime + "ms");

    }
}