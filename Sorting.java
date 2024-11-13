public class Sorting {

    public long selectionSort(int[] arr) {
        long comparisons = 0;
        int n = arr.length;

        for (int current = 0; current < n - 1; current++) {
            int indexOfMin = current;
            for (int index = current + 1; index < n; index++) {
                comparisons++;
                if (arr[index] < arr[indexOfMin]) {
                    indexOfMin = index;
                }
            }
            int temp = arr[current];
            arr[current] = arr[indexOfMin];
            arr[indexOfMin] = temp;
        }

        return comparisons;
    }

    public long mergeSort(int[] arr) {
        return mergeSortHelper(arr, 0, arr.length - 1);
    }

    private long mergeSortHelper(int[] arr, int first, int last) {
        long comparisons = 0;
        if (first < last) {
            int middle = (first + last) / 2;
            comparisons += mergeSortHelper(arr, first, middle);
            comparisons += mergeSortHelper(arr, middle + 1, last);
            comparisons += merge(arr, first, middle, middle + 1, last);
        }
        return comparisons;
    }

    private long merge(int[] arr, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int[] temp = new int[rightEnd - leftStart + 1];
        int left = leftStart, right = rightStart, index = 0;
        long comparisons = 0;

        while (left <= leftEnd && right <= rightEnd) {
            comparisons++;
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }

        while (left <= leftEnd) {
            temp[index++] = arr[left++];
        }

        while (right <= rightEnd) {
            temp[index++] = arr[right++];
        }

        System.arraycopy(temp, 0, arr, leftStart, temp.length);
        return comparisons;
    }

    public long quickSort(int[] arr) {
        return quickSortHelper(arr, 0, arr.length - 1);
    }

    private long quickSortHelper(int[] arr, int first, int last) {
        long comparisons = 0;
        if (first < last) {
            int[] result = split(arr, first, last);
            comparisons += result[1];
            comparisons += quickSortHelper(arr, first, result[0] - 1);
            comparisons += quickSortHelper(arr, result[0] + 1, last);
        }
        return comparisons;
    }

    private int[] split(int[] arr, int first, int last) {
        int pivot = arr[last];
        int i = first - 1;
        long comparisons = 0;

        for (int j = first; j < last; j++) {
            comparisons++;
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, last);
        return new int[]{i + 1, (int) comparisons};
    }

    public long randomQuickSort(int[] arr) {
        return randomQuickSortHelper(arr, 0, arr.length - 1);
    }

    private long randomQuickSortHelper(int[] arr, int first, int last) {
        long comparisons = 0;
        if (first < last) {
            int[] result = randomSplit(arr, first, last);
            comparisons += result[1];
            comparisons += randomQuickSortHelper(arr, first, result[0] - 1);
            comparisons += randomQuickSortHelper(arr, result[0] + 1, last);
        }
        return comparisons;
    }

    private int[] randomSplit(int[] arr, int first, int last) {
        int randomPivotIndex = first + (int) (Math.random() * (last - first + 1));
        swap(arr, randomPivotIndex, last);
        int pivot = arr[last];
        int i = first - 1;
        long comparisons = 0;

        for (int j = first; j < last; j++) {
            comparisons++;
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, last);
        return new int[]{i + 1, (int) comparisons};
    }

    public long heapSort(int[] arr) {
        long comparisons = 0;
        int n = arr.length;

        for (int index = n / 2 - 1; index >= 0; index--) {
            comparisons += reheapDown(arr, index, n - 1);
        }

        for (int index = n - 1; index >= 1; index--) {
            swap(arr, 0, index);
            comparisons += reheapDown(arr, 0, index - 1);
        }

        return comparisons;
    }

    private long reheapDown(int[] arr, int root, int bottom) {
        int maxChild;
        int leftChild = root * 2 + 1;
        int rightChild = root * 2 + 2;
        long comparisons = 0;

        if (leftChild <= bottom) {
            if (leftChild == bottom) {
                maxChild = leftChild;
            } else {
                comparisons++;
                if (arr[leftChild] <= arr[rightChild]) {
                    maxChild = rightChild;
                } else {
                    maxChild = leftChild;
                }
            }
            comparisons++;
            if (arr[root] < arr[maxChild]) {
                swap(arr, root, maxChild);
                comparisons += reheapDown(arr, maxChild, bottom);
            }
        }
        return comparisons;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
