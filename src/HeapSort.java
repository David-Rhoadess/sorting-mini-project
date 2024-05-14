import java.util.Arrays;
import java.util.Comparator;

import org.junit.runner.manipulation.Sorter;

public class HeapSort {
    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+

    /**
     * The one sorter you can access.
     */
    public static Sorter SORTER = new HeapSort();

    /**
     * the number of elements in the array to be sorted
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
      swapUp(i);
    }
    //all indices greated that sorted are sorted
    int sorted = this.size();
    while(sorted != 0) {
      swap(0, sorted--);
      swapDown(0);
    }
  } // sort(T[], Comparator<? super T>)

  /**
   * get the number of elements in the heap
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
      return null;
    } else {
      return temp
    }
  }

  /**
   * gives the index of the right child of the "node" at index i
   */
  int rightChild(int i) {
    int temp = (2 * i) + 2
    if(temp >= this.size()) {
      return null;
    } else {
      return temp;
    }
  }

  /**
   * gives the index of the parent of the "node" at index i
   */
  int parent(int i) {
    if (1 = 0) {
      return null;
    } else {
      return (i-1)/2;
    }
  }

  /**
   * swap the elements at two locations
   */
  void swap(int i, int j, T[] vals) {
    T val = vals[i];
    vals[i] = vals[j];
    vals[j] = val;
  }
  

  //assume lower priority value (returned by getPriority()) is higher priority 
  void swapUp(int i) {
    if (i = 0) {
      return;
    } else if (values[i].getPriority() < values[parent(cur)].getPriority()) {
      swap(cur, parent(cur));
      swapUp(parent(cur));
    } else {
      return;
    }
  }
     
  //assume lower priority value (returned by getPriority()) is higher priority 
  void swapDown(int cur) {
    int curPriority = values[cur].getPriority();
     if (leftChild(cur) == null && rightChild(cur) == null) {
          return;
        } else if (rightChild(cur) == null && values[leftChild(cur)].getPriority() < curPriority) {
          swap(cur, leftChild(cur));
        } else if (values[leftChild(cur)].getPriority < curPriority  && values[leftChild(cur)].getPriority() <= values[rightChild(cur)].getPriority()) {
          swap(cur, leftChild(cur));
          swapDownHelper(leftChild(cur));
        }else if (values[rightChild(cur)].getPriority < curPriority  && values[rightChild(cur)].getPriority() < values[leftChild(cur)].getPriority()) {
          swap(cur, rightChild(cur));
          swapDownHelper(rightChild(cur));
        } else {
          return;
        }
      }
}
