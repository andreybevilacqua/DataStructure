package exercises;

import java.util.concurrent.*;

public class SpecializedQueueExample {
  public static void main(String... args) throws InterruptedException {
    // Highly specialized queues:
    // DelayQueue, SynchronousQueue, LinkedTransferQueue:
    ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
    DelayQueue delayQueue;

    SynchronousQueue<Integer> sq = new SynchronousQueue<>(true);
    for (int i = 0; i < 10; i++) {
      int finalI = i;
      new Thread(() -> {
        try {
          sq.put(finalI);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
      Thread.sleep(10);
    }
    for (int i = 0; i < 10; i++) {
      System.out.println(sq.take());
    }

    ExecutorService executorService = new ThreadPoolExecutor(
        0,
        Integer.MAX_VALUE,
        60L,
        TimeUnit.SECONDS,
        new SynchronousQueue<>());

    LinkedTransferQueue linkedTransferQueue;
  }
}
