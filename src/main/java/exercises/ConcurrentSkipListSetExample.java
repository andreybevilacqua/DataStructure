package exercises;

import java.util.Collections;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ThreadLocalRandom;

public class ConcurrentSkipListSetExample {
  public static void main(String[] args) {
    ConcurrentSkipListSet<Integer> numbers = new ConcurrentSkipListSet<>(Collections.reverseOrder());
    ThreadLocalRandom.current().ints(100).forEach(numbers::add);
    System.out.println("numbers.size() = " + numbers.size());
    System.out.println("numbers = " + numbers);
  }
}
