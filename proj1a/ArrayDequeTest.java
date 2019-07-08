import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {

  @Test
  public void createEmptyArrayDeque() {
    ArrayDeque d = new ArrayDeque();
    assertTrue(d.isEmpty());
  }

  @Test
  public void createNonEmptyArrayDeque() {
    ArrayDeque other = new ArrayDeque();
    other.addLast("Item1");
    other.addLast("Item2");

    ArrayDeque d = new ArrayDeque(other);
    assertEquals(2, d.size());
  }

  @Test
  public void addLastTest() {
    ArrayDeque d = new ArrayDeque();
    d.addLast("item 1");
    d.addLast("item 2");
    d.addLast("item 3");

    assertEquals(3, d.size());
    assertEquals("item 1", d.get(0));
    assertEquals("item 3", d.getLast());
  }
}
