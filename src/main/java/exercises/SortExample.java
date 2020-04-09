package exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
  }
}
