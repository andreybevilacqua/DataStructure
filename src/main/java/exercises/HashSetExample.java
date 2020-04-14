package exercises;

import samples.Pixel;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
  public static void main(String... args) {
    Set<String> oddBelowTwenty = new HashSet<>();
    oddBelowTwenty.add("1");
    oddBelowTwenty.add("3");
    oddBelowTwenty.add("5");
    oddBelowTwenty.add("7");
    oddBelowTwenty.add("9");
    oddBelowTwenty.add("11");
    oddBelowTwenty.add("13");
    oddBelowTwenty.add("15");
    oddBelowTwenty.add("17");
    oddBelowTwenty.add("19");
    System.out.println("oddBelowTwenty = " + oddBelowTwenty);

    samples.Student s1 = new samples.Student(1, "Peter", 33);
    samples.Student s2 = new samples.Student(1, "Peter", 98);
    Set<samples.Student> students = new HashSet<>();
    students.add(s1);
    students.add(s2);
    System.out.println("students = " + students);

    int x = 1024;
    int y = 768;

    System.out.println("(x * y) = " + (x * y)); // 786.432 different options
    Set<Integer> uniqueHashCodes = new HashSet<>();
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        uniqueHashCodes.add(new Pixel(i, j).hashCode());
      }
    }
    // We should have the same number (786.432)
    // But instead we have a total of 32.481 registers inside of the HashSet.
    // This is because of the hashCode() implementation in Pixel class.
    System.out.println("uniqueHashCodes = " + uniqueHashCodes.size());
  }
}
