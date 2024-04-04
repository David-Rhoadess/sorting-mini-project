import java.util.Comparator;
import java.util.Arrays;


/**
 * Sort using merge sort.
 *
 * @author DAvid Rhoades
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    sortHelper(values, order, 0, values.length);
  } // sort(T[], Comparator<? super T>

  public <T> void sortHelper(T[] values, Comparator<? super T> order, int lo, int hi) {
    if(hi - lo > 1) {
      int mid = (hi + lo) / 2;
      sortHelper(values, order, lo, mid);
      sortHelper(values, order, mid, hi);
      merge(values, lo, mid, hi, order);
    }
  } // sort(T[], Comparator<? super T>


  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   * outline taken from https://github.com/Grinnell-CSC207/lab-merge-sort/blob/main/src/MergeSorter.java
   */
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    T[] temp = Arrays.copyOf(vals, hi - lo);
    int midCpy = mid;
    int tempIndex = 0;
    int loCpy = lo;
    while(loCpy < mid && midCpy < hi) {
      if(comparator.compare(vals[loCpy], vals[midCpy]) < 0) {
        temp[tempIndex++] = vals[loCpy++];
      } // if
      else {
        temp[tempIndex++] = vals[midCpy++];
      } // else
    }
    while(loCpy < mid) {
      temp[tempIndex++] = vals[loCpy++];
    }
    while(midCpy < hi) {
      temp[tempIndex++] = vals[midCpy++];
    }
    for (int i = 0; i < hi - lo; i++) {
      vals[i + lo] = temp[i];
    }
  } // merge
} // class MergeSort
