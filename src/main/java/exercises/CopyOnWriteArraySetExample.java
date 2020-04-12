package exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CopyOnWriteArraySetExample {
  public static void main(String[] args) {
    Set<Integer> oddBetweenMinusTenAndTen = new CopyOnWriteArraySet<>(Arrays.asList(-9, -7, -5, 5, -1, -3, 3, 1, 1, 1, 9, 7));
    System.out.println(oddBetweenMinusTenAndTen);

    System.out.println("log 2 1_000_000: " + Math.log(1_000_000) / Math.log(2));
    System.out.println("log 2 10_000_000: " + Math.log(10_000_000) / Math.log(2));

    for (int size = 1_000; size < 128_000; size*= 2) {
      List<Integer> list = IntStream
          .range(0, size)
          .boxed()
          .collect(Collectors.toList());

      long time = System.currentTimeMillis();
      try {
        CopyOnWriteArraySet<Integer> million = new CopyOnWriteArraySet<>(list);
        million.add(1);
      } finally {
        time = System.currentTimeMillis() - time;
        System.out.println("size = " + size + ", time = " + time + " ms");
      }
    }
  }
}
