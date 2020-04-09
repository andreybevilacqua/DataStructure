package exercises;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class LinkedListExample {

  private final static class MyLinkedList<E> {
    private final class Node<E> { // 12 bytes minimum
      private Node<E> previous, next; // 4 + 4
      private E e; // 4 += 24 bytes

      public Node(E e) {
        this.e = e;
      }
    }

    private Node<E> head, tail;

    public void add(E e) {
      if(head == null) head = tail = new Node<>(e);
      else {
        Node<E> node = new Node<>(e);
        node.previous = tail;
        tail.next = node;
        tail = node;
      }
    }
  }

  public static void main(String[] args) {
    // Almost never use this class.
    LinkedList<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    queue.remove(ThreadLocalRandom.current().nextInt(queue.size()));
    queue.sort(null);
  }
}
