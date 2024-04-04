import java.util.Comparator;
import java.util.Arrays;


/**
 * Sort using merge sort.
 *
 * @author David Rhoades
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
    T[] temp = Arrays.copyOf(values, values.length);
    sortHelper(values, order, 0, values.length, temp);
  } // sort(T[], Comparator<? super T>

  /**
   * Recursive helper function for sort
   * 
   * @param <T> the type contained in values
   * @param values an array of type T
   * @param order a comarator for objects of type T
   * @param lo the lower (inclusive) bound for sorting
   * @param hi the upper (exclusive) bound for sorting
   * @param temp an array of type T[], the some lenth as the overall array being sorted
   */
  public <T> void sortHelper(T[] values, Comparator<? super T> order, int lo, int hi, T[] temp) {
    if(hi - lo > 1) {
      int mid = (hi + lo) / 2;
      sortHelper(values, order, lo, mid, temp);
      sortHelper(values, order, mid, hi, temp);
      merge(values, lo, mid, hi, order, temp);
    } // if
  } // sort(T[], Comparator<? super T>


  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   * outline taken from https://github.com/Grinnell-CSC207/lab-merge-sort/blob/main/src/MergeSorter.java
   */
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator, T[] temp) {
    int midCpy = mid;
    int tempIndex = lo;
    int loCpy = lo;
    while(loCpy < mid && midCpy < hi) {
      if(comparator.compare(vals[loCpy], vals[midCpy]) < 0) {
        temp[tempIndex++] = vals[loCpy++];
      } // if
      else {
        temp[tempIndex++] = vals[midCpy++];
      } // else
    } // while
    while(loCpy < mid) {
      temp[tempIndex++] = vals[loCpy++];
    } // while
    while(midCpy < hi) {
      temp[tempIndex++] = vals[midCpy++];
    } // while
    for (int i = lo; i < hi; i++) {
      vals[i] = temp[i];
    } // for
  } // merge
} // class MergeSort
