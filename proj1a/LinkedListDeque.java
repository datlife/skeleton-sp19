
public class LinkedListDeque<T> implements Deque<T> {
  private int size;
  private Node sentinel;

  private static class Node<T> {
    T data;
    Node next;
    Node prev;

    public Node(T data, Node next, Node prev) {
      this.data = data;
      this.next = next;
      this.prev = prev;
    }
  }

  public LinkedListDeque() {
    size = 0;
    sentinel = new Node<>(null, null, null);
    sentinel.next = sentinel;
    sentinel.prev = sentinel;
  }

  /**
   * Instantiate a new linked list by performing a deep copy of other
   * @param other: another linkedlist to be copied from.
   */
  public LinkedListDeque(LinkedListDeque other) {
    size = 0;
    sentinel = new Node<>(null, null, null);
    sentinel.next = sentinel;
    sentinel.prev = sentinel;

    // Performs a deep copy from other
    Node p = other.sentinel.next;
    while (p != other.sentinel) {
      addLast((T) p.data);
    }
  }


  @Override
  public void addFirst(T item) {
    Node newNode = new Node<>(item, sentinel.next, sentinel);

    if (sentinel.next != null)
      sentinel.next.prev = newNode;

    sentinel.next = newNode;
    sentinel.prev = (size == 0 ) ? newNode : sentinel.prev;
    size++;
  }

  @Override
  public void addLast(T item) {
    Node newNode = new Node<>(item, sentinel, sentinel.prev);

    if (sentinel.prev != sentinel)
      sentinel.prev.next = newNode;

    sentinel.prev = newNode;
    sentinel.next = (size == 0) ? newNode : sentinel.next;
    size++;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public T removeFirst() {
    if (isEmpty())
      throw new RuntimeException("Empty list");

    @SuppressWarnings("unchecked")
    T first = (T) sentinel.next.data;

    sentinel.next = sentinel.next.next;
    sentinel.next.prev = sentinel;
    size--;

    return first;
  }

  @Override
  public T removeLast() {
    if (isEmpty())
      throw new RuntimeException("Empty list");

    @SuppressWarnings("unchecked")
    T last = (T) sentinel.prev.data;

    sentinel.prev = sentinel.prev.prev;
    sentinel.prev.next = sentinel;
    size--;
    return last;
  }

  @Override
  public T get(int index) {
    if (index > size)
      throw new RuntimeException("Invalid index access.");

    Node curr = sentinel.next;
    for (int i = 0; i < index; i++)
      curr = curr.next;

    @SuppressWarnings("unchecked")
    T data = (T) curr.data;
    return data;
  }

  public T getRecursive(int index) {
    if (index > size)
      throw new RuntimeException("Invalid index access.");

    return getRecursiveHelper(this.sentinel.next, index);
  }

  private T getRecursiveHelper(Node node, int index) {
    if (index == 0 && node != this.sentinel)
      return (T) node.data;
    else if (index == 0)
      return null;
    else
      return getRecursiveHelper(node.next, --index);
  }

  @Override
  public void printDeque() {
    System.out.print("Deque: ");
    Node curr = sentinel.next;
    while (curr != sentinel) {
      System.out.print(curr.data);
      System.out.print(" ");
      curr = curr.next;
    }
    System.out.print("\n");
  }
}