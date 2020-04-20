package exercises;

import java.util.Arrays;

public class ArraysUtilExample {
  public static void main(String[] args) {
    System.out.println(Integer.compareUnsigned(
        0x8912_1123,
        0x1324_1324
    ));
    int[][] a = {{1,2,3}, {4}};
    int[][] b = {{1,2,3}, {4}};
    System.out.println("a.equals(b) = " + Arrays.deepEquals(a, b));
    System.out.println("Arrays.deepToString(a) = " + Arrays.deepToString(a));

    int[] squares = new int[10_000];
    Arrays.setAll(squares, i -> i * i);
    System.out.println("Arrays.toString(squares) = " + Arrays.toString(squares));
  }
}
