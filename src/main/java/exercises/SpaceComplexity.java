package exercises;

public class SpaceComplexity {

  public static void main(String... args) {
    // This is a linked relation between objects
    Object o = new Object();
    Holder holder = new Holder("Hello");
    holder.setNext(new Holder("World"));

    for(Holder h = holder; h != null; h = h.next) {
      System.out.println(h.o);
    }
  }

  // Each Holder holds an object and a link relation to the next Holder
  static class Holder {
    private Object o;
    private Holder next;

    public Holder(Object o) {
      this.o = o;
    }

    public void setNext(Holder next) {
      this.next = next;
    }
  }
}
