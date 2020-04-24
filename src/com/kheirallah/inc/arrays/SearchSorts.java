package com.kheirallah.inc.arrays;

public class SearchSorts {
    public static void main(String args[]) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr = {1, 5, 3, 4, 6, -1, 8, 9, 10};
        mergeSort(arr);
        arr = new int[]{1, 5, 3, 4, 6, -1, 8, 9, 10};
        quicksort(arr);
        System.out.println(binarySearch(sortedArray, 0, sortedArray.length - 1, 8));
    }

    //Time O(log(n))
    //Space O(1)
    public static int binarySearch(int[] arr, int start, int end, int value) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] == value) return mid;
            if (arr[mid] < value) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    //Time O(log(n))
    //Space O(log(n)) recursive stack calls
    public static int binarySearchRecursive(int[] arr, int start, int end, int value) {
        int mid = (start + end) / 2;
        if (arr[mid] == value) return mid;
        return arr[mid] < value ? binarySearchRecursive(arr, mid + 1, end, value) : binarySearchRecursive(arr, start, mid - 1, value);
    }

    //Time O(nlogn)
    //Space O(N) temp array
    public static void mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private static void mergeSortHelper(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSortHelper(arr, start, mid);
        mergeSortHelper(arr, mid + 1, end);
        merge(arr, start, end);
    }

    private static void merge(int[] arr, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        int[] temp = new int[arr.length];

        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) temp[index] = arr[left++];
            else temp[index] = arr[right++];
            index++;
        }

        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);
    }

    //Time O(nlogn) avg O(n^2) worst case, worst pivot every time
    //Space O(1)
    public static void quicksort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivot = arr[(start + end) / 2];
        int index = partition(arr, start, end, pivot);
        quickSortHelper(arr, start, index - 1);
        quickSortHelper(arr, index, end);
    }

    private static int partition(int[] arr, int start, int end, int pivot) {
        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            if (start <= end) swap(arr, start++, end--);
        }
        return start;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
