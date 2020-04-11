package exercises;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class SortExample {

  public static void main(String... args) {
    List<Student> names = Arrays.asList(
        new Student(1,  "John", 56.0),
        new Student(2,  "John", 86.0),
        new Student(3,  "Heinz", 72.0),
        new Student(3,  "Anton", 56.0));
    names.sort(null);

    // by grade, best first
    names.sort((Comparator
        .comparingDouble(Student::getAverage).reversed())
        .thenComparing(Student::getName)
        .thenComparingInt(Student::getYear));

    System.out.println(names);

    List<Integer> numbers = fillWithLotsOfRandomValues();
    for (int i = 0; i < 10; i++) {
      testSortingSpeed(numbers);
    }
  }

  private static void testSortingSpeed(List<Integer> numbers) {
    List<Integer> arrayList = new ArrayList<>(numbers);
    List<Integer> parallelSortingArrayList = new ParallelSortingArrayList<>(numbers);

    sortList(arrayList);
    sortList(parallelSortingArrayList);
    System.out.println("Already sorted");
    for (int i = 0; i < 5; i++) {
      sortList(arrayList);
      sortList(parallelSortingArrayList);
    }
  }

  private static void sortList(List<Integer> list) {
    long time = System.currentTimeMillis();
    list.sort(null);
    long result = System.currentTimeMillis() - time;
    System.out.println(list.getClass().getSimpleName() + " time = " + result);
  }

  private static List<Integer> fillWithLotsOfRandomValues() {
    return ThreadLocalRandom
        .current()
        .ints(10_000_000)
        .parallel()
        .boxed()
        .collect(Collectors.toList());
  }
}
