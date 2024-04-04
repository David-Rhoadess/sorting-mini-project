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
    //print for debugging
    /*for (int i = 0; i < values.length; i++) {
      System.out.println("post:" + values[i]);
    }*/
    for (int index = 1; index < values.length; index++) {
      for (int tempIndex = index - 1; tempIndex >= 0; tempIndex--) {
        if (order.compare(values[tempIndex], values[index]) <= 0) {
          this.insertAt(values, index, tempIndex + 1);
          break;
        } else if(tempIndex == 0) {
          this.insertAt(values, index, tempIndex);
        } // if
      } // for
    } // for
  } // sort(T[], Comparator<? super T>

  /**
   * Shifts a value in an array from originalIndex to insertionIndex, shifting the rest of the array as needed. 
   * @param <T> type contained in the array
   * @param values array to be inserted into
   * @param originalIndex the original (current) index of val, must be greater than insertionIndex
   * @param insertionIndex index in values where val should be inserted
   */
  public <T>void insertAt(T[] values, int originalIndex, int insertionIndex) {
    T temp = values[originalIndex];
    for (int i = originalIndex; i > insertionIndex; i--) {
      values[i] = values[i - 1];
    } // for
    values[insertionIndex] = temp;
  } // insertAt(T[] values, int originalIndex, int insertionIndex)
} // class InsertionSort 