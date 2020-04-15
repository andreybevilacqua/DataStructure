package exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapExample {

  public static class Person {
    private final String name;
    private final int day;
    private final int month;
    private final int year;

    public Person(String name, int day, int month, int year) {
      this.name = name;
      this.day = day;
      this.month = month;
      this.year = year;
    }

    public int hashCode() {
      return (name.hashCode() << 16) ^ (day << 12) ^ (month << 8) ^ year;
    }

    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Person person = (Person) o;

      if (day != person.day) return false;
      if (month != person.month) return false;
      if (year != person.year) return false;
      if (name != null ? !name.equals(person.name) : person.name != null) return false;

      return true;
    }
  }

  public static void main(String... args) {
    HashMap<String, Integer> numbers = new HashMap<>(
        Map.of("one", 1, "two", 2, "sixteen", 16)
    );
    HashMap<String, Integer> numbers2 = new HashMap<>(
        Map.ofEntries(
            Map.entry("one", 1),
            Map.entry("two", 2),
            Map.entry("three", 3))
    );

    HashMap<String, List<Integer>> superstition = new HashMap<>();
    add(superstition, "unlucky", 13);
    add(superstition, "unlucky", 7);
    add(superstition, "unlucky", 3);
    add(superstition, "lucky", 65);
    add(superstition, "lucky", 60);
    add(superstition, "lucky", 5);

    superstition.forEach((k,v) -> System.out.println(k + " -> " + v));
  }

  private static void add(HashMap<String, List<Integer>> superstition, String key, int number) {
    superstition
        .computeIfAbsent(key, k -> new ArrayList<>())
        .add(number);
  }
}
