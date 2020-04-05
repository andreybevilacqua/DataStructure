package exercises;

public class ArraysExample {

  public static void main(String[] args) {
    // Object header: 12 bytes on 64-bit machine with compressedOops
    // 3(each value) x 4 bytes = 12
    // 12 + 4 + 12 = 28 +- 32 bytes. This 3 values on this array will take 32 bytes
    // The space complexity is linear: O(n)
    int[] values = {1,2,3};

    // Object header: 12 bytes on 64-bit machine with compressedOops
    // 1000(each value) x 4 bytes = 4000
    // 12 + 4 + 4000 = 4016
    // The space complexity is linear: O(n)
    int[] larger = {1,2,3};

    // 2 bytes per entry
    short[] smaller;

    // 1 byte per entry
    byte[] bytes;

    // Object array
    String[] names = new String[]{"John", "Dane", "Dora"};
    String[] newNames = new String[names.length + 1];
    System.arraycopy(names, 0, newNames, 0, names.length);
    newNames[3] = "Heinz";

    int[][][][] quadro = {{{ {1,2},{3,4} }}};
    System.out.println(quadro.getClass().getSuperclass());
    int[][][] sub = quadro[0];
    int[][] subsub = sub[0];
    int[] subsubsub = subsub[1];
    int subsubsubsub = subsubsub[1];
    System.out.println("subsubsubsub: " + subsubsubsub);
    // Favor single over multi-dim arrays.
  }
}
