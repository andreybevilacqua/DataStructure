package exercises;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {

  public static void main(String[] args) {
    List<String> names = new CopyOnWriteArrayList<>(Arrays.asList("John", "Anton", "Heinz"));
    names.sort(null);
    for(Iterator<String> it = names.iterator(); it.hasNext();) {
      String name = it.next();
      System.out.println("Checking: " + name);
      if (name.contains("o")) names.remove(name);
    }
    System.out.println(names);
  }
}
