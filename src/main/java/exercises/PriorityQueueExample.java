package exercises;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Spliterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class PriorityQueueExample {

  public static class Person implements Comparable<PriorityQueueExample.Person> {
    private final String name;

    public Person(String name) {
      this.name = name;
    }

    public int compareTo(PriorityQueueExample.Person o) {
      return name.compareTo(o.name);
    }
  }

  public static void main(String... args) {
    PriorityQueue<Person> priorityQueue = new PriorityQueue<>();

    int[] vals = {1,2,2,3,3,5};
    PriorityQueueExample.Person[] persons = {
        new PriorityQueueExample.Person("John"),
        new PriorityQueueExample.Person("Alison"),
        new PriorityQueueExample.Person("Alison"),
        new PriorityQueueExample.Person("Alison"),
        new PriorityQueueExample.Person("Peter"),
    };
    System.out.println("Before enqueue");
    Stream.of(persons).forEach(System.out::println);

    Stream.of(persons).forEach(priorityQueue::add);
    System.out.println("Deque order");
    while (!priorityQueue.isEmpty()) {
      System.out.println("priorityQueue.remove() = " + priorityQueue.remove());
    }

    System.out.println(priorityQueue.spliterator().hasCharacteristics(Spliterator.ORDERED));
    System.out.println(priorityQueue.spliterator().hasCharacteristics(Spliterator.SORTED));

    ExecutorService priorityPool = new ThreadPoolExecutor(
        10, 10, 0, TimeUnit.SECONDS, new PriorityBlockingQueue<>()
    );

    priorityPool.submit(new PrioritizedRunnable(() -> System.out.println("Im really important 1"), 0));
    priorityPool.submit(new PrioritizedRunnable(() -> System.out.println("Im not really important"), 10));
    priorityPool.submit(new PrioritizedRunnable(() -> System.out.println("Im really important 2"), 0));

  }

  private static class PrioritizedRunnable implements Runnable, Comparable<PrioritizedRunnable> {

    private final Runnable job;
    private final int priority;

    private PrioritizedRunnable(Runnable job, int priority) {
      this.job = job;
      this.priority = priority;
    }

    @Override
    public void run() {
      job.run();
    }

    @Override
    public int compareTo(PrioritizedRunnable o) {
      return Integer.compare(priority, o.priority);
    }
  }
}
