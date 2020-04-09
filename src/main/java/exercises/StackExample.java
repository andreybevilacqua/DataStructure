package exercises;

import java.util.Stack;

public class StackExample {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    stack.add("Tomatoes");
    stack.add("Carrots");
    stack.add("Cucumbers");

    String veggie;
    while (!stack.isEmpty()) {
      veggie = stack.pop();
      System.out.println(veggie);
    }
  }
}
