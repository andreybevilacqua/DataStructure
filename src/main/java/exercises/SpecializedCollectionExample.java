package exercises;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class SpecializedCollectionExample {
  public static void main(String[] args) {
    // Highly specialized collections:
    // EnumSet, EnumMap, IdentityHashMap,
    // Properties, WeakHashMap:
    EnumSet<Thread.State> states = EnumSet.allOf(Thread.State.class);
    System.out.println("states = " + states);
    states.remove(Thread.State.RUNNABLE);
    System.out.println("states = " + states);

    EnumMap<Thread.State, LongAdder> timesInState = new EnumMap<>(Thread.State.class);
    Map<Thread.State, LongAdder> threadSafeEnumMap =
        Collections.synchronizedMap(new EnumMap<>(Thread.State.class));

    IdentityHashMap<String, Integer> map = new IdentityHashMap<>();
    map.put("Hello", 42);
    System.out.println("map.get(\"Hello\") = " + map.get(new String("Hello")));

    Map<IdentityKey<String>, Integer> map2 = new ConcurrentHashMap<>();
    map2.put(new IdentityKey<>("Hello"), 42);
    System.out.println("map2.get(new IdentityKey<>(\"Hello\")) = " + map2.get(new IdentityKey<>("Hello")));

    Properties properties = new Properties();
    int parallelism =
        Integer.parseInt(System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "42"));
    int parallelismBetter =
        Integer.getInteger("java.util.concurrent.ForkJoinPool.common.parallelism", 42);

    WeakHashMap<String, Integer> wmpa = new WeakHashMap<>();
  }

  private static class IdentityKey<K> {
    private final K key;

    public IdentityKey(K key) {
      this.key = key;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      IdentityKey<?> that = (IdentityKey<?>) o;
      return key == that.key;
    }

    @Override
    public int hashCode() {
      return System.identityHashCode(key);
    }
  }
}
