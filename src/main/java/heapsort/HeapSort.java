package heapsort;

public class HeapSort {
    public static void heapSort(int[] array) {
        int n = array.length;

        // Build the heap (rearrange the array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // One by one extract an element from the heap
        for (int i = n - 1; i >= 0; i--) {
            // Move the current root to the end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int rootIndex) {
        int largest = rootIndex; // Initialize largest as root
        int leftChild = 2 * rootIndex + 1; // Left child index
        int rightChild = 2 * rootIndex + 2; // Right child index

        // If left child is larger than root
        if (leftChild < n && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // If right child is larger than largest so far
        if (rightChild < n && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // If largest is not root
        if (largest != rootIndex) {
            // Swap the root with the largest element
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }
}
