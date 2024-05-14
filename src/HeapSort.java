import java.util.Arrays;
import java.util.Comparator;


public class HeapSort implements Sorter{
    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+

    /**
     * The one sorter you can access.
     */
    public static Sorter SORTER = new HeapSort();

    /**
     * the number of unsorted elements in the array
     */
    int size;



    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+

    /**
     * Create a sorter.
     */
    HeapSort() {
    } // HeapSort()

    // +---------+-----------------------------------------------------
    // | Methods |
    // +---------+


  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    this.size = values.length;
    for(int i = 1; i < this.size(); i++) {
      swapUp(i, order, values);
    }
    //all indices greater that sorted are sorted
    int sorted = this.size();
    while(sorted != 0) {
      swap(0, --sorted, values);
      size--;
      swapDown(0, order, values);
    }
  } // sort(T[], Comparator<? super T>)

  /**
   * get the number of unsorted elements in the array
  */
  public int size() {
    return this.size;
  }
  /**
   * gives the index of the left child of the "node" at index i
   */
  int leftChild(int i) {
    int temp = (2 * i) + 1;
    if(temp >= this.size()) {
      return -1;
    } else {
      return temp;
    }
  }

  /**
   * gives the index of the right child of the "node" at index i
   */
  int rightChild(int i) {
    int temp = (2 * i) + 2;
    if(temp >= this.size()) {
      return -1;
    } else {
      return temp;
    }
  }

  /**
   * gives the index of the parent of the "node" at index i
   */
  int parent(int i) {
    if (i == 0) {
      return -1;
    } else {
      return (i-1)/2;
    }
  }

  /**
   * swap the elements at two locations
   */
  @SuppressWarnings("unchecked")
  <T> void swap(int i, int j, T[] arr) {
    Object val = arr[i];
    arr[i] = arr[j];
    arr[j] = (T)val;
  }
  

  //assume lower priority value (returned by getPriority()) is higher priority 
  @SuppressWarnings("unchecked")
  <T> void swapUp(int cur, Comparator<? super T> order, T[] arr) {
    if (cur == 0) {
      return;
    } else if (order.compare((T)arr[cur], (T)arr[parent(cur)]) > 0) {
      swap(cur, parent(cur), arr);
      swapUp(parent(cur), order, arr);
    } else {
      return;
    }
  }
     
  //assume lower priority value (returned by getPriority()) is higher priority 
  @SuppressWarnings("unchecked")
  <T> void swapDown(int cur, Comparator<? super T> order, T[] arr) {
    int left = leftChild(cur);
    int right = rightChild(cur);
     if (leftChild(cur) == -1 && rightChild(cur) == -1) {
          return;
        } else if (rightChild(cur) == -1) {
          if (order.compare((T)arr[leftChild(cur)], (T)arr[cur]) > 0) {
            swap(cur, leftChild(cur), arr);
          } else {
            return;
          }
        } else if (order.compare((T)arr[leftChild(cur)], (T)arr[cur]) > 0 && order.compare((T)arr[leftChild(cur)], (T)arr[rightChild(cur)]) > 0) {
          swap(cur, leftChild(cur), arr);
          swapDown(leftChild(cur), order, arr);
        }else if (order.compare((T)arr[rightChild(cur)], (T)arr[cur]) > 0  && order.compare((T)arr[rightChild(cur)], (T)arr[leftChild(cur)]) > 0) {
          swap(cur, rightChild(cur), arr);
          swapDown(rightChild(cur), order, arr);
        } else {
          return;
        }
      }
}

