/**
 * This file is designed for CSE 8B FA19 PSA1. You need to find all bugs
 * inside this file. Good luck!
 * @author  CSE8B FA19 PA Team
 */

/**
 * This class is used to manipulate a given array. It can find the range,
 * average, deep-copy, print, sort and reverse the array. Have fun!
 */

public class FunWithIntArrays {
  private static final String SEPARATOR = ", ";

  /**
   * Return the range (largest - smallest element) of the input array.
   * @param  array input array to search for range.
   * @return       the difference between the array's max and min value.
   */
  public static int findRange(int array[]) {
    //short circuit protects null access
    if (array == null || array.length == 0)
      return 0;

    int max = array[0];
    int min = array[0];

    // iterate through the array to find max and min
    for (int i = 0; i < array.length; i++) {
      if (array[i] > max) {
        max = array[i];
      }

      if (array[i] < min) {
        min = array[i];
      }
    }

    return max - min;
  }

  /**
   * Return the average of elements in the input array.
   * @param  array input array to calculate the average from.
   * @return       the average of all numbers in the array.
   */
  public static double findAvg(int array[]) {
    // short circuit protects null access
    if (array == null || array.length == 0)
      return 0;

    double sum = 0;

    // sum up numbers in the array and caculate the average
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }

    double average = (sum / (array.length));

    return average;
  }

  /**
   * Return a deep copy of the input array.
   * @param  array input array to copy from.
   * @return       the newly copied array.
   */
  public static int[] arrayCopy(int[] array) {
    if (array ==null)
      return null;

    int[] result = new int[array.length];

    for (int i = 0; i < array.length; i++) {
      result[i] = array[i];
    }
    return result;
  }

  /**
   * Print all the numbers in the input array.
   */
  public static void printArray(int[] array) {
    if (array == null)
      return;



    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + ", ");
      }

      System.out.println();
  }

  /**
   * Reverse the input array in-place.
   * @param  array input array to reverse.
   * @return       none.
   */
  public static void reverseArray(int[] array) {
    if (array == null)
      return;

    for (int i = 0; i < array.length / 2; i++) {
      //swapping array[i] and array[array.length - i - 1]
      int  temp = array[i];
      array[i] = array[array.length - i - 1];
      array[array.length-i-1] = temp;
    }
  }

  /**
   * Sort the array in-place.
   * @param  array input array to sort.
   * @return       none.
   */
  public static void arraySort(int[] array) {
    if (array == null)
      return;

    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - i - 1; j++) {
        if (array[j] > array[j + 1]) {
          //swapping array[j] and array[j+1]
          int temp = array[j+1];
          array[j+1] = array[j ];
          array[j] = temp;
        }
      }
    }
  }
}
/** bugs
 * error: (int i = 0; i < array.length(); i++)
 * fix : (int i = 0; i < array.length; i++)
 * length is the final variable for array, array has no length() method call
 *
 *
 * error: if (array == null && array.length == 0)
 * fix change && to ||
 * logical error
 *
 * error: if (array = null)
 * fix change = to ==
 *
 * error: array[j] = temp;
 * fix :array[array.length-i-1] = temp;
 *
 * error : System.out.print(array[i]);
 *
 *       if (i != array.length - 1) {
 *         System.out.print(SEPARATOR);
 *       }
 * fix :for (int i = 0; i < array.length; i++) {
 *    System.out.print(array[i] + ", ");
 *   }
 *
 *   System.out.println();
 *
 * error : for (int i = 0; i <= array.length; i++)
 * fix: for (int i = 0; i < array.length; i++)
 * index out of bound
 *
 * error: for (int j = 0; j < array.length - i - 1; i++)
 * fix : for (int j = 0; j < array.length - i - 1; j++)
 *
 * error : int temp = array[j];
 *           array[j] = array[j + 1];
 *           array[j + 1] = temp;
 * fix : int temp = array[j+1];
 *      array[j + 1] = array[j];
 *      array[j] = temp;
 *  the switch order is wrong, logical error
 *
 *  error line 76 array[i] = result[i];
 *  fix result[i] = arrary[i]
 *
 *  error line 39 return max + min;
 *  fix : max -min
 *
 *  error line 59 double average = (sum / (array.length));
 *  fix double average = (sum / (array.length));
 * error line 52  int sum = 0;
 * fix : double sum =0
 * type error
 */