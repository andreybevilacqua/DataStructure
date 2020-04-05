package exercises;

import java.util.ArrayList;

public class ArrayListExample {

  public static void main(String[] args) {
    ArrayList<String> seasons = new ArrayList<>();
    seasons.add("spring");
    seasons.add("summer");
    seasons.add("autumn");
    seasons.add("winter");

    for (int i = 0; i < 10_000; i++) { // new size: 14053.
      seasons.add("Pretty warm");
    }
    System.out.println(seasons);

    seasons.removeIf(season -> season.equals("Pretty warm"));

    System.out.println(seasons); // the size still 14053.

    seasons.trimToSize(); // don't do this a lot

    seasons.clear(); // this is more common.
  }
}
