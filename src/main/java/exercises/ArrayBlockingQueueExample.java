package exercises;

import java.util.concurrent.*;

public class ArrayBlockingQueueExample {
  public static void main(String[] args) {
    ExecutorService pool =
        new ThreadPoolExecutor(
            10,
            100,
            1,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>()
        );

    for (int i = 0; i < 10_000; i++) {
      pool.submit(() -> {
        Thread.sleep(1_000);
        return null;
      });
    }
  }
}
