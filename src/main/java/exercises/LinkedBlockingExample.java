package exercises;

import java.util.concurrent.*;

public class LinkedBlockingExample {
  public static void main(String[] args) {
    long time = System.currentTimeMillis();
    while (true) {
      try {
        ExecutorService pool = Executors.newWorkStealingPool();
        for (int i = 0; i < 10_000_000; i++) {
          pool.submit(() -> {});
        }
        pool.shutdown();
        if (!pool.awaitTermination(1, TimeUnit.SECONDS)) break;
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        time = System.currentTimeMillis() - time;
        System.out.println("time = " + time + " ms");
      }
    }
  }
}
