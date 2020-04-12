package exercises;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TreeSetExample {
  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
    Set<Integer> oddBetweenMinusTenAndTen = new TreeSet<>(Arrays.asList(-9, -7, -5, 5, -1, -3, 3, 1, 1, 1, 9, 7));
    System.out.println(oddBetweenMinusTenAndTen);

    // red-black tree
    // In a binary tree, adding values:
    /*
    0

    0
     \
      1

    0
     \
      1
       \
        2

    0
     \
      1
       \
        2
         \
          3

    5, 11, 2, 7, 8, 4
        5
     /    \
    2     11
     \    /
      4  7
         \
          8

     */

    TreeSet<Integer> million = IntStream
        .range(0, 1_000_000)
        .boxed()
        .collect(Collectors.toCollection(TreeSet::new));

//    System.out.println("million = " + million);

    System.out.println("log 2 1_000_000: " + Math.log(1_000_000) / Math.log(2));
    System.out.println("log 2 10_000_000: " + Math.log(10_000_000) / Math.log(2));

    List<Integer> values = IntStream
        .range(0, 1_000_000)
        .boxed()
        .collect(Collectors.toList());
    Collections.shuffle(values, new Random(0)); // Without shuffle, we have more depth in the tree.

    TreeMap<Integer, Object> millionMap = new TreeMap<>();
    values.forEach(i -> millionMap.put(i, "dummy"));

    System.out.println("millionMap.size() = " + millionMap.size());

    Field parentField = null;
    LongAccumulator maximumDepth = new LongAccumulator(Long::max, 0);
    for (Map.Entry<Integer, Object> entry : millionMap.entrySet()) {
      if(parentField == null) {
        parentField = entry.getClass().getDeclaredField("parent");
        parentField.setAccessible(true);
      }
      int level = 0;
      Object node = entry;
      while(node != null) {
        level++;
        node = parentField.get(node);
      }
      maximumDepth.accumulate(level);
    }
    System.out.println("maximumDepth = " + maximumDepth);
  }
}
