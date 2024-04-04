/**
 * Sort using Quicksort.
 *
 * @author David Rhoades
 * Source: https://www.geeksforgeeks.org/timsort/, modified by ChatGPT to implement Sorter, see more in the README
 */
import java.util.Comparator;

public class RhoadesDavidSort implements Sorter {
    
    private static final int MIN_MERGE = 32;

    @Override
    public <T> void sort(T[] values, Comparator<? super T> order) {
        timSort(values, values.length, order);
    }

    /**
     * timSort algorithm
     * 
     * @param <T> the type contained in arr
     * @param arr the array to be sorted
     * @param n the length of arr to be sorted
     * @param order a comparator for objects of type T
     */
    private <T> void timSort(T[] arr, int n, Comparator<? super T> order) {
        int minRun = minRunLength(n);

        // Sort individual subarrays of size RUN
        for (int i = 0; i < n; i += minRun) {
            insertionSort(arr, i, Math.min((i + MIN_MERGE - 1), (n - 1)), order);
        }

        // Merge subarrays in bottom-up manner
        for (int size = minRun; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                if (mid < right) {
                    merge(arr, left, mid, right, order);
                }
            }
        }
    }

    /**
     * Calculates the minimum effective run length for insertionSort based on n and MIN_MERGE
     */
    private <T> int minRunLength(int n) {
        assert n >= 0;
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    /**
     * sort using insertion sort
     * 
     * @param <T> the type contained in arr
     * @param arr an array containing objects of type T
     * @param left the lower (inclusive) bound of the section to be sorted
     * @param right the upper (exclusive) bound of the section to be sorted
     * @param order comparator for objects of type T
     */
    private <T> void insertionSort(T[] arr, int left, int right, Comparator<? super T> order) {
        for (int i = left + 1; i <= right; i++) {
            T temp = arr[i];
            int j = i - 1;
            while (j >= left && order.compare(arr[j], temp) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    /**
     * sort using merge sort
     * 
     * @param <T> type contained in arr
     * @param arr array to be sorted
     * @param l the lower (inclusive) bound of the section to be sorted
     * @param m the midpoint of the section of arr to be sorted
     * @param r the upper (exclusive) bound of the section to be sorted
     * @param order comparator for type T
     */
    private <T> void merge(T[] arr, int l, int m, int r, Comparator<? super T> order) {
        int len1 = m - l + 1, len2 = r - m;
        T[] left = (T[]) new Object[len1];
        T[] right = (T[]) new Object[len2];
        System.arraycopy(arr, l, left, 0, len1);
        System.arraycopy(arr, m + 1, right, 0, len2);

        int i = 0, j = 0, k = l;
        while (i < len1 && j < len2) {
            if (order.compare(left[i], right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < len1) {
            arr[k++] = left[i++];
        }

        while (j < len2) {
            arr[k++] = right[j++];
        }
    }
}