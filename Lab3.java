class Lab3 {
    public static void main(String[] args) {
    System.out.println("aboba");    
    }

    // quickSort:
    private void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i=1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }


    // mergeSort:
    public void mergeSort(int[] arr, int n) {
        if (n > 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n-mid];
        
        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        } 
        for (int i = mid; i < n; i++) {
            r[i - mid] = arr[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        
        merge(arr, l, r, mid, n - mid);
    }   

    private void merge(
        int[] arr, int[] l, int[] r, int left, int right) {
        
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            } 
        }
        while (i < left) {
            arr[k++] = l[i++];
        }
        while (j < right) {
            arr[k++] = r[j++];
        }
    }

    // comb sort
    private void combSort(int[] arr) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;
        
        while (gap != 1 || swapped == true) { 
            gap = getNextGap(gap); 
            swapped = false;
            
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    
                    swapped = true;
                }
            }
        }
    }

    private int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        if (gap < 1) {
            return 1;
        }
        return gap;
    }
}