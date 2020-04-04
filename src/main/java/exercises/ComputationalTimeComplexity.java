package exercises;

public class ComputationalTimeComplexity {

  volatile static int value;

  public static void main(String... args) {
    for (int i = 0; i < 3; i++) {
      testAll();
    }
  }

  private static void testAll() {
    // Constant time: O(1) e.g hashing
    value = 42;

    // Linear time: O(n) e.g searching a list
    System.out.println("Linear Complexity");
    for(int n = 100_000_000; n <= 1_600_000_000 && n > 0; n*= 2) {
      linearComplexity(n);
    }

    // Quadratic time: O(n*n) e.g. bubble sort
    System.out.println("Quadratic Complexity");
    for(int n = 1_000; n <= 100_000 && n > 0; n*= 2) {
      quadraticComplexity(n);
    }

    // Logarithmic time: O(log n) e.g. tree search
    System.out.println("Logarithmic Complexity");
    for(long n = 1_000_000_000L; n <= 1_000_000_000_000L && n > 0; n*= 2) {
      logarithmicComplexity(n);
    }

    // Quasilinear time: O(n * log n) e.g. merge sort
  }

  private static void linearComplexity(int n) {
    long time = System.currentTimeMillis();
    for (int i = 0; i < n; i++) {
      value = i;
    }
    time = System.currentTimeMillis() - time;
    System.out.println(n + " time = " + time);
  }

  private static void quadraticComplexity(int n) {
    long time = System.currentTimeMillis();
    for (int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        value = i;
      }
    }
    time = System.currentTimeMillis() - time;
    System.out.println(n + " time = " + time);
  }

  private static void logarithmicComplexity(long n) {
    int steps = 0;
    long time = System.currentTimeMillis();
    for (long i = 1; i < n; i *= 2) {
      value = (int) i;
      steps++;
    }
    time = System.currentTimeMillis() - time;
    System.out.println(n + " time = " + time + " steps = " + steps);
  }
}
