import java.util.Arrays;

public class HW1 {

  public static void main(String[] args) {
    // Q1
    int testResult1 = findMissing(new int[] { 0, 1, 2, 4, 5 });
    System.out.println(testResult1); // should output 3

    int testResult2 = findMissing(new int[] { 5, 0, 4, 3, 1 });
    System.out.println(testResult2); // should output 2

    int testResult3 = findMissing(new int[] {});
    System.out.println(testResult3); // should output 0

    int testResult4 = findMissing(new int[] { 9, 3, 5, 1, 4, 8, 2, 10, 0, 6 });
    System.out.println(testResult4); // should output 7

    // Q3
    System.out.println(countFives(123467890)); // should output 0
    System.out.println(countFives(555555)); // should output 6
    System.out.println(countFives(15354)); // should output 2

    // Q4
    int testResult5 = pickTrees(new int[] { 1, 2, 3, 4, 5 });
    System.out.println(testResult5); // should output 9

    int testResult6 = pickTrees(new int[] { 1, 3, 4, 3 });
    System.out.println(testResult6); // should output 6

    int testResult7 = pickTrees(new int[] { 5, 1, 4, 9 });
    System.out.println(testResult7); // should output 14
  }

  /*
   * I ask java to sort the array for me from lowest to greatest, which makes
   * getting our range as simple as grabbing the first and last values of the
   * array
   * I then begin to scan the range and return the first missing value.
   * This method cannot return multiple missing values, for example 2,3,6 it will
   * only give us 4, not 4 and 5
   */
  public static int findMissing(int[] arr) {
    // our error value is 0
    int r = 0;
    // check and halt if our array isn't useful.
    if (arr == null || arr.length == 0) {
      return r;
    }

    // sort our array, making it trivial to get the min and max values, and to then
    // scan the array. This is a massive timesink I bet.
    // Java's sort method's documentation that visual studio is pulling up for me
    // says it has a runtime of O(n log(n))
    Arrays.sort(arr);

    // loop through our sorted array and check if the next value maintains the +1
    // itteration. If it does not, then we return the next needed value to maintain
    // the range.
    for (int i = 0; i < arr.length; i++) {
      if (i + 1 == arr.length) {
        break;
      }
      if (arr[i] + 1 != arr[i + 1]) {
        r = arr[i] + 1;
        break;
      }
    }
    return r;
  }

  /*
   * I convert the given integer into a string and treat each place as a
   * character, if the first character is a 5 we return a 1 as our base case,
   * otherwise, we return a 0
   * if our string size is great than 1, we call this method and pass the string
   * along after removing the first character we just checked, and add together
   * all the returned values.
   */
  public static int countFives(int num) {
    // check if we are only checking a single element, and if that character is a 5.
    if (Integer.toString(num).length() == 1) {
      if (Integer.toString(num).charAt(0) == '5') {
        return 1;
      } else {
        return 0;
      }
    }
    // continue on and remove the first element to be checked and pass the rest down
    // the line to be cut up later.
    return countFives(Integer.parseInt(Integer.toString(num).substring(0, 1)))
        + countFives(Integer.parseInt(Integer.toString(num).substring(1)));
  }

  /*
   * I needed to overload the method and pass indecies so I can check the correct
   * parts of the array and cut it up properly to create a meaningful subproblem.
   * as such, this method only really works as a simple default call to the real
   * method.
   */
  public static int pickTrees(int[] arr) {
    return pickTrees(arr, 0);
  }

  /*
   * I check a given index to see which is greater, the sum of the adjacents, or the value in the middle, 
   * and when checking the further adjacent or middle value, recursivley go in and check all it's combinations
   * This is a brut force method that probably has a horrible runtime 
   * and I'm partially ashamed I've done this but I can't come up with a better way without assinging variables and using storage space.
   */
  public static int pickTrees(int[] arr, int index) {
    //handle our basecase and invalid input
    if (index >= arr.length || arr == null) {
      return 0;
    }
    //check and return whichever is greater, the sum of the adjacents and all ensueing subproblem adjacent sums, or the midddle value and all its potential sums.
    return Integer.max(arr[index] + pickTrees(arr, index + 2), pickTrees(arr, index + 1));
  }
}
