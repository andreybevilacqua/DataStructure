package exercises;

import java.util.ArrayDeque;

public class ArrayDequeExample {
  public static void main(String[] args) {
    ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
    arrayDeque.add(1);
    arrayDeque.add(2);
    arrayDeque.add(3);
    arrayDeque.offer(3);
    arrayDeque.poll();
    arrayDeque.peek();
    arrayDeque.remove();
  }
}
