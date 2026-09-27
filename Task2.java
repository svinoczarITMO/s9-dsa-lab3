import java.util.Arrays;

class Task2 {

    public static void main(String[] args) {
        int[] original = {64, 34, 25, 12, 22, 11, 90, 5, 76, 43};

        int[] bucket = Arrays.copyOf(original, original.length);
        int[] heap = Arrays.copyOf(original, original.length);

        bucketSort(bucket);
        heapSort(heap);

        System.out.println("Исходный массив: " + Arrays.toString(original));
        System.out.println("Bucket Sort:     " + Arrays.toString(bucket));
        System.out.println("Heap Sort:       " + Arrays.toString(heap));
    }


    // Bucket Sort
    private static void bucketSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int min = arr[0];
        int max = arr[0];

        for (int value : arr) {
            if (value < min) {
                min = value;
            }

            if (value > max) {
                max = value;
            }
        }

        int bucketCount = max - min + 1;
        int[] buckets = new int[bucketCount];

        for (int value : arr) {
            buckets[value - min]++;
        }

        int index = 0;

        for (int i = 0; i < buckets.length; i++) {
            while (buckets[i] > 0) {
                arr[index++] = i + min;
                buckets[i]--;
            }
        }
    }


    // Heap Sort
    private static void heapSort(int[] arr) {
        int n = arr.length;

        // Построение max-heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Извлечение элементов из кучи
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int root) {
        int largest = root;

        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != root) {
            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
}