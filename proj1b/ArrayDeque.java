/**
 * Implementation of List using array-based approach, also known as "Dynamic Array".
 *
 * Features:
 *  - Get()  arbitrary element in O(1).
 *
 * Cons:
 *  - Amortized cost to resize
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class ArrayDeque<T> implements Deque<T> {

  // Data holders
  private T[] items;

  // Size that user thinks the list is
  private int size = 0;

  // The actual size of the list. This variable can grow as user adding more items
  private int capacity = 8;

  // Resizing factor. This variable can be adjusted depending on current size of the ArrayDeque.
  private double refactor = 0.1;

  // Keep track of head and tail
  private int head = 0;


  ArrayDeque() {
    items = (T[]) new Object[capacity];
  }

  ArrayDeque(ArrayDeque other) {
    capacity = other.capacity;
    items = (T[]) new Object[capacity];

    for(int i = 0; i < other.size(); i++)
      addLast((T) other.get(i));

    refactor = other.refactor;
    size = other.size;

  }

  @Override
  public int size() {
    return size;
  }


  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   *
   * Magic sauce
   */
  private void resize() {
    if (size > 10000)
      this.refactor = 0.25;
    else if (size > 16)
      this.refactor = 0.2;
    else
      this.refactor = 0.1;

    T[] newItems = (T[]) new Object[(int) (this.size * this.refactor)];
    System.arraycopy(items, 0, newItems, 0, size);

    items = newItems;
  }

  private int minusOne(int index) {
    if (index == 0)
      return capacity - 1;
    else
      return --index;
  }

  @Override
  public void addFirst(T item) {
    if (this.size() > capacity)
      resize();

    // TODO
    items[minusOne(head)] = item;
  }

  @Override
  public void addLast(T item) {
    if (this.size() > capacity)
      resize();

    int lastIdx = size - (capacity - head);
    items[lastIdx] = item;
    this.size++;
  }

  @Override
  public T removeFirst() {
    if (isEmpty())
      throw new RuntimeException("Empty list");
    return items[0];
  }

  @Override
  public T removeLast() {
    if (isEmpty())
      throw new RuntimeException("Empty list");

    T lastItem = items[this.size() - 1];
    items[size--] = null;
    return lastItem;
  }

  public T getLast() {
    return items[this.size() - 1];
  }

  @Override
  public T get(int i) {
    if (i < 0 || i > this.size())
      return null;
    return items[i];
  }

  @Override
  public void printDeque() {

  }
}
