package exercises;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQueueExample {
  public static void main(String[] args) {
    Queue<Integer> clq = new ConcurrentLinkedQueue<>();

    // lifo or fifo or some hybrid.
    Queue<Integer> cld = new ConcurrentLinkedDeque<>();

    System.out.println(clq.offer(1));
    System.out.println(clq.add(2));
    System.out.println("clq.poll() = " + clq.poll());
    System.out.println("clq.poll() = " + clq.poll());

    System.out.println(clq.size()); // O(n)

  }
}
