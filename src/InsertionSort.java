import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author David Rhoades
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+


 
  /**
   * sorts an array containing objects of type T using insertino sort
   * @param <T> type contained in the array
   * @param values array to be sorted
   * @param order Comparator to define the order that the list should be sorted in
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    for (int index = 1; index < values.length; index++) {
      for (int sortedIndex = index-1; sortedIndex >= 0; sortedIndex--) {
        if (order.compare(values[index], values[sortedIndex]) >= 0) {
          this.insertAt(values, values[index], index, sortedIndex);
          break;
        }
      }
    }
  } // sort(T[], Comparator<? super T>

  /**
   * inserts a value into an array at the specified index, shifting the rest of the array as needed. 
   * @param <T> type contained in the array
   * @param values array to be inserted into
   * @param val value of type T to be inserted
   * @param originalIndex the original (current) index of val
   * @param insertionIndex index in values where val should be inserted
   */
  public <T>void insertAt(T[] values, T val, int originalIndex, int insertionIndex) {
    // STUB
  }
} // class InsertionSort
