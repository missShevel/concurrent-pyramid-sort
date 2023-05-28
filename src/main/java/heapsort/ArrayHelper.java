package heapsort;

import java.util.Arrays;
import java.util.Random;

public class ArrayHelper {
    public static int[] generateIntArray(int size, int minValue, int maxValue) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }

        return array;
    }

    public static void print(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static int[] getArrayCopy(int[] array) {
        return Arrays.copyOf(array, array.length);
    }

    public static int[][] splitArray(int[] array, int numParts) {
        int length = array.length;
        int[][] fairParts = new int[numParts][];
        int partSize = length / numParts;
        int remainingElements = length % numParts;
        int currentIndex = 0;

        for (int i = 0; i < numParts; i++) {
            int currentPartSize = partSize;
            if (i < remainingElements) {
                currentPartSize++;
            }

            fairParts[i] = Arrays.copyOfRange(array, currentIndex, currentIndex + currentPartSize);
            currentIndex += currentPartSize;
        }

        return fairParts;
    }
    public static int[] mergeSortArrays(int[][] arrays) {
        if (arrays.length == 1) {
            return arrays[0];
        }

        int mid = arrays.length / 2;
        int[][] leftArrays = Arrays.copyOfRange(arrays, 0, mid);
        int[][] rightArrays = Arrays.copyOfRange(arrays, mid, arrays.length);

        int[] leftMerged = mergeSortArrays(leftArrays);
        int[] rightMerged = mergeSortArrays(rightArrays);

        return merge(leftMerged, rightMerged);
    }

    private static int[] merge(int[] leftArray, int[] rightArray) {
        int[] mergedArray = new int[leftArray.length + rightArray.length];
        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                mergedArray[k++] = leftArray[i++];
            } else {
                mergedArray[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            mergedArray[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            mergedArray[k++] = rightArray[j++];
        }

        return mergedArray;
    }

    public static boolean compareArrays(int[] array1, int[] array2) {
        // Check if the arrays have different lengths
        if (array1.length != array2.length) {
            return false;
        }

        // Sort the arrays to ensure element-wise comparison
        Arrays.sort(array1);
        Arrays.sort(array2);

        // Perform element-wise comparison
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }
}
