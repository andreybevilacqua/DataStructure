package exercises;

import java.util.*;

public class IterationExample {

  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>(Arrays.asList("John", "Anton", "Heinz"));
    Vector a = new Vector();
    a.iterator();
    names.iterator();
    for (String name : names) {
      if (name.contains("o")) {
        names.remove(name);
      }
    }
    System.out.println(names);
  }
}
