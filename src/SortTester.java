//START HERE, first real test is not working

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author David Rhoades
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter = new InsertionSort();

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // reverseOrderedStringTest


  @Test
  public void reverseOrderedIntegerTest() {
    Integer[] original = { 5, 4, 3, 2, 1, 0 };
    Integer[] expected = { 0, 1, 2, 3, 4, 5 };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // reverseOrderedIntegerTest

  @Test
  public void singletonIntegerTest() {
    Integer[] original = { 5 };
    Integer[] expected = { 5 };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // singletonIntegerTest

  @Test
  public void emptyTest() {
    Integer[] original = { };
    Integer[] expected = { };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // emptyTest

  @Test
  public void uniformTest() {
    Character[] original = { 'w', 'w', 'w' };
    Character[] expected = { 'w', 'w', 'w' };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // uniformTest

  @Test
  public void longTest() {
    Integer[] original = { 1, 2, 4, 5, 3, 9, 8, 7, 6, 10, 12, 11 };
    Integer[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // longTest
  
} // class SortTester
