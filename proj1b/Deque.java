/**
 * Deque API Interface
 *
 * Pronounce ("deck")  - is an irregular acronym of double-ended queue
 *
 * Features:
 *  - Dynamic sizes that can be expanded or contracted on both front and back.
 *
 * @author Dat Nguyen, hi@dat.works
 */


public interface Deque<T> {

  /**
   * Adds an item type T to the front of the deque
   */
  void addFirst(T item);

  /**
   * Adds an item type T to the back of the deque.
   */
  void addLast(T item);

  /**
   * Returns true if deque is empty, false otherwise.
   */
  default boolean isEmpty() {return size() == 0;}

  /**
   * Return the number of items in the deque
   */
  int size();

  /**
   * Removes and returns the item at the front of the deque. If no such item exists, returns null.
   */
  T removeFirst();

  /**
   * Removes and returns the item at the back of the deque. If no such item exists, returns null.
   */
  T removeLast();

  /**
   * Gets the item at the given index, where 0 is the front and 1 is the next item and so forth.
   * If no such items exists, return null.
   *
   * Note: Must not alter the deque
   */
  T get(int index);

  /**
   * Prints the items in the deque from first to last,
   * separated by a space. Once all items has been printed,
   * print out a new line
   */
  void printDeque();


}