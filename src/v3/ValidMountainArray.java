package v3;

// https://leetcode.com/problems/valid-mountain-array/
public class ValidMountainArray {

  public boolean validMountainArray(int[] arr) {
    if (arr.length < 3) {
      return false;
    }
    int prev = arr[0];
    boolean isIncreasing = true;
    boolean beginsWithIncreasingOrder = arr[1] > arr[0];
    boolean endsWithDecreasingOrder = arr[arr.length - 1] < arr[arr.length - 2];
    for (int i = 1; i < arr.length; i++) {
      if (isIncreasing) {
        if (arr[i] < prev) {
          isIncreasing = false;
        } else if (arr[i] == prev) {
          return false;
        }
      } else {
        if (arr[i] >= prev) {
          return false;
        }
      }
      prev = arr[i];
    }
    return beginsWithIncreasingOrder && endsWithDecreasingOrder;
  }

  public static void main(String[] argv) {
    ValidMountainArray vma = new ValidMountainArray();
    int[] input = {0, 2, 3, 4, 5, 2, 1};
    System.out.println(vma.validMountainArray(input));
  }
}
