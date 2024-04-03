import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author David Rhoades
 * outline taken from https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Sp/labs/quicksort.html
 * also referenced for implementation
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  

  // +----------------+----------------------------------------------
  // | Public methods |
  // +----------------+

  /**
   * Sort an array in place.
   *
   * @param vals, an array to sort.
   * @param order, the order by which to sort the values.
   * @return
   *    The same array, now sorted.
   * @pre
   *    order can be applied to any two values in vals.
   * @pre
   *    VALS = vals.
   * @post
   *    vals is a permutation of VALS.
   * @post
   *    For all i, 0 < i < vals.length,
   *      order.compare(vals[i-1], vals[i]) <= 0
   */
  @Override
  public <T> void sort(T[] vals, Comparator<? super T> order) {
    quicksort(vals, order, 0, vals.length);
  } // sort(T[], Comparator<? super T>

  /**
   * Partition an array.
   */
  public <T> void partition(T[] values, Comparator<? super T> order) {
    partition(values, order, 0, values.length);
  } // partition(T[], Comparator<? super T>)

  // +----------------------+---------------------------------------
  // | Semi-private methods |
  // +----------------------+

  /**
   * Sort the subarray of T given by [lb..ub) in place using
   * the Quicksort algorithm.
   */
  <T> void quicksort(T[] values, Comparator<? super T> order, int lb, int ub) {
    if(ub - lb >= 1) {
      int pivotLoc = partition(values, order, lb, ub);
      quicksort(values, order, lb, pivotLoc);
      quicksort(values, order, pivotLoc, ub);
    }
  } // quicksort(T[], Comparator<? super T>, lb, ub)

  /**
   * Select a pivot and partition the subarray from [lb .. ub) into 
   * the following form.
   *
   * <pre>
   * ---+-----------------+-+----------------+---
   *    | values <= pivot |p| values > pivot |
   * ---+-----------------+-+----------------+---
   *    |                 |                  |
   *    lb                pivotLoc           ub
   * </pre>
   *
   * @return pivotLoc.
   */
  public static <T> int partition(T[] arr, Comparator<? super T> order, int lb, int ub) {
    int pivotLoc = (lb + ub) / 2;
    T pivot = arr[pivotLoc];
    arr[pivotLoc] = arr[lb];
    arr[lb] = pivot;
    int small = lb + 1;
    int large = ub - 1;
    T temp;
    while(small != large) {
      while(small < large && order.compare(arr[small], pivot) < 0) {
        small++;
      } // while 
      while(large > small && order.compare(arr[large], pivot) > 0) {
        large--;
      } // while
      if (small < large) {
        temp = arr[small];
        arr[small++] = arr[large];
        arr[large--] = temp;
      } // if
    } // while
    arr[lb] = arr[small -1];
    arr[small - 1] = pivot;
    return small - 1;
  } // partition(T[], Comparator<? super T>, lb, ub)
} // class Quicksort
